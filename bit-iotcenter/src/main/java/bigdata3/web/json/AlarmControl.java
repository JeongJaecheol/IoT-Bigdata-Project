package bigdata3.web.json;


import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bigdata3.service.DeviceService;
import bigdata3.util.FcmAgent;

@RestController("json.AlarmControl")
@RequestMapping("/alarm/json")
public class AlarmControl {
  
  @Autowired ServletContext application;
  
  //@Autowired IoTUserService userService;
  
  @Autowired DeviceService deviceService;
  
  @Autowired FcmAgent fcmAgent;
    
  @RequestMapping("change/{serialNo:[\\.\\w]+}")
  public Object change(
      @PathVariable String serialNo,
      @RequestParam String message) throws Exception {
/*   
    //=> 제품 번호를 이용하여 장비 정보를 가져온다.
    //IoTDevice device = deviceService.get(serialNo);

    //=> 장비가 등록되어 있지 않다면,
    if (device == null) {
      return new JsonResult(STATE_FAIL, "등록되지 않은 장비입니다.");
    }
    
    //=> 장비의 주인이 등록되어 있지 않다면,
    if (device.getUserNo() < 1) {
      return new JsonResult(STATE_FAIL, "장비의 사용자가 설정되지 않았습니다.");
    }
    
    //=> 장비의 사용자 정보를 가져온다.
    IoTUser user = userService.get(device.getUserNo());
    
    //=> 사용자의 토큰 정보가 없으면,
    if (user.getToken() == null) {
      return new JsonResult(STATE_FAIL, 
          "사용자의 토큰 값이 유효하지 않습니다. 앱으로 다시 로그인 하거나, "
          + "앱을 다시 설치하여 로그인 하시기 바랍니다.");
    }
    
    //=> FCM 서버에게 알림 메시지를 보낸다.
    String result = fcmAgent.send(new FcmMessage(
        user.getToken(), //=> to
        message, //=> message 
        "IoT 경고", //=> title
        "감지장치(" + serialNo + ")에 변화가 발생했습니다.")); //=> text
    return new JsonResult(STATE_SUCCESS, result);
 */
    return null;
  }
  
 
}


/* 사용법
[센서의 입력 값이 변경되었을 때]
=> http://localhost:8080/alarm/json/change/제품번호?message=내용
 */

/* 전체 테스트 하는 순서
0) DB 초기화
   - 부모 테이블의 데이터를 지우기 전에 자식 테이블의 데이터부터 제거 한다.
   - 데이터 삭제
     => delete from iot_device;
     => delete from iot_user;
     
1) 장비 등록
   - reset.py를 실행하여 장비를 재등록한다.
   - 또는 웹 브라우저에서 다음 URL을 직접 실행해도 된다.
     => http://localhost:8080/device/json/reset/시리얼번호
   - DB 확인
     => select * from iot_device;
     
2) 사용자 등록
   - 웹 브라우저에서 다음 URL을 직접 실행한다.
     => http://localhost:8080/user/json/add?email=이메일&name=이름&password=암호
   - DB 확인
     => select * from iot_user;
     
3) FCM 서버로부터 알림을 받을 수 있도록 토큰 등록
   - 앱에서 로그인을 수행한다.
   - DB 확인
     => select * from iot_user where email='이메일'
     
4) 장비의 소유주 설정
   - 웹 브라우저에서 다음 URL을 실행하여 장비를 등록한다.
     => http://localhost:8080/device/form.html 
     => 로그인할 때 사용한 이메일과 장비의 시리얼번호를 입력한 후 등록한다.
   - DB 확인
     => select * from iot_device;

5) 센서 변경 상태 알리기
   - 웹 브라우저에서 다음 URL을 실행한다.
     => http://localhost:8080/alarm/json/change/시리얼번호?message=간단한알림내용
   - 확인
     => 앱에서 알림 메시지가 왔는지 확인한다.
     => 앱이 떠 있는 상태일 때는 토스트가 즉시 출력될 것이다.
 */






