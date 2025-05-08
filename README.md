> # 발제 일정 관리 프로그램을 만들어보자!

<h1>🖥️ 프로젝트 소개</h1>

---

- 일정관리 프로그램을 만들어보자!<br>

---

<h1>🕰️ 개발 기간</h1>

---
- 25.05.01일 - 25.05.7일

---
<h1>⚙️ 개발 환경</h1>

사용 버전 : JDK version 17

기술 : Github, Git, IntelliJ, Notion, ERD Cloud, SpringBoot

사용 언어 : Java, MySql

---
<h1>📌 주요 기능</h1>

- 일정 생성, 조회, 수정, 삭제

- 댓글 생성, 수정, 삭제

- 대댓글 생성, 수정, 삭제

---

<h2>ERD</h2>

![image](https://github.com/user-attachments/assets/5aabd8b2-3c4c-42f7-908c-d3e63ee45109)

<h2>API</h2>

![image](https://github.com/user-attachments/assets/bf940ba0-d7a0-43b5-a444-0563f0484fe2)

![image](https://github.com/user-attachments/assets/a209fc55-ef13-4ac6-9555-1f89ee18b1ff)

![image](https://github.com/user-attachments/assets/370ce54a-0d9a-4752-8566-0e253c2554c1)

---

[API 동작 캡처본](https://velog.io/@flowercat95/API-%EB%8F%99%EC%9E%91-%EC%BA%A1%EC%B2%98%EB%B3%B8)

[Todo App 정리본](https://velog.io/@flowercat95/TodoApp-%EC%A0%95%EB%A6%AC%EB%B3%B8)

[트러블 슈팅](https://velog.io/@flowercat95/%ED%8A%B8%EB%9F%AC%EB%B8%94-%EC%8A%88%ED%8C%85-null-%EA%B0%92)

---

1️⃣ Lv 1 일정 CRUD

- 사용자가 일정을 생성
    - 일정에 userId 하드 코딩해서 넣어주기
      
- 사용자가 일정을 조회
    - 일정 조회시 댓글, 대댓글 같이 조회
    - 단일 조회 가능
- 일정 삭제시
    - cascade로 연결 되어있어서 일정 삭제시 댓글 삭제      
---

2️⃣ Lv 2 댓글 CRUD

- 댓글과 일정 연관 관계
- 댓글 생성, 수정, 조회

---

3️⃣ Lv 3 게시물 조회 시 댓글 조회

- Lv 1에 같이 구현
- 오름차순으로 작성 오래된 순으로 정렬

---

4️⃣ Lv 4 대댓글 (1 Depth)

- 대댓글과 댓글 연관관계
- 댓글 대댓글 순

