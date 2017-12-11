# Python으로 AWT IoT 사용하기

## 프로젝트 준비
- python 설치 확인
  - python --version
  - python3 --version
- python ssl 버전 확인
  - python
    - >>> import ssl
    - >>> ssl.OPENSSL_VERSION
    - 암호 모듈의 버전이 1.0 이상이어야 한다.
  - python3
    - >>> import ssl
    - >>> ssl.OPENSSL_VERSION
    - 암호 모듈의 버전이 1.0 이상이어야 한다.
- AWS IoT 파이썬 모듈 설치
  - python 2.7 : pip install AWSIoTPythonSDK
  - python 3.5 : pip3 install AWSIoTPythonSDK
