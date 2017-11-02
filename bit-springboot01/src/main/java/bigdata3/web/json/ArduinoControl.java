package bigdata3.web.json;


import static bigdata3.web.json.JsonResult.*;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("json.ArduinoControl")
@RequestMapping("/arduino/json")
public class ArduinoControl {
  @Autowired ServletContext application;
  
  @RequestMapping("getLED")
  public Object getLED() throws Exception {
    String state = (String) application.getAttribute("led.state");
    if (state == null) {
      state = "off";
      application.setAttribute("led.state", state);
    }
    return new JsonResult(STATE_SUCCESS, state);
  }
  
  @RequestMapping("setLED/{state}")
  public Object setLED(@PathVariable String state) throws Exception {
    if (state.equals("on") || state.equals("off")) {
      application.setAttribute("led.state", state);
      return new JsonResult(STATE_SUCCESS, state);
      
    } else {
      return new JsonResult(STATE_FAIL, state);
    }
  }
  
  @RequestMapping("getVolume")
  public Object getVolume() throws Exception {
    Integer value = (Integer) application.getAttribute("volume");
    if (value == null) {
      value = 0;
      application.setAttribute("volume", value);
    }
    return new JsonResult(STATE_SUCCESS, value);
  }
  
  @RequestMapping("setVolume/{value}")
  public Object setVolume(@PathVariable int value) throws Exception {
    if (value >= 0 && value <= 100) {
      application.setAttribute("volume", value);
      return new JsonResult(STATE_SUCCESS, value);
    } else {
      return new JsonResult(STATE_FAIL, "0 ~ 100 값만 유효합니다.");
    }
  }
  
  @RequestMapping("setVolumeControl/{value}")
  public Object setVolumeControl(@PathVariable String value) throws Exception {
    application.setAttribute("volume.control", value);
    return new JsonResult(STATE_SUCCESS, value);
  }
  
  @RequestMapping("getVolumeControl")
  public Object getVolumeControl() throws Exception {
    String value = (String) application.getAttribute("volume.control");
    if (value == null) {
      value = "hardware";
      application.setAttribute("volume.control", value);
    }
    return new JsonResult(STATE_SUCCESS, value);
  }
}









