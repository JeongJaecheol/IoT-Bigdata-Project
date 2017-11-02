package bigdata3.dao;

import java.util.List;
import java.util.Map;

import bigdata3.domain.IoTDevice;
 
public interface IoTDeviceDao {
  List<IoTDevice> selectList(Map<String,Object> valueMap);
  IoTDevice selectOne(String serialNo);
  int insert(IoTDevice device);
  int updateUserNo(IoTDevice device);
  int delete(String serialNo);
}
