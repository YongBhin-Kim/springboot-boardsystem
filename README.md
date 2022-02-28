<h2>Spring Boot를 이용한 게시판 만들기</h2>


**[Use]** <br>

- Spring Boot (Gradle)
- MariaDB
- MySQLWorkbench
- JPA
<br><br><br>



**[20-02-26]** <br>

- Spring Project 생성
- DB 연결


**[20-02-27]** <br>

- Board Table 생성 (id, title, content)
- 게시글 컨트롤러 생성 `controller/BoardController`
- 게시글 작성 폼 생성 `templates/boardwrite.html`


**[20-02-28]** <br>

- 게시글 컨트롤러 수정 `controller/BoardController` (db와 연동되게끔 : controller - service - repository) [오류]
- Entity 생성 `entity/Board`
- Service 생성 `service/BoardService`
- Repository 생성 `repository/BoardRepository`
