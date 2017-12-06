package bigdata3.web.json;


import static bigdata3.web.json.JsonResult.STATE_FAIL;
import static bigdata3.web.json.JsonResult.STATE_SUCCESS;

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("json.ChatBotControl")
@RequestMapping("/chatbot/json")
public class ChatBotControl {
  @Autowired ServletContext application;
  
  @RequestMapping("led/{state}")
  public Object setLED(
          @PathVariable String state, 
          @RequestParam String senderID) throws Exception {
    
    HashMap<String,String> dataMap = new HashMap<>();
    dataMap.put("senderID", senderID);
    dataMap.put("state", state);
    
    if (state.equals("on")) {
      return new JsonResult(STATE_SUCCESS, dataMap);
      
    } else if (state.equals("off")){
      return new JsonResult(STATE_SUCCESS, dataMap);
      
    } else {
      return new JsonResult(STATE_FAIL, dataMap);
    }
  }
  
}









