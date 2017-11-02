package bigdata3.dao;

import java.util.List;
import java.util.Map;

import bigdata3.domain.IoTUser;
 
public interface IoTUserDao {
  List<IoTUser> selectList(Map<String,Object> valueMap);
  IoTUser selectOne(String email);
  IoTUser selectOneByUserNo(int userNo);
  IoTUser selectOneByEmailPassword(Map<String,Object> valueMap);
  int insert(IoTUser user);
  int updateToken(IoTUser user);
  int delete(String email);
}
