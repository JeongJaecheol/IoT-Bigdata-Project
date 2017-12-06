-- iotcenter.sql

create table iot_user(
  uno int not null,
  email varchar(50),
  name varchar(50),
  pwd varchar(200),
  fbuid varchar(50)
);

-- primary key 설정
alter table iot_user
  add primary key (uno);
  
-- primary key 'no' 컬럼을 자동 증가 컬럼으로 설정
alter table iot_user
  modify column uno int not null auto_increment;

-- 페이스북 사용자 ID는 중복되지 않게 설정
alter table iot_user
  add unique (fbuid);


create table iot_device (
  dno int not null,
  sn varchar(50) not null,
  dev_type varchar(50) not null,
  uno int not null
);

-- 장비의 상태를 저장할 컬럼을 추가
alter table iot_device
  add column status varchar(100);

alter table iot_device 
  -- primary key 컬럼 설정
  add primary key (dno),
  -- 장비의 시리얼 번호가 중복되지 않게 설정
  add unique (sn);

-- 장비 번호는 자동으로 증가하게 설정
alter table iot_device
  modify column dno int not null auto_increment;

-- uno 컬럼을 iot_user 테이블의 PK를 참조하도록 FK로 설정
alter table iot_device
  add foreign key (uno) references iot_user(uno);

  
-- 사용자 등록
insert into iot_user(uno, name, fbuid) values(1, 'hong', '101');
insert into iot_user(uno, name, fbuid) values(2, 'leem', '102');
insert into iot_user(uno, name, fbuid) values(3, 'yoo', '103');
  
-- 장비 시리얼 번호 등록
insert into iot_device(sn, dev_type, uno) values('1001', 'led', 1);
insert into iot_device(sn, dev_type, uno) values('1002', 'led', 2);
insert into iot_device(sn, dev_type, uno) values('1003', 'led', 3);  
  
  
-- 페이스북 ID를 이용하여 led 장비의 상태 정보 가져오기
select u.uno, u.name, d.sn, d.dev_type, d.status 
from iot_device d left outer join iot_user u on d.uno = u.uno
where u.fbuid = '101' and d.dev_type = 'led';
  
  
  
  
  



