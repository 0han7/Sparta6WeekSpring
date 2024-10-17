# 내일배움캠프 스프링 6주차 개인 과제 일정 알람 앱 서버 만들기
---
## 🖥️프로젝트 소개 
스프링 3, 4주차 강의를 참고하여 만든 과제입니다.
---
## 📆개발 기간
* 24.10.04 ~ 24.10.17
---
### 🖥️기술 스택
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"><img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"><img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"><img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"><img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"><img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white">
---
## 📌주요 기능 
---
### 1. 일정 CRUD 구현
#### 1) 일정 생성(일정 작성하기)
* 할일, 작성자명, 비밀번호, 작성/수정일을 저장할 수 있습니다.
* 작성/수정일은 날짜와 시간을 모두 포함한 형태로 구현했습니다.
* 각 일정의 고유 식별자(ID)를 자동으로 생성하여 관리하고 있습니다.

#### 2) 일정 조회(등록된 일정 불러오기)
* 생성된 일정을 조회할 수 있습니다.

#### 3) 일정 수정 및 삭제
* 선택한 일정을 수정 및 삭제할 수 있습니다.
* 수정 시 수정한 날짜로 수정일이 변경되게 구현했습니다.
* 영속성 전이 기능으로 일정 삭제 시 해당 댓글도 함께 사라집니다.


### 2. 댓글 CRUD 구현
#### 1) 댓글 생성
* 작성자, 작성 내용을 저장할 수 있습니다.
* 작성/수정일은 날짜와 시간을 모두 포함한 형태로 구현했습니다.
  
#### 2) 댓글 조회
* 생성된 댓글을 조회할 수 있습니다.

#### 3) 댓글 수정 및 삭제
* 영속성 전이 기능으로 일정 삭제 시 해당 댓글도 함께 사라집니다.

### 3. 유저 CRUD 구현
#### 1) 유저 생성
* 유저명, 비밀번호, 이메일, 작성일, 수정일을 저장할 수 있습니다. 
#### 2) 유저 조회
* 생성된 유저를 조회할 수 있습니다.
#### 3) 유저 수정 및 삭제
* 선택한 유저를 수정 및 삭제할 수 있습니다.

---

## 미완성한 부분
### 1. 선택 일정 조회(선택한 일정 정보 불러오기)(미완성)
* 조건을 바탕으로 등록된 일정 목록을 전부 조회하는 기능을 구현하지 못했습니다.

### 2.일정 페이징 조회 기
* 페이지 번호와 페이지 크기를 쿼리 파라미터로 전달하여 요청하는 항목을 구현하지 못했습니다.

### 3. html (미완)
* postman에는 작동이 되지만, HTML이 미완성이라 웹 사이트에서의 구현은 하지 못했습니다.
---
## API 명세서- 일정 관리 시스템
#### 노션 API 명세서 URL : https://giddy-ox-904.notion.site/API-1214bd51dfda800cae6aec06860dc56d?pvs=4

### 일정
| 메서드   | URL                | 설명        | 요청 본문 (Request Body)                                                            | 응답 본문 (Response Body)                                                                                                                                                                                                                         | 응답 코드 |
|---------|--------------------|-------------|------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------|
| GET     | /api/schedule       | 일정 조회   | 없음                                                                               | ```json [ { "id": 1, "이름": "홍길동", "제목": "물 마시기", "내용": "물 1L마시기", "createdAt": "등록일", "modifiedAt": "수정일" }, { "id": 2, "이름": "김무명", "제목": "물 마시기", "내용": "물 1L마시기", "createdAt": "등록일", "modifiedAt": "수정일" } ] ```                        | 200 OK   |
| POST    | /api/schedule       | 일정 등록   | ```json { "username": "홍길동", "password": "1234567w", "title": "물 마시기", "contents": "물 1L 마시기" } ``` | ```json { "id": 1, "username": "홍길동", "password": "1234567w", "title": "물 마시기", "contents": "물 1L 마시기", "createdAt": "2024-10-16T16:19:49.9352444", "modifiedAt": "2024-10-16T16:19:49.9352444" } ```                                 | 200 OK   |
| PUT     | /api/schedule/{id}  | 일정 수정   | ```json { "username": "홍길동 수정", "password": "1234567w", "title": "물 마시기 수정", "contents": "물 1L 마시기 수정" } ``` | ```json { "id": 1, "username": "홍길동 수정", "password": "1234567w", "title": "물 마시기 수정", "contents": "물 1L 마시기 수정", "createdAt": "2024-10-16T16:19:49.9352444", "modifiedAt": "2024-10-16T16:19:49.9352444" } ```                     | 200 OK   |
| DELETE  | /api/schedule/{id}   | 일정 삭제   | 없음                                                       | 없음                                                                                                                                                                                                                        | 200 OK   |

