package bigdata3.web;


import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import bigdata3.domain.Device;
import bigdata3.service.DeviceService;
import bigdata3.util.EmailAgent;

@Controller
@RequestMapping("/iot/")
public class DeviceControl {
  
  @Autowired ServletContext application;
  
  @Autowired EmailAgent emailAgent;
  
  @Autowired DeviceService deviceService;
  
  @RequestMapping("{deviceType}/status/{fbUserId}")
  public void status(
      @PathVariable String deviceType,
      @PathVariable String fbUserId,
      Model model) throws Exception {
    
    //=> 장비의 상태 정보를 가져온다. 
    List<Device> devices = deviceService.list(fbUserId, deviceType);
    
    model.addAttribute("result", devices);
  }
  
  
  
}









