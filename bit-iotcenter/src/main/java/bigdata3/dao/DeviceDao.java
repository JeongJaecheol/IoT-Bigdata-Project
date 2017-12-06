package bigdata3.dao;

import java.util.List;
import java.util.Map;

import bigdata3.domain.Device;

public interface DeviceDao {
  List<Device> selectListByType(Map<String,Object> params);
}
