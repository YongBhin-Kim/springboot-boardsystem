<h2>Spring Boot를 이용한 게시판 만들기(Docker image)</h2>



**[Environment]**
- Mac OS


**[Use]**
- Visual Studio Code 2
- Language : Java
- Framework : Spring Boot(Gradle)
- Database : MariaDB (Ver 15.1)
- View template : Thymeleaf
- MySQLWorkbench
- Access DB : JPA
- Docker image (아래설명)
<br><br><br>

**[Docker image 다운로드]**
- 다운로드 링크 - https://hub.docker.com/r/coji68/web-server/tags <br>
- 터미널에서 `docker pull coji68/web-server:1.0` 명령으로 이미지를 다운받는다.

<img width="400" height="280" alt="image" src="https://user-images.githubusercontent.com/98372474/166118656-8ac0503b-f735-48a2-80ec-6020a725a1f1.png"><br>
- Docker Desktop에 다음과 같이 coji68/web-server 이미지가 다운로드 되었다.
<br><br>


**[Docker 컨테이너 만들기]**

- 기존 사진 <br>
<img width="400" height="280" alt="image" src="https://user-images.githubusercontent.com/98372474/166118867-1253ac8e-2c99-4c55-b0a9-763ed326fe9b.png">
<br>

- 터미널에 `docker create -p [포트번호]:[포트번호] [이미지이름]` 입력하여 컨테이너 생성 <br>
<img width="500" height="100" alt="image" src="https://user-images.githubusercontent.com/98372474/166119002-780d2e62-de15-461e-a7ac-74574a11188a.png"> <br>

- 생성 후 <br>
<img width="400" height="280" alt="image" src="https://user-images.githubusercontent.com/98372474/166119100-c1807157-0851-4c8d-9874-5f4f1226b86d.png"> <br>




<br><br>


**[사전 설치]**
- **Homebrew** <br>
: Homebrew는 Mac OS에서 짧은 설치코드를 작성해 소프트웨어를 받을 수 있게 해주는 패키지 관리 시스템이다. <br>
: mac 터미널에 `/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"` 입력 <br>
: `brew -v` 명령으로 Homebrew 버전을 확인할 수 있다. <br>
<img width="663" alt="image" src="https://user-images.githubusercontent.com/98372474/161923892-fd2fdd06-5c74-44db-bfe9-8bff740d3058.png"> <br><br>


- **MariaDB** <br>
: 서로 관련 있는 데이터들의 집합을 데이터베이스라 하는데 , 데이터베이스 중 하나인 MariaDB를 설치한다. <br><br>
: mac 터미널에 `brew install mariadb` 입력 <br><br>
: `mariadb --version` 명령으로 mariadb의 버전을 확인할 수 있다. <br>
<img width="810" alt="image" src="https://user-images.githubusercontent.com/98372474/161925850-8de9053a-af91-4fe5-936b-2070cfe23470.png"> <br><br>
: mariadb 실행 명령어는 다음과 같다. `brew services start mariadb` <br>
<img width="681" alt="image" src="https://user-images.githubusercontent.com/98372474/161927113-6b3524dc-0a5a-4c46-9230-6f6aa3d67c7e.png"> <br><br>
: `brew services list` 명령으로 실행중인 서비스(mariadb 실행여부)를 확인할 수 있다. <br>
<img width="719" alt="image" src="https://user-images.githubusercontent.com/98372474/161936397-f3a77c73-404b-4ea5-828d-53a239410037.png"> <br><br>
: mariadb 종료 명령어는 다음과 같다. `brew services stop mariadb` <br>
<img width="647" alt="image" src="https://user-images.githubusercontent.com/98372474/161927630-198f8a7a-f6a7-47d0-81ec-bd8ee964f148.png"> <br><br>
: mariadb의 터미널에서 사용법(TUI)은 터미널에 `mysql -p -uroot` 명령을 입력하면 되는데, mysqlworkbench로 사용할 것이므로 생략한다. <br>
<img width="400" height="140" alt="image" src="https://user-images.githubusercontent.com/98372474/161928328-ee17e35c-4d5a-49ff-b716-011975a57f2c.png"> <br><br>

