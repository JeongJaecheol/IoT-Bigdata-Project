package bigdata3.web.json;


import static bigdata3.web.json.JsonResult.STATE_SUCCESS;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bigdata3.domain.IoTDevice;
import bigdata3.service.IoTDeviceService;

@RestController("json.IoTDeviceControl")
@RequestMapping("/device/json")
public class IoTDeviceControl {

  @Autowired ServletContext application;
  
  @Autowired IoTDeviceService deviceService;
  
  @RequestMapping("reset/{serialNo:[\\.\\w]+}")
  public Object reset(@PathVariable String serialNo) throws Exception {
    
    //=> 기존에 등록된 장비를 제거한다.
    deviceService.remove(serialNo);
    
    //=> 장비를 등록한다.
    IoTDevice device = new IoTDevice();
    device.setSerialNo(serialNo);
    
    deviceService.add(device);
    
    return new JsonResult(STATE_SUCCESS, device.toString());
  }
  
}

/* 사용법
[장비등록]
=> http://localhost:8080/device/json/reset/시리얼번호
 */







