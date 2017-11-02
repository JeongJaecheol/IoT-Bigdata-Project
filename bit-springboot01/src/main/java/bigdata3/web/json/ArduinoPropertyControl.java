package bigdata3.web.json;


import static bigdata3.web.json.JsonResult.*;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("json.ArduinoPropertyControl")
@RequestMapping("/arduino2/json")
public class ArduinoPropertyControl {
  @Autowired ServletContext application;
  
  @RequestMapping("get/{serialNo}/{name}")
  public Object get(
      @PathVariable String serialNo, 
      @PathVariable String name) throws Exception {
    
    String propName = serialNo + "." + name;
    String value = (String) application.getAttribute(propName);
    if (value == null) {
      value = "";
      application.setAttribute(propName, value);
    }
    return new JsonResult(STATE_SUCCESS, value);
  }
  
  @RequestMapping("set/{serialNo}/{name}/{value}")
  public Object set(
      @PathVariable String serialNo, 
      @PathVariable String name, 
      @PathVariable String value) throws Exception {
    
    String propName = serialNo + "." + name;
    application.setAttribute(propName, value);
    return new JsonResult(STATE_SUCCESS, propName + "=" + value);
  }

}









