package bigdata3.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailAgent {
  @Autowired JavaMailSender mailSender;
  
  public void send(String to, String subject, String text) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("jyeom15@gmail.com");
    message.setTo(to);
    message.setSubject(subject);
    message.setText(text);
    
    mailSender.send(message);
    
    /* 주의 사항
     * => 구글의 경우 기본적으로 보안수준이 낮은 앱에 대해 접근을 허용하지 않는다.
     *    임시적으로 풀고 싶다면 다음 사이트로 접속하여 보안 수준을 조정하라!
     * => https://www.google.com/settings/security/lesssecureapps
     */
  }
}
