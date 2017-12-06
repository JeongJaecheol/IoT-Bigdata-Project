package bigdata3.web;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bigdata3.domain.Member;
import bigdata3.service.TeacherService;

@Controller
@RequestMapping("/auth")
public class AuthControl {
  @Autowired TeacherService teacherService;
  
  @RequestMapping("form")
  public void form() {}
  
  @RequestMapping("login")
  public String login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    String userType = req.getParameter("userType");
    String email = req.getParameter("email");
    String password = req.getParameter("password");
    
    Member member = null;
    if (userType.equals("teacher")) {
      member = teacherService.getByEmailPassword(email, password);
    }
    
    if (member != null) { 
      HttpSession session = req.getSession();
      session.setAttribute("loginMember", member);
      String saveEmail = req.getParameter("saveEmail");
      if (saveEmail != null) {
        Cookie cookie2 = new Cookie("email", email);
        cookie2.setMaxAge(60 * 60 * 24 * 7); 
        resp.addCookie(cookie2);
      } else {
        Cookie cookie2 = new Cookie("email", "");
        cookie2.setMaxAge(0);
        resp.addCookie(cookie2);
      }
      
      return "redirect:../teacher/list.do";
      
    } else {
      return "auth/fail";
    }
  }
  
  @RequestMapping("logout")
  public String logout(HttpServletRequest req, HttpServletResponse res) throws Exception {
    req.getSession().invalidate();  
    return "redirect:../auth/login.do";
  }  
}









