# MSA 전환을 위한 패턴

---
> ## 분해 패턴
### 정의
* 모놀리식 비즈니스 구조를 어떤 판단 기준에 따라 서비스를 분해할 것인지에 대한 패턴
### 비즈니스 능력에 따른 분해 (Business Ability)
* 비즈니스 능력을 기준으로 분해
* 장점
  * 비즈니스가 복잡해지고 대규모 조직인 경우, 비즈니스 특성으로 내부 서비스 간 통신이 매우 빈번할 경우
* 단점
  * 서비스 간 응집도가 증가하고, 도메인 구분이 희석될수도 있다.

### 🔸 하위 도메인 패턴별 분해 (Sub-Domain from DDD)
* 복잡한 비즈니스일지라도, 포함된 내부의 하위 도메인을 단위로 분리
* 장점
  * 서비스 간 독립성 증가 / 결합도 감소
* 단점
  * 서비스 간 불필요한 통신 증가, 비효율적으로 많은 서비스는 단점
---
> ## 통신 패턴
### 동기 패턴 : HTTP, gRPC
### 비동기 패턴 : Kafka Queueing

---
> ## 트랜잭션 패턴
### 2PC
* 트랜잭션을 2단계에 걸쳐서 결정
### Compensating Transaction - 보상트랜잭션
* 특정 요청과 그 요청에 대해 정상적이고 완전히 종료된 행동을 그 이전으로 돌리기 위한 행동
### Saga Pattern - 사가 패턴
* 트랜잭션의 선, 후 관계를 사전에 정의하고 필요와 경우에 따라 Coordinator 가 보상트랜잭션을 이용, 관리하여 트랜잭션 구현

---
> ## 데이터쿼리 패턴
### API Aggregation 패턴
* 필요한 데이터를 얻어오기 위해서, 분리된 서비스를 각 도메인에 대한 데이터를 요청 후 필요에 맞게 Aggregation
### CQRS 패턴
* Command(Write,Update,Delete) 작업과, Query(Read) 작업의 Endpoint 를 분리.
* Command 에서 발생된 데이터의 변경을 이벤트 발행을 통해 원하는 포맷대로 Query 를 위한 전용 데이터 구조 만듬.

---
> ## 가시성 (Visibility, Observability)
### 로깅
* 로깅 : 트러블 슈팅을 위한 목적 - 누락이 되어서는 안된다.
### 메트릭
* 매트릭 : 지표들을 시계열 DB에 저장됨, 시간에 따라 변화(프로메테우스) - 누락이 되어도 괜찮음

---
> ## 신뢰성
### 장애 복구, 자가 치유, 무정지 배포
* 서킷 브레이커 (Circuit Breaker)

---
> ## 테스트 패턴
분리된 서비스들이 서로 빈번하게 호출되는 모놀리식과는 다른 환경 MSA 환경에서, 
여러 테스트 방식을 적용하여 "테스트"의 본질적인 의미를 해결하기 위한 패턴
* 단위 테스트, 통합 테스트, 종단간 테스트
---
> ## 외부 API 패턴
서비스 간의 통신 시, 구현과 관련된 종속성을 해결하기 위한 패턴.
A 서비스가 B 서비스를 호출할 때, 직접 호출하는 것이 아닌 리버스 프록시 역할을 하는 인터페이스 서비스를 제공

---
> ## 디스커버리 패턴
수 많은 컨테이너, 서버들의 상태를 정상적으로 관리하고 어려웠던 문제를 해결하기 위한 패턴