# JavaScript로 AWT IoT 사용하기

## 프로젝트 준비
- nodejs 설치 확인
  - node -v
- npm 설치 확인
  - npm -v
- 프로젝트 폴더 생성
  - ~/git/bitcamp-project/bit-iot-js 폴더 생성
  - cd ~/git/bitcamp-project/bit-iot-js
- nodejs 설정 파일(package.json) 파일 생성 
  - npm init
- AWS IoC 개발킷 설치
  - npm install aws-iot-device-sdk
- AWS IoC 관리 페이지에서 Thing 생성 및 인증서 생성
  - 인증서 파일을 프로젝트 폴더로 복사
- CA 인증서 다운로드 받기
  - https://www.symantec.com/content/en/us/enterprise/verisign/roots/VeriSign-Class%203-Public-Primary-Certification-Authority-G5.pem 파일 다운로드
  - 파일명은 적절한 이름(예: root-CA.crt)로 저장할 것.
- examples 폴더 생성
  - AWS IoT 예제 파일 작성 