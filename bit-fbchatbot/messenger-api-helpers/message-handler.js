const api = require('./api');
const sendAPI = require('./send');
const openAPI = require('../rest-api/openapi');

// message를 받았을 때 그 메시지를 처리할 함수를 보관하는 객체 
const messageHandler = {
    // '메시지': 함수
};

// message를 처리할 함수를 등록한다.
const addMessage = (message, handler) => {
    messageHandler[message] = handler;
}

// 등록된 메시지 핸들러를 찾아서 리턴한다.
const getHandler = (message) => {
    return messageHandler[message];
};

// 'help' 메시지를 처리할 함수 등록
addMessage('help', (recipientId) => {
    var messageData = {
        recipient: {
          id: recipientId
        },
        message: {
          "attachment":{
            "type":"template",
            "payload":{
              "template_type":"button",
              "text":"메뉴",
              "buttons":[
                {
                  "type":"postback",
                  "title":"LED",
                  "payload":"/led"
                },
                {
                  "type":"postback",
                  "title":"계산기",
                  "payload":"/calc"
                },
                {
                  "type":"postback",
                  "title":"주소검색",
                  "payload":"/addr"
                }
              ]
            }
          }
        }
    };
    api.callMessagesAPI(messageData);    
});

// 현재 계산기 메뉴일 때는 사용자가 입력한 값을 처리하는 함수 등록 
addMessage('/calc', (recipientId, messageText) => {
    // 계산식을 분석한다.
    try {
        var tokens = messageText.split(' ');
        if (tokens.length != 3)
            throw '계산 형식 오류';

        var a = parseInt(tokens[0]);
        var op = tokens[1];
        var b = parseInt(tokens[2]);
        var result = 0;
        switch (op) {
        case '+': result = a + b; break;
        case '-': result = a - b; break;
        case '*': result = a * b; break;
        case '/': result = a / b; break;
        case '%': result = a % b; break;
        default:
            sendAPI.sendTextMessage(recipientId, 
                '+, -, *, /, % 연산자만 사용할 수 있습니다.')
            return;
        }
        sendAPI.sendTextMessage(recipientId, 
            '계산 결과는 ' + result + ' 입니다.')
    } catch (exception) {
        sendAPI.sendTextMessage(recipientId, 
            '계산식이 옳지 않습니다.\n예)값1 연산자 값2')
    }
});

addMessage('/addr/dong', (recipientId, messageText) => {
    try {
        openAPI.searchNewAddress('dong', messageText, (msg) => {
            sendAPI.sendTextMessage(recipientId, msg);
        });
    } catch (err) {
        console.log(err);
    }
});

addMessage('/addr/road', (recipientId, messageText) => {
    try {
        openAPI.searchNewAddress('road', messageText, (msg) => {
            sendAPI.sendTextMessage(recipientId, msg);
        });
    } catch (err) {
        console.log(err);
    }
});

addMessage('/addr/post', (recipientId, messageText) => {
    try {
        openAPI.searchNewAddress('post', messageText, (msg) => {
            sendAPI.sendTextMessage(recipientId, msg);
        });
    } catch (err) {
        console.log(err);
    }
});

module.exports = {
    getHandler
};