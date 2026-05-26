# 🔧 스마트 EDU-HUB AI 키오스크 — Internal API 서버
> External 서버(Kiosk)의 요청을 받아 DB를 처리하고 REST API를 제공하는 내부 서버

## 📌 프로젝트 개요
| 항목 | 내용 |
| --- | ----- |
|사업명 | 스마트 EDU-HUB AI 키오스크 개발 Project |
|역할 | Internal 서버 (REST API + DB 처리) |
|포트 | 8081 |
|호출 주체 |	External 서버 (Kiosk, 8080) |

---

## 🏗️ 시스템 아키텍처
```
[ External Server : 8080 ]  ← Kiosk 프로젝트

       ↕ REST API (X-Api-Secret 헤더 인증)

[ Internal Server : 8081 ]  ← 현재 프로젝트

       ↕

[ MariaDB : 192.168.10.37:2205 ]
```
> 직접 호출 금지 — 반드시 External 서버를 통해서만 접근
> 
> CORS — http://localhost:8080 만 허용

---

## 🛠️ 기술 스택
|분류 |	기술 |
| --- | ---- |
|프레임워크 |	eGovFramework 3.10.0 + Spring MVC 4.3.25|
|언어 |	Java 1.8|
|빌드 |	Maven / WAR 배포|
|ORM |	MyBatis (mapUnderscoreToCamelCase = true)|
|DB |	MariaDB + Apache Commons DBCP2|

---

## 📡 REST API 목록
#### /api/student — 교육생 관리
|Method|	URL|	파라미터	|설명|
| ----- | --- | ------ | ---- |
|GET |	/api/student/search|	birthDate (YYMMDD)|	생년월일로 교육생 목록 조회|
GET|	/api/student/detail|	studentId (STU_xxx)|	교육생 상세 정보 조회|
POST|	/api/student/update|	studentId (STU_xxx)|	출석 처리 (@Transactional)|

### 🔐 출석 처리 로직
POST /api/student/update 호출 시 아래 순서로 처리됩니다.

1. StudentSearchVO null 체크
2. studentId 형식 검증 (^STU_[0-9A-Za-z]+$)
3. 이미 출석 처리된 경우 → 실패 반환
4. 기숙사 입소 대상인 경우 정원 초과 체크
5. 교육 기간(START_DATE ~ END_DATE) 내인지 확인
6. STUDENTS.ATTEND_YN = Y 업데이트
7. 기숙사 입소 대상이면 DORMITORIES.CURRENT_COUNT +1

---

## ⚙️ 환경 설정

### 사전 요구사항

- JDK 1.8 / Maven 3.x
- MariaDB 접속 가능한 네트워크 환경
- globals.properties 수동 생성 필요
⚠️ 보안상 git에서 제외됨 — 아래 경로에 직접 생성해야 합니다

> src/main/resources/egovframework/egovProps/globals.properties
```
# DB 접속 정보
Globals.DriverClassName=org.mariadb.jdbc.Driver
Globals.Url=jdbc:mariadb://YOUR_DB_HOST:YOUR_DB_PORT/YOUR_DB_NAME
Globals.UserName=YOUR_DB_USER
Globals.Password=YOUR_DB_PASSWORD

# CORS (External 서버 주소)
Globals.CorsAllowedOrigin=http://localhost:8080

# API 인증 키 (External 서버와 동일하게 설정)
Globals.ApiSecretKey=YOUR_SECRET_KEY
```

## 빌드 및 실행
```
mvn clean package
```
> WAR 파일을 Tomcat에 배포 (포트 8081)

---

## 📁 프로젝트 구조
```
src/main/java/kr/hcnc/
├── web/        # StudentApiController, FacilityApiController
├── service/    # BadgeService, FacilityService
├── mapper/     # BadgeMapper, FacilityMapper
├── vo/         # StudentSearchVO, DormitoryVO, EduInfoVO
├── validator/  # StudentValidator
└── filter/     # SecretKeyFilter (X-Api-Secret 인증)
src/main/resources/kr/hcnc/mapper/
├── BadgeMapper.xml
└── FacilityMapper.xml
```

## 🌿 브랜치 전략
```
main        ← 보호 브랜치, PR + 리뷰 필수
└── develop ← 통합 브랜치
    ├── feature/작업명
    └── fix/작업명
```

## 📋 잔여 개발 항목
|항목|	비고|
| -- | ---- |
|라벨 프린터 실제 연동|	하드웨어 확정 후|
