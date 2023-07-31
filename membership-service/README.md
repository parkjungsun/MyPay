## MemberShip Service
### Service 정의
비즈니스에서 제공하는 멤버십 서비스로서, 
가입하는 개인/법인 고객의 정보를 소유(ownership)하고 
관련 정보의 변경에 대한 의무를 가진 서비스
---
### Demo 기능
* 개인/법인 고객의 정보 소유
* 새로운 멤버십(개인/법인) 등록 및 조회 기능
---
### API 정의
* Query
  * 고객정보 조회
    * request
      * membershipId
    * response
      * membership
* Command
  * 신규 고객 멤버십 등록
    * request
      * membership
    * response
      * Registered Membership
      * ResponseCode
