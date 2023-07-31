# MSA, 마이크로서비스 아키텍쳐의 특징

---
> ## 모놀리스 아키텍처 (Monolithic Architecture)
### 특징
* 하나의 프로세스로 구성, 하나의 DB endpoint 사용
* 단 한줄의 코드만 수정되더라도, 모든 어플리케이션의 재배포가 필요
* 싱글 혹은 멀티 모듈로 구성할 수 있지만, CI 단위가 달라질 뿐, CD의 범위는 여전히 전체
### 장점
* 배포 간단, 패키징 어디서 해도 상관 없다. 유지보수 쉬움. 비싼 서버 리소스 최적화 사용 가능, 공통 모듈 활용 쉽다.
* 협업이 적을 수 있는 경우, 클라우드 환경을 사용하기 어려운 경우, 개발자 역량이 낮은 경우,
* Devops 인력 부족 시, CI/CD 환경이 필요 없음.
### 단점
* 수평 확장이 어렵다. (단일 DB에 대한 의존성이 너무 크다.)
* 시스템이 커질 수록, 커뮤니케이션 코스트가 기하급수적으로 올라감.
* 장애 시, 전체 어플리케이션에 영향을 받음.
---
> ## 서비스 지향 아키텍쳐 (Service Oriented Architecture)
* 서비스 단위로 개발하고, 서비스 간 규격화된 프로토콜을 사용하여 통신
* 대개 동일한 기술 스택을 가지고 서비스를 개발, 각 서비스들간 통합, 재사용이 목적
* ESB(Enterprise Service Bus) 라는 개념을 통해, 요청에 대해 어떤 서비스 호출할 지 캡슐화 된 레이어
---
> ## 마이크로서비스 아키텍쳐 (Micro Service Architecture)
### 특징
* 서비스 단위로 개발, 독립적 개발 - 배포 가능
* 비즈니스 로직의 재사용 지양, 서비스간 결합도를 낮추는 것이 목표 -> 애자일한 대응
* 독립적인 기술스택 가능
* 서비스 간 자유로운 통신 가능, dump pipe (http, grpc)
### 원칙
* Smart endpoints and dumb pipes
  * 단순한 프로토콜의 사용
* Decentralized Data Management / Governance
  * 데이터의 유연성 확보, 비즈니스 특성에 따른 기술 스택 사용
* Infrastructure Automation
  * CI/CD 파이프라인을 이용한 인프라 자동화
* Design for Failure
  * "시스템은 언제든지 문제가 생길 수 있음을 인정", 대응책 마련
  * CircuitBreaker(감지), Container Orchestration(복구 - K8S)
  * 의도치 않은 결과 방지(Transaction 문제), 서비스 간의 영향도 Chaos Test 등
### 단점
* 서비스 간 통신의 어려움 IPC
* Transaction 유지의 어려움
* Monitoring 어려움
---