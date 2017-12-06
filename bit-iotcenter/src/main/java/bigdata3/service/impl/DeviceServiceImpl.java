package bigdata3.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bigdata3.dao.DeviceDao;
import bigdata3.domain.Device;
import bigdata3.service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService {
  @Autowired DeviceDao deviceDao;
  
  @Override
  public List<Device> list(String fbUserId, String deviceType) {
    
    HashMap<String,Object> valueMap = new HashMap<>();
    valueMap.put("fbUserId", fbUserId);
    valueMap.put("deviceType", deviceType);
    
    return deviceDao.selectListByType(valueMap);
  }
  
}







