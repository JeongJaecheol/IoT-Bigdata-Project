const sendAPI = require('./send');
const openAPI = require('../rest-api/openapi')

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
    
    if (messageText == 'help') {
        sendAPI.sendMenuMessage(senderID);
        // 현재 help를 출력한 상태임을 저장한다.
        global[senderID].menu = 'help';

    } else if (messageText.startsWith('searchAddress:')) {
        try {
            var arr = messageText.split(':')[1].split('=');
            openAPI.searchNewAddress(arr[0], arr[1], (msg) => {
                sendAPI.sendTextMessage(senderID, msg);
            });
        } catch (err) {
            console.log(err)
        }
    } else {
        sendAPI.sendTextMessage(senderID, messageText);
    }
};

const handleReceivePostback = (event) => {
    var senderID = event.sender.id;
    var recipientID = event.recipient.id;
    var timeOfPostback = event.timestamp;
    var payload = event.postback.payload;

    console.log("Received postback for user %d and page %d with payload '%s' at %d",
               senderID, recipientID, payload, timeOfPostback);

    var menu = global[senderID].menu;
    if (menu == 'help') {
        menuHelp(senderID, payload);
    }
    /*
    if (payload == 'led_on') {
        sendAPI.sendTextMessage(senderID, "전구를 켜겠습니다.");
    } else if (payload == 'led_off') {
        sendAPI.sendTextMessage(senderID, "전구를 끄겠습니다.");
    }
    */
};

const menuHelp = (senderID, payload) => {
    if (payload == 'menu_led') {
        console.log('LED 메뉴를 누렀네요!')
    } else if (payload == 'menu_calc') {
        console.log('계산기 메뉴를 누렀네요!')
    } else if (payload == 'menu_addr') {
        console.log('주소검색 메뉴를 누렀네요!')
    }
};

module.exports = {
    handleReceiveMessage,
    handleReceivePostback
};