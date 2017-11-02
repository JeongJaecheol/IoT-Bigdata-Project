package bigdata3.web;


import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import bigdata3.domain.IoTDevice;
import bigdata3.domain.IoTUser;
import bigdata3.service.IoTDeviceService;
import bigdata3.service.IoTUserService;
import bigdata3.util.EmailAgent;

@Controller
@RequestMapping("/device/")
public class IoTDeviceControl {
  
  @Autowired ServletContext application;
  
  @Autowired EmailAgent emailAgent;
  
  @Autowired IoTDeviceService deviceService;
  
  @Autowired IoTUserService userService;
  
  @RequestMapping("add")
  public void add(String email, String serialNo, Model model) throws Exception {
    
    //=> 회원정보를 가져온다.
    IoTUser user = userService.get(email);
    if (user == null) {
      model.addAttribute("result", IoTConstants.NO_MEMBER);
      return;
    }
    
    //=> 서버에 등록되어 있는 장비를 가져온다. 
    IoTDevice device = deviceService.get(serialNo);
    
    //=> 서버에 등록되어 있는 장비가 없다면 사용자에게 알린다.
    if (device == null) {
      model.addAttribute("result", IoTConstants.NO_DEVICE);
      return;
    }
    
    //=> 주인이 설정된 장비라면
    if (device.getUserNo() > 0) {
      model.addAttribute("result", IoTConstants.USED_DEVICE);
      return;
    }
    
    //=> 장비의 주인으로 회원 번호를 설정한다.
    device.setUserNo(user.getNo());
    deviceService.changeOwner(device);
    model.addAttribute("result", IoTConstants.SUCCESS);
  }
  
  
  
}









