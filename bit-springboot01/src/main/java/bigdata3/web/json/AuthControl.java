package bigdata3.web.json;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bigdata3.domain.Member;
import bigdata3.service.TeacherService;

import static bigdata3.web.json.JsonResult.*;

// 이 페이지 컨트롤러는 응답으로 JSON 데이터를 리턴하기 때문에
// @RestController를 붙여야 한다.
@RestController("json.AuthControl")
@RequestMapping("/auth/json") // 기존의 페이지 컨트롤러와 구분하기 위해 URL을 변경한다.
public class AuthControl {
  @Autowired TeacherService teacherService;
  
  @RequestMapping("login")
  public Object login(
      String email, 
      String password, 
      @RequestParam(defaultValue="teacher") String userType,
      HttpSession session) throws Exception {
    
    Member member = null;
    if (userType.equals("teacher")) {
      member = teacherService.getByEmailPassword(email, password);
    }
    
    if (member != null) { 
      session.setAttribute("loginMember", member);
      return new JsonResult(STATE_SUCCESS, member);
    } 
    
    return new JsonResult(STATE_FAIL, null);
  }
  
  @RequestMapping("logout")
  public Object logout(HttpServletRequest req, HttpServletResponse res) throws Exception {
    req.getSession().invalidate();  
    return new JsonResult(STATE_SUCCESS, null);
  }  
}









