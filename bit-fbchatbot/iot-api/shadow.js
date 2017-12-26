const awsIot = require('aws-iot-device-sdk');

// 섀도우를 등록할 장비명
const thingName = 'dev01';

// AWS IoT 서버에 등록된 Thing 정보를 바탕으로 Shadow 관리자를 준비시킨다.
var thingShadows = awsIot.thingShadow({
    keyPath: "dev01.private.key", 
    certPath: "dev01.cert.pem",
    caPath: "root-CA.crt", 
    clientId: "client2", 
    host: "a222gw6ygk2ekk.iot.ap-northeast-2.amazonaws.com" 
});

// Thing의 섀도우 제어 장비가 준비되었을 때 호출될 함수 등록
thingShadows.on('connect', function() {
    console.log('섀도우 관리자가 준비되었다.');
    thingShadows.register(thingName, {}, function() {
        console.log('섀도우에 연결하였음!');
    });
});

// 지정된 타임아웃 시간이 경과했을 때 호출될 함수 등록
thingShadows.on('timeout',
    function(thingName, clientToken) {
       console.log('received timeout on '+thingName+
                   ' with token: '+ clientToken);
});

function update(desiredState) {
    thingShadows.update(thingName, {state: {desired: desiredState}});
}

module.exports = {
    update
};