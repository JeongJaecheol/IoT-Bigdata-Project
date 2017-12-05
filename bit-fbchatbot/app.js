const https = require('https') // 운영 서버용
//const http = require('http') // 로컬 테스트용
const express = require('express')
const fs = require('fs')
const bodyParser = require('body-parser');
const request = require('request')

// .env 파일의 내용을 로딩한다.
require('dotenv').config({path: '/home/ec2-user/vars/.env'})

const app = express()

// JSON 형식으로 클라이언트가 보낸 데이터를 처리하는 객체 등록
// => 이 객체를 등록하지 않으면 JSON 형식으로 전달 받은 데이터를 다룰 수 없다.
app.use(bodyParser.json()); 

// URL 인코딩 형식으로 클라이언트가 보낸 데이터를 처리하는 객체 등록
// => 이 객체를 등록하지 않으면 URL 인코딩 형식으로 전달 받은 데이터를 다룰 수 없다.
app.use(bodyParser.urlencoded({extended: true})); 

// 클라이언트에서 정적 웹자원을 요청했을 때 그 자원을 찾을 폴더를 지정한다.
// 정적 웹자원:
// => 실행하지 않고 그대로 읽어서 클라이언트에게 보내는 파일
// => .html, .gif, .jpg, .css, .js 등 
app.use(express.static('public'))

// 클라이언트 요청을 처리할 모듈을 가져온다.
//import root from './routes/root.js';
//import webhook from './routes/webhook.js';
//import hello from './routes/hello.js';

// URL와 그 URL의 요청을 처리할 모듈을 설정한다.
// => /webhook/ 으로 시작하는 요청이 들어오면 webhook.js에서 처리
// => / 로 시작하는 요청이 들어오면 root.js에서 처리 
app.use('/', require('./routes/root'));
app.use('/webhook', require('./routes/webhook'));
app.use('/hello', require('./routes/hello'));

// 인증서 데이터를 로딩
// => 다음 객체는 node HTTPS 서버를 실행할 때 사용한다.
// 운영 서버용
var options = {
  key: fs.readFileSync('/home/ec2-user/vars/custom.key'),
  cert: fs.readFileSync('/home/ec2-user/vars/www_eomcs_com.crt'),
  ca: fs.readFileSync('/home/ec2-user/vars/www_eomcs_com.ca-bundle') 
}

https.createServer(options, app).listen(9999, function() {
    console.log('서버가 시작되었습니다!')
})

// 로컬 테스트용
/*
http.createServer(app).listen(9999, function() {
  console.log('서버가 시작되었습니다!')
})
*/

// nodejs 모듈 설치
// => npm(node package manager) 프로그램을 이용하여 모듈을 설치한다.
// => npm install 모듈명1 모듈명2 모듈명3 ...
// 
// express 모듈 설치
// => npm install express
//
// 모듈이 여러 개일 경우 모두 암기해서 일일이 설치하기에는 너무 번거롭다.
// 그래서 npm은 프로그램 정보 및 기타 모듈 정보를 담은 별도의 설정 파일을 사용한다.
// => package.json
// => 즉 package.json 파일에 프로그램 정보나 사용할 모듈 정보를 저장해 둔다.
//
// package.json 사용
// 1) package.json 파일 생성 
//    => "npm init" 명령 실행
// 2) package.json에 프로그램에서 사용할 모듈을 등록
//    => "npm install 모듈명 --save"
//    => 모듈을 설치하는 것과 함께 package.json 파일에 모듈 정보를 등록한다.
// 3) package.json 활용
//    => 기존에 다운로드 받은 node_modules 폴더 및 그 하위 폴더를 모두 제거하라.
//    => "npm install" 명령 실행
//       package.json 파일에 등록된 모든 모듈을 자동으로 다운로드 받아 설치한다.
// 
//

