# library-app (서버 배포 실습)

### 🔍 해결해 본 어려움
◼︎ 문제 상황: aws 서버 mysql 설치할 때 아래와 같은 문제 발생
```
Error: 
 Problem: conflicting requests
  - nothing provides libcrypto.so.10()(64bit) needed by mysql-community-server-8.0.11-1.el7.x86_64
  - nothing provides libssl.so.10()(64bit) needed by mysql-community-server-8.0.11-1.el7.x86_64
  - nothing provides libcrypto.so.10(libcrypto.so.10)(64bit) needed by mysql-community-server-8.0.11-1.el7.x86_64
.
.
.
—
```
◼︎ 원인 파악: aws 리눅스 2023과 사용할 수 있는 mysql repo 버전의 충돌

◼︎ 해결 방법: mysql repo를 el9 버전으로 바꿔 해결함
