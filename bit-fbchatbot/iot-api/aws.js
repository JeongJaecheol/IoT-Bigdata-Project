const awsIot = require('aws-iot-device-sdk');

// 장비 목록 
const devices = {};

const dev01 = awsIot.device({
    keyPath: "/home/ec2-user/vars/aws-iot/dev01/dev01.private.key", 
    certPath: "/home/ec2-user/vars/aws-iot/dev01/dev01.cert.pem",
    caPath: "/home/ec2-user/vars/aws-iot/root-CA.crt", 
    clientId: "fbchatbot", 
    host: process.env.DEV01_HOST 
});

dev01.on('connect', function() {
    console.log('AWS IoT의 dev01 장비와 연결 되었음!');
    // 연결에 성공하면 연결된 장비를 목록에 추가한다.
    devices['dev01'] = dev01;
});

function publish(deviceName, topic, dataObj) {
    devices[deviceName].publish(topic, JSON.stringify(dataObj));
}

module.exports = {
     publish
};