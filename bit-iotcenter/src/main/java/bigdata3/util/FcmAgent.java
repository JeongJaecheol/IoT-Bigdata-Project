/* FCM 서버에 메시지를 전송
 * 
 */
package bigdata3.util;

import java.io.OutputStream;
import java.io.StringWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class FcmAgent {

  public String send(FcmMessage topic) throws Exception {
    
    URL url = new URL("https://fcm.googleapis.com/fcm/send");
    HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
    con.setRequestProperty("Content-Type", "application/json");
    con.setRequestProperty("Authorization", "key=AAAA-4_EgSE:APA91bGPjZ2tNnhad-G2PdMp7XS48T67hedDqP1UkFFIrL6Qg3PiJcT_zZneDvRbeU4s7N4BMl9PYylzkhhb8lZgoyGSxKTWkc5-063uE1zFHSsA6sme_49Y5j4rH0TH8_OjzlPm_9jX");
    
    con.setDoOutput(true);
    con.setDoInput(true);
    
    OutputStream out = con.getOutputStream();
    
    Map<String,Object> message = new HashMap<>();
    message.put("to", topic.getTo());
     
    Map<String,Object> data = new HashMap<>();
    data.put("message", topic.getMessage());
    message.put("data", data);
    
    Map<String,Object> notification = new HashMap<>();
    notification.put("title", topic.getTitle());
    notification.put("text", topic.getText());
    message.put("notification", notification);

    String json = new Gson().toJson(message);
    
    out.write(json.getBytes("UTF-8"));
    out.flush(); 
    out.close();
    
    Scanner in = new Scanner(con.getInputStream());
    StringWriter strOut = new StringWriter();
    while (in.hasNext()) {
      strOut.write(in.nextLine());
    }
    in.close();
    
    return strOut.toString();
  }
}






