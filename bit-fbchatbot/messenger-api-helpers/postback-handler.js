const api = require('./api')

// postback을 받았을 때 그 postback을 처리할 함수를 보관하는 객체
const postbackHandler = {};

// postback을 처리할 함수를 등록한다.
const addPostback = (postback, handler) => {
    postbackHandler[postback] = handler;
}

// 등록된 메시지 핸들러를 찾아서 리턴한다.
const getHandler = (postback) => {
    return postbackHandler[postback];
};

addMessage('/led', (recipientId) => {
    var messageData = {
      recipient: {
        id: recipientId
      },
      message: {
        "attachment":{
          "type":"template",
          "payload":{
            "template_type":"button",
            "text":"LED 스위치",
            "buttons":[
              {
                "type":"postback",
                "title":"ON",
                "payload":"/led/on"
              },
              {
                "type":"postback",
                "title":"OFF",
                "payload":"/led/off"
              }
            ]
          }
        }
      }
    };
  
    api.callMessagesAPI(messageData);
});

addMessage('/led/on', (recipientId) => {
    sendAPI.sendTextMessage(senderID, 'LED를 켭니다.')
});

addMessage('/led/off', (recipientId) => {
    sendAPI.sendTextMessage(senderID, 'LED를 끕니다.')
});


module.exports = {
    getHandler
};