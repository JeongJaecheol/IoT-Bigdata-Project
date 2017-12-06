package bigdata3.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bigdata3.dao.IoTDeviceDao;
import bigdata3.domain.IoTDevice;
import bigdata3.service.IoTDeviceService;

@Service
public class IoTDeviceServiceImpl implements IoTDeviceService {
  @Autowired IoTDeviceDao deviceDao;
  
  @Override
  public List<IoTDevice> list(int pageNo, int pageSize) {
    HashMap<String,Object> valueMap = new HashMap<>();
    valueMap.put("startIndex", (pageNo - 1) * pageSize);
    valueMap.put("pageSize", pageSize);
    
    return deviceDao.selectList(valueMap);
  }
  
  @Override
  public IoTDevice get(String serialNo) {
    return deviceDao.selectOne(serialNo);
  }
  
  @Override
  public void add(IoTDevice device) {
    deviceDao.insert(device);
  }
  
  @Override
  public void changeOwner(IoTDevice device) {
    deviceDao.updateUserNo(device);
  }
  
  @Override
  public void remove(String serialNo) {
    deviceDao.delete(serialNo);
  }
}







