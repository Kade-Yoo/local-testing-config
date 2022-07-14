# 로컬 테스트 환경 구축
## 목적
- dev, qa, prod DB에 붙어야지만 테스트가 가능했었다.
로컬에서도 dev, qa, prod DB에 붙어서 테스트를 진행하는 것은 각 서버 db별 데이터의 무결성을 깨트리는
것이기 때문에 각 서버 DB에 무결성을 보존하기 위해 로컬 테스트 환경을 구축하려고 함

## 이슈
- H2 Database와 기존에 사용하는 Database와 호환성 이슈를 해결하기 위해 H2 DB의 Compatibility mode를 사용하였음
- Service Layer Test환경을 구성할 때 Mocking해주는 대상이 필요한 모든 객체여야함. 다른 방법은 없을지 확인 필요

## 구성
- Spring Boot 2.7.0
- H2 database
- Junit 5
- Lombok

## 에러 모음
- org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "drop table if exists user CASCADE " via JDBC Statement
  - 원인 : profiles를 test로 하지 않아 application.yml 설정을 읽지 못했음
  - 해결 : profiles를 test로 설정하여 해결
- Caused by: org.h2.jdbc.JdbcSQLSyntaxErrorException: Syntax error in SQL statement "create table [*]user ( user_id varchar(40) not null primary key, password varchar(400) not null, user_name varchar(20) not null )"; expected "identifier"; SQL statement:
  - 원인 : PostgreSQL에서 user는 reversed keyword로 분류되어 있어 user테이블 생성했을 때 오류가 발생했음
  - 해결 : 키워드는 사용할 수 없기 때문에 member로 변경하여 해결
- java.lang.NullPointerException: Cannot invoke "org.springframework.test.web.servlet.MockMvc.perform(org.springframework.test.web.servlet.RequestBuilder)" because "this.mockMvc" is null
  - 원인 : 빈 등록이 되지 않아 null
  - 해결 : @Autowired로 빈 등록하여 해결
- java.lang.NullPointerException: Cannot invoke "yoo.example.localtestingconfig.repository.MemberCustomRepository.getMemer(java.lang.Long)" because "this.memberRepository" is null
  - 원인 : MemberCustomRepository 객체를 불러와야 하는데 빈 등록이 되어 있지 않아 NPE발생
  - 해결 : Mocking을 할 땐 빈 등록이 필요한 객체를 @Mock 을 붙여서 가짜 빈을 등록해줘야함

## 참고 문서
- https://msyu1207.tistory.com/entry/spring-boot-JdbcSQLSyntaxErrorException-Syntax-error-in-SQL-statement-expected-identifier-%ED%95%B4%EA%B2%B0-%EB%B0%A9%EC%95%88
- https://www.postgresql.org/docs/8.1/sql-keywords-appendix.html
- https://minholee93.tistory.com/entry/ERROR-MockMvc-NullPointerException-Spring-Boot
- https://www.h2database.com/html/commands.html
- https://taes-k.github.io/2021/04/05/spring-test-isolation-datasource/