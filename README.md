## Pay Service

### About MSA
1. [Feature of MSA](https://github.com/parkjungsun/MyPay/blob/main/AboutMSA/1%20Feature%20of%20MSA.md)
2. [MSA Pattern](https://github.com/parkjungsun/MyPay/blob/main/AboutMSA/2%20MSA%20Pattern.md)
3. [MSA Based on DDD](https://github.com/parkjungsun/MyPay/blob/main/AboutMSA/3%20MSA%20Based%20on%20DDD.md)
---
### Demo 기능
* 회원 가입 및 정보 변경
    * Membership Service
    * 계좌 연결 기능
* [회원-회원], [회원-은행] 간 간편 송금 기능
    * 회원 간 잔액 이동 비즈니스 로직
    * 외부 실제 은행 관리 시스템 (모듈) - 뱅킹
* 가맹점에서 결제 / 정산 기능
    * 가맹점 관리 시스템
    * 결제 시스템 + 크론잡을 통한 정산 기능
---
### MSA 아키텍쳐 설계
* [Membership Service - 멤버십 서비스](https://github.com/parkjungsun/MyPay/blob/main/membership-service/README.md)  
  * 고객(회원/가맹점)을 관리하고 계좌 등록, 인증 등 패캠페이의 고객을 관리하고 편의 기능을 제공하는 서비스
* Banking Service - 뱅킹 서비스
  * 외부 은행과의 직접적인 통신을 담당하고, 펌뱅킹 계약이나 수수료 관리 등 외부 은행 사용과 관련된 모든 기능을 제공하는 서비스
* Money Service - 머니 서비스
  * 고객의 선불 충전 금액을 관리하고, 이에 대해 다양한 쿼리를 제공할 수 있는 서비스
* Remittance Service - 송금 서비스
  * "송금"이라는 비즈니스 과정 전체를 관리하고, 트랜잭션에 대한 책임을 가지는 서비스
* Payment Service - 결제 서비스
  * "결제"이라는 비즈니스 과정 전체를 관리하고, 트랜잭션에 대한 책임을 가지는 서비스
* Settlement Service - 정산 서비스
  * 주기적으로 정산 작업을 진행하며, 여기서 생기는 모든 과정을 관리하는 서비스
---
### Domain 정의
> ### Pay Money
> 전자금융업에 의해 정해진 "선불 충전 금액"
> 1. 약정 등록 ( 뱅킹 계좌 - 페이 계좌 )
> 2. 뱅킹 계좌 -> (현금 송금) -> 법인 계좌
> 3. 법인 계좌 -> (머니 충전) -> 페이 계좌

> ### 펌 뱅킹
> * 은행이 아닌 곳에서 은행의 기능을 시스템적으로 이용하기 위한 수단
> * 각 은행마다 별도의 계약을 맺고 수수료 지불 (입/출금 요청마다 고정 수수료 지불)

> ### 송금 
> * [회원 - 회원] 간 송금 : 페이 계좌 -> 페이 계좌 (DB 간 트랜잭션)
> * [회원 - 은행 계좌] 간 송금 : 법인 계좌 -> 은행 계좌 (뱅킹 서비스)

> ### 결제
> 1. 송금자 금액, 수신자 상태 유효성 확인
> 2. 결제에 대한 전표 생성

> ### 정산
> * 주기별로 정상 결제 된 전표를 가지고 돈을 정리하는 과정 (수수료)
> * 정산 된 이후 펌 뱅킹을 통해서 금액 송금
