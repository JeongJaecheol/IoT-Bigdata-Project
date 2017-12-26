// AWS IoT의 Thing Shadow 에 값을 설정하고 꺼내는 방법

// AWS에서 제공하는 nodeJS 모듈을 로딩한다.
var awsIot = require('aws-iot-device-sdk');

// 섀도우를 등록할 장비명
const thingName = 'dev01';

// AWS IoT 서버에 등록된 Thing 정보를 바탕으로 Shadow 관리자를 준비시킨다.
var thingShadows = awsIot.thingShadow({
    /* AWS 서버에 Thing을 생성한 후 만든 인증서의 개인키 파일*/
    keyPath: "dev01.private.key", 

    /* AWS 서버에 Thing을 생성한 후 만든 인증서의 사물인증서 파일*/
    certPath: "dev01.cert.pem",

    /* 사물에 대해 발행한 인증서를 검증해 줄 
       "인증서를 발행한 회사"의 인증서 파일
       즉 인증 기관에 대한 인증서 파일*/
    caPath: "root-CA.crt", 
   
    /* 다른 클라이언트와 구분하기 위한 임의의 ID */
    clientId: "client2", 

    /* AWS에 등록한 Thing을 가리키는 URL. 
       AWS IoT 사물 관리 페이지에서 "상호작용" 메뉴에서 
       HTTPS의 RestAPI를 요청할 때 사용할 Thing의 URL이다.*/
    host: "a222gw6ygk2ekk.iot.ap-northeast-2.amazonaws.com" 
 });

// Thing의 섀도우 제어 장비가 준비되었을 때 호출될 함수 등록
thingShadows.on('connect', function() {
    console.log('섀도우 관리자가 준비되었다.');
    
    // 지정한 Thing에 대해 섀도우 연결을 요청한다.
    // => Shadow 연결에 성공한다면 설정된 함수가 호출될 것이다.
    thingShadows.register(thingName, {}, function() {
        console.log('섀도우에 연결하였음!');
        
        // 장비가 준비되면 일단 섀도우 설정된 값을 가져온다.
        console.log('섀도우에 설정된 값 조회를 요청한다.')
        thingShadows.get('dev01');
        /*
        // 섀도우가 생성되면 섀도우에 값을 저장할 수 있다.
        // update(Thing이름, 값)
        */
    });
    
});

// Thing의 Shadow에 대해 명령을 지시하고 그 명령을 수행한 후에 호출될 함수 등록
thingShadows.on('status', 
    function(thingName, stat, clientToken, stateObject) {
        if ((stat === "rejected") && (stateObject.code === 404)) {
            // 섀도우에 값이 없다면 기본 값을 설정한다.
            console.log('섀도우에 값이 없어서 기본 값을 설정하였음!');
            thingShadows.update(thingName, {
                state: {
                    desired: {
                        led: "off"
                    }}});
        } else {
            console.log('received '+stat+' on '+thingName+': '+
                   JSON.stringify(stateObject));
        }
});

// Shadow의 상태가 변경되었을 때 
// 부가적으로 발생되는 이벤트가 발생하는 데 그 때 호출 될 메서드를 등록한다.
thingShadows.on('delta', 
    function(thingName, stateObject) {
       console.log('received delta on '+thingName+': '+
                   JSON.stringify(stateObject));
});

// 지정된 타임아웃 시간이 경과했을 때 호출될 함수 등록
thingShadows.on('timeout',
    function(thingName, clientToken) {
       console.log('received timeout on '+thingName+
                   ' with token: '+ clientToken);
});