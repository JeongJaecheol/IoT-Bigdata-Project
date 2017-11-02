package bigdata3.web.json;


import static bigdata3.web.json.JsonResult.STATE_FAIL;
import static bigdata3.web.json.JsonResult.STATE_SUCCESS;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bigdata3.domain.IoTUser;
import bigdata3.service.IoTUserService;

@RestController("json.IoTUserControl")
@RequestMapping("/user/json")
public class IoTUserControl {
  
  @Autowired ServletContext application;
  
  @Autowired IoTUserService userService;
  
  //@RequestMapping(path="add", method=RequestMethod.POST)
  //@PostMapping("add") //=> 위 애노테이션의 단축 표현 
  @RequestMapping(path="add") //=> 테스트 할 때는 GET/POST 모두 가능하게 하자!
  public Object add(IoTUser param) throws Exception {
    
    if (userService.get(param.getEmail()) != null) {
      return new JsonResult(STATE_FAIL, "존재하는 이메일입니다.");
    }
    
    userService.add(param);
    
    return new JsonResult(STATE_SUCCESS, param.getNo());
  }
  
  @GetMapping("get")
  public Object get(String email) {
    
    IoTUser user = userService.get(email);
    if (user == null) {
      return new JsonResult(STATE_FAIL, "존재하지 않는 이메일입니다.");
    }
    
    return new JsonResult(STATE_SUCCESS, user);
  }
  
  //@GetMapping("login")
  @RequestMapping("login")
  public Object login(IoTUser param) {
    
    IoTUser member = userService.getByEmailPassword(param.getEmail(), param.getPassword());
    if (member == null) {
      return new JsonResult(STATE_FAIL, "존재하지 않거나 이메일 및 암호가 다릅니다.");
    }
    
    member.setToken(param.getToken());
    
    userService.updateToken(member);
    
    return new JsonResult(STATE_SUCCESS, "로그인 성공!");
  }
  
}

/*
[사용자 등록]
http://localhost:8080/user/json/add?email=user6@test.com&password=1111

[사용자 조회]
http://localhost:8080/user/json/get?email=user6@test.com

[사용자 로그인]
http://localhost:8080/user/json/login?email=user6@test.com&password=1111&token=1234

 */









