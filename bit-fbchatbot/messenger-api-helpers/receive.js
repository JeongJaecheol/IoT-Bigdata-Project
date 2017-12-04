const sendAPI = require('./send');
const openAPI = require('../rest-api/openapi')
const messageHandler = require('./message-handler')
const postbackHandler = require('./postback-handler')

const handleReceiveMessage = (event) => {
    var senderID = event.sender.id;
    var recipientID = event.recipient.id;
    var timeOfMessage = event.timestamp;
    var message = event.message;

    console.log("Received message for user %d and page %d at %d with message:", 
        senderID, recipientID, timeOfMessage);

    var messageId = message.mid;
    var messageText = message.text;
    var messageAttachments = message.attachments; 
    
    var menu = global[senderID].menu; // 사용자의 현재 메뉴

    // 사용자가 입력한 메시지를 처리할 함수를 꺼낸다.
    var handler = messageHandler.getHandler(messageText);

    if (handler) { // 메시지를 처리할 함수가 있다면,
        handler(senderID); // 그 함수를 호출한다.
    } else {
        sendAPI.sendTextMessage(senderID, '유효한 명령이 아닙니다.');
    }

    /*
    if (messageText == 'help') {
        sendAPI.sendMenuMessage(senderID);
        // 현재 help를 출력한 상태임을 저장한다.
        global[senderID].menu = 'help';

    } else if (menu == 'calc') {
        menuCalc(senderID, messageText);

    } else if (menu.startsWith('addr_')) { // 동,도로명,우편번호를 검색한다면,
        try {
            var type = menu.substring(5);
            var searchWord = messageText;
            openAPI.searchNewAddress(type, searchWord, (msg) => {
                sendAPI.sendTextMessage(senderID, msg);
            });
        } catch (err) {
            sendAPI.sendTextMessage('주소 검색을 할 수 없습니다!');
            console.log(err);
        }
    } else {
        sendAPI.sendTextMessage(senderID, messageText);
    }*/

};

const handleReceivePostback = (event) => {
    var senderID = event.sender.id;
    var recipientID = event.recipient.id;
    var timeOfPostback = event.timestamp;
    var payload = event.postback.payload;

    console.log("Received postback for user %d and page %d with payload '%s' at %d",
               senderID, recipientID, payload, timeOfPostback);

    // 사용자가 클릭한 버튼의 postback을 처리할 함수를 꺼낸다.
    var handler = postbackHandler.getHandler(payload);
    
    if (handler) { // postback을 처리할 함수가 있다면,
        global[senderID].menu = payload;
        handler(senderID); // 그 함수를 호출한다.
    } else {
        sendAPI.sendTextMessage(senderID, '유효한 명령이 아닙니다.');
    }
};

const menuCalc = (senderID, messageText) => {
    // 현재 계산기 메뉴일 때는 사용자가 입력한 값이 
    // 계산식이라고 가정하고 메시지를 분석한다.
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
            sendAPI.sendTextMessage(senderID, 
                '+, -, *, /, % 연산자만 사용할 수 있습니다.')
            return;
        }
        sendAPI.sendTextMessage(senderID, 
            '계산 결과는 ' + result + ' 입니다.')
    } catch (exception) {
        sendAPI.sendTextMessage(senderID, 
            '계산식이 옳지 않습니다.\n예)값1 연산자 값2')
    }
};



module.exports = {
    handleReceiveMessage,
    handleReceivePostback
};