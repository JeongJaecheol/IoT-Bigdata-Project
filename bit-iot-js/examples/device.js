var awsIot = require('aws-iot-device-sdk');

var device = awsIot.device({
   keyPath: 'led1.private.key',
  certPath: 'led1.cert.pem',
    caPath: 'root-CA.crt',
  clientId: 'clien0001',
      host: 'a222gw6ygk2ekk.iot.ap-northeast-2.amazonaws.com'
});

device
  .on('connect', function() {
    console.log('connect');
    device.subscribe('topic_1');
    device.publish('topic_2', JSON.stringify({ test_data: 1}));
  });

device
  .on('message', function(topic, payload) {
    console.log('message', topic, payload.toString());
  });
