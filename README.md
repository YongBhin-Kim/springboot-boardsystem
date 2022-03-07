<h2>Spring Boot를 이용한 게시판 만들기</h2>


**[Use]** <br>

- Spring Boot (Gradle)
- MariaDB
- MySQLWorkbench
- JPA
<br><br><br>

**[20-01-29 ~ 20-02-26]** <br>
- Web Server Spring Demo 공부
<br>

**[20-02-26]** <br>

- Spring Project 생성
- DB 연결
<br>

**[20-02-27]** <br>

- Board Table 생성 (id, title, content)
- 게시글 컨트롤러 생성 `controller/BoardController`
- 게시글 작성 폼 생성 `templates/boardwrite.html`
<br>

**[20-02-28]** <br>

- 게시글 컨트롤러 수정 `controller/BoardController` (db와 연동되게끔 : controller - service - repository)
- Entity 생성 `entity/Board`
- Service 생성 `service/BoardService`
- Repository 생성 `repository/BoardRepository`
<br>

**[20-03-01 ~ 20-03-04]** <br>

- 게시글 작성 `/board/write`
- 게시글 목록 `/board/list`
- 게시글 상세 `/board/view?id={id}` : `/board/list`에서 제목 클릭
- 게시글 삭제 `/board/delete?id={id}` : `/board/view`에서 "삭제" 클릭
- 게시글 수정 `/board/modify/{id}` : `/board/view`에서 "수정" 클릭 후 수정
- 게시글 갱신 `/board/update/{id}` : `/board/modify/{id}`에서 수정 후 "수정" 클릭 하여 적용 

[URL에 Parameter을 넘기는 방식] <br>
- QueryString : 게시글 상세, 게시글 삭제 <br>
- Pathvariable : 게시글 수정, 게시글 갱신 <br>
<br>

**[20-03-05]** <br>
- 게시글 작성 메시지 `/board/writepro` : `/board/write`에서 게시글 작성 시 작성 완료 메시지 띄우기 및 `/board/list`으로 URL 넘기기
- 게시글 수정 메시지 `/board/update/{id}` : `/board/modify/{id}`에서 게시글 수정 시 수정 완료 메시지 띄우기 및 `/board/list`으로 URL 넘기기
<br>

**[20-03-06]** <br>
- 게시글 목록 `/board/list` 스타일 변경
- (파일 업로드 예정)
<br>

**[20-03-07]** <br>
- 





<br><br>

<h3>[오류와 해결]</h3>
<br>

**[오류 : Lombok]** <br>

[20-02-28] <br>
null 오류 -> 해결 및 default 값 오류 -> 해결 및 작성 값 대신 default 값이 삽입 : wired가 안 되었나?

[20-03-02] <br>
BoardController의 boardWritePro에서 `boardService.write(board)` 오류 <br>
<=
BoardService의 write에서 `boardRepository.save(board)` 오류

[20-03-03] <br>
1. localhost:8080/board/write 입력 : `Controller(/board/write)` <br>
2. `boardwrite.html` 'name='title', 'name='content' <br>
3. `Controller(/board/writepro)` <br>
4. `boardService` : boardRepository.save(board) <br>
5. `boardRepository` : DB로 넘기기 <br>

```
2022-03-03 15:18:42.321 DEBUG 10271 --- [nio-8080-exec-2] org.hibernate.SQL                        : 
    insert 
    into
        board
        (content, title) 
    values
        (?, ?)
```
**[해결 : Lombok]** <br>
@Entity를 선언하는 Board 에서 @Data를 선언하여 사용했다. <br>
@Data Lombok 을 사용하면 get 메소드를 이용할 수 있으나 메소드 사용 불가 오류 : Lombok 엔티티 전송에 오류가 있다고 판단 <br>
Lombok annotation 재설치 -> Board에서 인식되지 않던 title, content 인식 <br>
[1. board] <br>

![image](https://user-images.githubusercontent.com/98372474/156513831-0afa9c74-e84f-4162-a97e-1280041fefd8.png)
<br><br>

[2. controller] <br>

![image](https://user-images.githubusercontent.com/98372474/156513908-4eb1e11a-978d-4852-bba2-dd9a43fd2e8c.png)
<br><br>

[3. service] <br>

![image](https://user-images.githubusercontent.com/98372474/156513966-d5f0fa10-5132-4d76-b21e-87be4e4524ff.png)
<br><br>

[4. localhost:8080/board/write 작성] <br>

![image](https://user-images.githubusercontent.com/98372474/156513985-ca71ef7b-b6e3-463a-ae7f-730735be9e1f.png)
<br><br>

[5. 실행 결과 Terminal] <br> 

![image](https://user-images.githubusercontent.com/98372474/156514092-77dc28c6-0f02-4607-9007-feedb27881ac.png)
<br><br>

[6. DB 반영 : MySQLWorkbench] <br>

![image](https://user-images.githubusercontent.com/98372474/156514200-94cb105a-5eaa-4856-9d5b-c517020c71cf.png)
<br><br>