- **MySQLWorkbench** <br>
: mariadb를 터미널에서 TUI(Text-based user interface; 문자열 기반)환경으로 사용하는 대신에 GUI(graphical user interface; 그래픽 기반)환경으로 보기 쉽게 관리하기 위해 mariaDB의 GUI 툴인 MySQLWorkbench를 사용한다. <br><br>
: 다운로드 링크 - https://dev.mysql.com/downloads/mysql/ <br>
<img width="400" height="300" alt="image" src="https://user-images.githubusercontent.com/98372474/161930034-9efe37c7-df5b-4b24-a326-930d69dc15fa.png"> <br>
: 본인의 버전에 맞게 다운로드 받으면 된다. <br>
: 설치 중간 비밀번호 입력 란이 나오는데, root 사용자에서 사용할 비밀번호를 입력하면 된다. <br><br>
: MySQLWorkBench의 localhost에 들어간다.<br>
<img width="400" height="280" alt="image" src="https://user-images.githubusercontent.com/98372474/161939241-fa63cbd0-1df1-4fc1-bc70-c1b8b4c3a1f1.png"><br><br>
: Server Status가 Running임을 확인한다. <br>
<img width="400" height="280" alt="image" src="https://user-images.githubusercontent.com/98372474/161939788-a6e6b0fb-9a3a-4e8e-8011-ed6ec8e02d92.png"><br><br>
: 통모양을 눌러 스키마 생성 <br>
<img width="400" height="280" alt="image" src="https://user-images.githubusercontent.com/98372474/161940986-da3a7275-af0a-4d1a-af00-5c70a679675e.png"> <br><br>
: 적용 (apply) <br>
<img width="400" height="280" alt="image" src="https://user-images.githubusercontent.com/98372474/161941112-7e595c6d-5721-475c-88f4-b58eb98ae94f.png"> <br><br>
: yb 데이터베이스가 생성됨을 확인 <br>
<img width="400" height="280" alt="image" src="https://user-images.githubusercontent.com/98372474/161941270-b98558ca-e648-4bb7-aaef-08b3171b177b.png"> <br><br>


**[프로젝트 생성]**
- a

**[개발환경 세팅]**
- a

**[20-01-29 ~ 20-02-26]** <br>
- Web-Server 구축을 위한 Spring 개념, 원리 공부
<br>

**[20-02-26]** <br>

- Spring Project 생성
- DB 연결 (MariaDB)
<br>

**[20-02-27]** <br>

- Board Table 생성 (id, title, content) <br>
(board Database, board table)
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
- QueryString : 게시글 상세(Integer id), 게시글 삭제(Integer id), 게시글 검색(String searchKeyword) <br>
- Pathvariable : 게시글 수정(@PathVariable ("id")), 게시글 갱신 (@PathVariable ("id")) <br>
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
- 파일 업로드 기능 추가 `/board/write`
- 파일 업로드 기능 추가 `/board/modify` (진행중)
<br>

**[20-03-08]** <br>
- 파일 업로드 기능 추가 `/board/modify` (진행중) <br>
-> 우선 URL : `/board/modify` 에서는 파일 업로드 기능 없이 글 작성만 가능하게끔 구현 <br>
(`BoardService/modifyWrite` 구현 : 파일 업로드 기능 x) <br>
(`BoardController/boardUpdate` 에서 service 호출 : write -> modifyWrite) <br>
- 페이징 처리 기능 1 : 1page당 10개의 게시물 표시 (URL : localhost:8080/board/list?page={page}) <br>
(`BoardController/boardlist` : pageable 인터페이스 호출) <br>
(`BoardService/boardList` : pageable 파라미터 삽입) <br>
<br>

**[20-03-14]** <br>
- 페이징 처리 기능 2 : URL 직접 입력 없이 list 아래에 페이지 번호 추가 <br>
<br>

**[20-03-15]** <br>
- 게시글 검색 기능 구현 1 : `URL : localhost:8090/board/list?searchKeyword={searchKeyword}&page={page}` <br>
- 게시글 검색 기능 구현 2 : `URL : localhost:8090/board/list` 에서 검색 버튼 추가 <br>
<br>



<br><br>

<h3>[오류와 해결]</h3>
<br>

**[오류 : Lombok]** <br>

[20-02-28] <br>
null 오류 -> 해결 및 default 값 오류 -> 해결 및 작성 값 대신 default 값이 삽입 : wired가 안 되었나?

[20-03-02] <br>
BoardController의 boardWritePro에서 `boardService.write(board)` 오류 <br>
<= BoardService의 write에서 `boardRepository.save(board)` 오류

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


