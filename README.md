# 로컬 테스트 환경 구축
## 목적
- dev, qa, prod DB에 붙어야지만 테스트가 가능했었다.
로컬에서도 dev, qa, prod DB에 붙어서 테스트를 진행하는 것은 각 서버 db별 데이터의 무결성을 깨트리는
것이기 때문에 각 서버 DB에 무결성을 보존하기 위해 로컬 테스트 환경을 구축하려고 함

## 이슈
- H2 Database와 기존에 사용하는 Database와 호환성 이슈를 해결하기 위해 H2 DB의 Compatibility mode를 사용하였음

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