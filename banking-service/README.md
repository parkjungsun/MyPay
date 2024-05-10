## Banking Service
### Service 정의
외부 은행과의 직접적인 통신을 담당하고, 
펌뱅킹 계약이나 수수료 관리 등 외부 은행 사용과 관련된
모든 기능을 제공하는 서비스

---
### Demo 기능
외부 은행과 입/출금 요청 펌뱅킹 통신을 담당하고, 내부 고객의 계좌 정보를 등록하는 서비스
> 계좌정보 등록정보 어그리거트 (계좌연동)
> * RegisteredBankAccount - 고객의 등록된 계좌
> * RegisteredBankAccountHistory

> 펌뱅킹 내역 어그리커트
> * RequestFirmBanking - 받는사람, 보내는사람, 금액 + 시간
> * RequestFirmBankingHistory
> * BankAccount - 외부 은행 수많은 정보

---
### API 정의
* Query
    * 입금/출금 요청(펌뱅킹) 내역 조회 [findFirmBankingInfo by membershipId]
      * request
        * membershipId
      * response
        * FirmBanking Object
    * 고객의 연동된 계좌(고객 계좌 연동정보) 조회 [findRegisteredBankAccount by membershipId]
      * request
        * membershipId
      * response
        * registeredBankAccount Object

* Command
    * 고객 정보에 대해 요청된 Account 정보를 매핑, 연동 [registerBankAccount with membershipId]
        * request
            * membershipId
            * BankAccount
        * response
            * RegisteredBankAccount Object
    * 실제 실물 계좌에서의 입금/출금을 요청하는 펌뱅킹을 요청, 수행 [requestFirmBanking to Remittance with BankAccount]
        * request
            * fromBankAccount
            * toBankAccount
            * Money
        * response
            * RequestFirmBankingUUID