// AWS IoT의 Gateway에 메시지를 보내는 예제
// => 메시지를 보내는 것을 "발행(publish)"이라고 표현한다.

// AWS에서 제공하는 nodeJS 모듈을 로딩한다.
var awsIot = require('aws-iot-device-sdk');

// AWS IoT 서버에 등록된 Thing 정보를 바탕으로 장비를 준비시킨다.
var device = awsIot.device({
    /* AWS 서버에 Thing을 생성한 후 만든 인증서의 개인키 파일*/
    keyPath: "dev01.private.key", 

    /* AWS 서버에 Thing을 생성한 후 만든 인증서의 사물인증서 파일*/
    certPath: "dev01.cert.pem",

    /* 사물에 대해 발행한 인증서를 검증해 줄 
       "인증서를 발행한 회사"의 인증서 파일*/
    caPath: "root-CA.crt", 
   
    /* 다른 클라이언트와 구분하기 위한 임의의 ID */
    clientId: "client1", 

    /* AWS에 등록한 Thing을 가리키는 URL. 
       AWS IoT 사물 관리 페이지에서 "상호작용" 메뉴에서 
       HTTPS의 RestAPI를 요청할 때 사용할 Thing의 URL이다.*/
    host: "a222gw6ygk2ekk.iot.ap-northeast-2.amazonaws.com" 
 });

// 이 프로그램이 AWS IoT에 등록한 Thing과 연결되었을 때 호출될 메서드 추가
device.on('connect', function() {
    // 이 함수를 호출되었다는 것은 AWS IoT의 Thing과 연결되었다는 의미다.
    console.log('connect');

    // 연결되면 'topic_1'이라는 사서함을 구독하겠다고 선언한다.
    // => 즉 지금부터 연결된 Thing의 'topic_1'이라는 사서함에 
    //    메시지가 오면 받겠다는 의미다.
    device.subscribe('topic_1');
    console.log('topic_1의 사서함 구독 시작')
});

// 구독하기로 설정한 사서함에 메시지가 도착할 때 마다 
// AWS IoT 서버에 이 프로그램에 알려준다.
// 그때 호출될 메서드를 추가한다.
device.on('message', function(topic, payload) {
    console.log('사서함 메시지 도착');
    console.log('사서함 이름:', topic);
    console.log('받은 메시지:', payload.toString());
    console.log('-------------------------');
});