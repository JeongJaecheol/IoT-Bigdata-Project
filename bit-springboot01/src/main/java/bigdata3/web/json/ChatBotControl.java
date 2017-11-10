package bigdata3.web.json;


import static bigdata3.web.json.JsonResult.*;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("json.ChatBotControl")
@RequestMapping("/chatbot/json")
public class ChatBotControl {
  @Autowired ServletContext application;
  
  @RequestMapping("led/{state}")
  public Object setLED(@PathVariable String state) throws Exception {
    if (state.equals("on")) {
      return new JsonResult(STATE_SUCCESS, state);
      
    } else if (state.equals("off")){
      return new JsonResult(STATE_SUCCESS, state);
      
    } else {
      return new JsonResult(STATE_FAIL, state);
    }
  }
  
}









