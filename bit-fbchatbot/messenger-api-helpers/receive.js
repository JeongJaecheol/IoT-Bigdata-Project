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
    } else if (menu) { // 메뉴의 메시지를 처리할 함수를 꺼낸다.
        handler = messageHandler.getHandler(menu);
        handler(senderID, messageText);
    } else {
        sendAPI.sendTextMessage(senderID, '유효한 명령이 아닙니다.');
    }
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


module.exports = {
    handleReceiveMessage,
    handleReceivePostback
};