![스크린샷 2024-10-17 112657](https://github.com/user-attachments/assets/6e30276f-7318-46d2-8c27-7e6351f842c3)


### 댓글
| 메서드   | URL                | 설명        | 요청 본문 (Request Body)                                    | 응답 본문 (Response Body)                                                                                                                                                                                                 | 응답 코드 |
|---------|--------------------|-------------|------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------|
| GET     | /api/comment        | 댓글 조회   | 없음                                                       | ```json [ { "id": 1, "username": "홍길동", "contents": "댓글테스트", "createdAt": "2024-00-00", "modifiedAt": "2024-00-00" }, { "id": 2, "username": "김무명", "contents": "댓글테스트", "createdAt": "2024-00-00", "modifiedAt": "2024-00-00" } ] ``` | 200 OK   |
| POST    | /api/comment        | 댓글 생성   | ```json { "username": "홍길동", "contents": "댓글 테스트" } ``` | ```json { "id": 1, "username": "홍길동", "contents": "댓글테스트", "createdAt": "2024-00-00", "modifiedAt": "2024-00-00" } ```                                                                                             | 200 OK   |
| PUT     | /api/comment/{id}   | 댓글 수정   | ```json { "username": "홍길동", "contents": "댓글 수정 테스트" } ``` | ```json { "id": 1, "username": "홍길동", "contents": "댓글 수정 테스트", "createdAt": "2024-00-00", "modifiedAt": "2024-00-00" } ```                                                                                       | 200 OK   |
| DELETE  | /api/comment/{id}   | 댓글 삭제   | 없음                                                       | 없음                                                                                                                                                                                                                        | 200 OK   |

![스크린샷 2024-10-17 112703](https://github.com/user-attachments/assets/fe2c209e-2157-46ea-b0d4-0cb82b3530c5)


### 유저
| 메서드 | URL          | 설명            | 요청 본문 (Request Body)                        | 응답 본문 (Response Body)                                                                                                                                                                                                                                                                                                | 응답 코드 |
|--------|--------------|-----------------|-------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------|
| GET    | /api/user    | 유저 조회       | 없음                                            | ```json [ { "id": 1, "login": "jdjHong", "password": "1234567w", "username": "홍길동", "email": "jdjHong@email.com", "createdAt": "2024-10-16T16:47:52.0360414", "modifiedAt": "2024-10-16T16:47:52.0360414" }, { "id": 2, "login": "myKim", "password": "1234567w", "username": "김무명", "email": "myKim@email.com", "createdAt": "2024-10-16T16:47:52.0360414", "modifiedAt": "2024-10-16T16:47:52.0360414" } ] ``` | 200 OK   |
| POST   | /api/user    | 유저 등록       | ```json { "login": "jdjHong", "password": "1234567w", "username": "홍길동", "email": "jdjHong@email.com" } ``` | ```json { "id": 1, "login": "jdjHong", "password": "1234567w", "username": "홍길동", "email": "jdjHong@email.com", "createdAt": "2024-10-16T16:47:52.0360414", "modifiedAt": "2024-10-16T16:47:52.0360414" } ```                                                                                                                                              | 200 OK   |
| PUT    | /api/user/{id} | 유저 수정      | ```json { "login": "jdjHong2", "password": "1234567w", "username": "홍길동", "email": "jdjHong@email.com" } ``` | ```json { "id": 1, "login": "jdjHong2", "password": "1234567w", "username": "홍길동", "email": "jdjHong@email.com", "createdAt": "2024-10-16T16:47:52.0360414", "modifiedAt": "2024-10-16T16:47:52.0360414" } ```                                                                                                                                              | 200 OK   |
| DELETE  | /api/user/{id}   | 유저 삭제   | 없음                                                       | 없음                                                                                                                                                                                                                        | 200 OK   |

![스크린샷 2024-10-17 112708](https://github.com/user-attachments/assets/5407c499-edb5-4e12-a2c5-5dfb0cd6038a)




## ERM
![스크린샷 2024-10-17 111056](https://github.com/user-attachments/assets/09913660-d354-4b02-ba3c-8fd18470ee33)


