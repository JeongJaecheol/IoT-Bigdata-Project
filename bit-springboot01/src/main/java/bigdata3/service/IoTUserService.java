package bigdata3.service;

import java.util.List;

import bigdata3.domain.IoTUser;

public interface IoTUserService {
  List<IoTUser> list(int pageNo, int pageSize);
  IoTUser getByEmailPassword(String email, String password);
  void add(IoTUser user);
  IoTUser get(String email);
  void updateToken(IoTUser user);
  void remove(String email);

  // 기존에 이미 구현한 클래스에 영향을 주지 않고 살며시 규칙을 추가하기  
  default IoTUser get(int userNo) {return null;};
}
