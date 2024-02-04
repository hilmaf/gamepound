
# 📝 GamePound 
![OT130I1222](https://github.com/hilmaf/gamepound/assets/142950442/1797c064-6dcf-4c83-9e2e-297b32c931fa)
<br>

### 🔍 프로젝트 소개

> 인디게임을 출시하고 싶은 사람들을 위한 펀딩플랫폼 입니다.<br>누구나 프로젝트를 등록하고 자유롭게 후원할 수 있는 사이트 입니다.

* 프로젝트 이름 : **GamePound**
* 프로젝트 기간 : 2023년 12월 17일 ~ 2024년 1월 30일

<br>

### ✨팀원 구성
|한윤지|이경민|현지연|
|:---:|:---:|:---:|
|[@HanYJ0000](https://github.com/HanYJ0000)|[@hilmaf](https://github.com/hilmaf)|[@hyunDelay](https://github.com/hyunDelay)|
|Team Leader|Configuration Management Developer|DB Management Developer|
|- 프로젝트 조회<br>- 회원 마이페이지<br>- 사용자 관리[어드민]<br>- 후원자 관리[어드민]|- 프로젝트 검색, 후원<br>- 프로젝트 마이페이지<br>- 프로젝트 관리[어드민]|- 프로젝트 펀딩 등록<br>- 회원 전반 기능<br>- 카테고리 관리[어드민]<br>- 결제내역 관리|

<br>

### 💻 개발 환경

> **Front**
<div>
<img src="https://img.shields.io/badge/HTML5-e34f26?style=flat&logo=html5&logoColor=white" height="25px" />
<img src="https://img.shields.io/badge/CSS3-1572B6?style=flat&logo=css3&logoColor=white" height="25px" />
<img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat&logo=javascript&logoColor=white" height="25px" />
<img src="https://img.shields.io/badge/React-61DAFB?style=flat&logo=react&logoColor=white" height="25px" />
<img src="https://img.shields.io/badge/Bootstrap-05054B?style=flat&logo=bootstrap&logoColor=white" height="25px" />
</div><br>

> **Back**

<div>
  <img src="https://img.shields.io/badge/JAVA-056db6?style=flat&logo=&logoColor=white" height="25px" />
  <img src="https://img.shields.io/badge/Spring-6DB33F?style=flat&logo=spring&logoColor=white" height="25px" />
  <img src="https://img.shields.io/badge/Oracle-F80000?style=flat&logo=oracle&logoColor=white" height="25px" />
</div><br>

> **Server**

<div>
<img src="https://img.shields.io/badge/Apache tomcat-F8DC75?style=flat&logo=apachetomcat&logoColor=white" height="25px" />
</div><br>

> **Using Editors**

<div>
<img src="https://img.shields.io/badge/Sts3-6DB33F?style=flat&logo=spring&logoColor=white" height="25px" />
<img src="https://img.shields.io/badge/Visual Studio Code-007ACC?style=flat&logo=visualstudiocode&logoColor=white" height="25px" />
</div><br>

> **Operating System**

<div>
<img src="https://img.shields.io/badge/Windows 11-0078D4?style=flat&logo=windows11&logoColor=white" height="25px" />
</div>
<br>

> **Tools**

<div>
  <img src="https://img.shields.io/badge/Notion-000000?style=flat&logo=notion&logoColor=white" height="25px" />
  <img src="https://img.shields.io/badge/Postman-FF6C37?style=flat&logo=postman&logoColor=white" height="25px" />
  <img src="https://img.shields.io/badge/GitHub-181717?style=flat&logo=github&logoColor=white" height="25px" />
  <img src="https://img.shields.io/badge/SQL developer-181717?style=flat&logo=oracle&logoColor=white" height="25px" />
  <img src="https://img.shields.io/badge/SourceTree-0052CC?style=flat&logo=sourcetree&logoColor=white" height="25px" />
</div>

<br><br>

### ✔ Erd Cloud
![게임파운드-erd](https://github.com/hilmaf/gamepound/assets/142950442/5c80e138-aa04-419a-81bd-49adb0202247)
> GamePound ERD :: [https://www.erdcloud.com/d/piypJNcHdJm2qQjiz](https://www.erdcloud.com/d/piypJNcHdJm2qQjiz)

<br><br>


### 🔧 사용한 Api
* React Quill
* KakaoPay 결제
* React Datepicker
<br><br>

### ⚙️ 개발 내용

#### 로그인, 회원가입
|로그인 기능|회원가입 기능|
|:---|:---|
|![login](https://github.com/hilmaf/gamepound/assets/142950442/c953f059-a6dc-4366-98ba-6e423dbab6eb)|![join](https://github.com/hilmaf/gamepound/assets/142950442/0beed667-93ff-4bcb-b8ec-88c3508526f0)|
|이메일과 비밀번호를 입력하면 비밀번호를 스프링 시큐리티match함수로 비교하여 일치 여부를 확인 한 후 일치 시 로그인 성공처리 됩니다.|이름과 이메일주소, 비밀번호를 입력하고 회원가입을 할 수 있습니다.<br>이메일은 중복확인 버튼을 클릭하고 DB에서 중복된 이메일이 있는지 검증하게 됩니다.<br>중복검사가 완료되면 입력된 이메일로 인증메일을 보내게 됩니다. 이메일로 인증번호가 전송됩니다.<br>인증번호를 입력 후 인증버튼을 클릭하면 서버에 변수로 저장된 인증번호와 비교하여 일치 시 인증에 성공합니다.<br>마지막으로 가입하기 버튼을 클릭해 모든 검증이 완료되었는지 검증 후 MEMBER테이블에 INSERT됩니다.|

#### 비밀번호 찾기 후 재설정
|비밀번호 찾기|비밀번호 재설정|
|:---|:---|
|![findPwd](https://github.com/hilmaf/gamepound/assets/142950442/adf69195-e0df-4fce-bf66-1be389b09fd7)|![newPwd](https://github.com/hilmaf/gamepound/assets/142950442/54f4fc61-9054-4ef8-996a-84047a8b2874)|
|비밀번호 찾기 페이지로 들어오면 이메일을 입력하고 비밀번호 설정링크를 입력한 이메일로 받게됩니다.|링크를 클릭하면 비밀번호 재설정 화면으로 들어가게 됩니다.<br>비밀번호를 입력한 후 완료버튼을 클릭하면 두 번 입력한 비밀번호가 일치하는지 검증 후 암호화되어 MEMBER테이블에 UPDATE됩니다.|

#### 프로젝트 펀딩 등록
|펀딩 등록 시작|기본정보 설정|펀딩계획 설정|
|:---|:---|:---|
|![projectCreate1](https://github.com/hilmaf/gamepound/assets/142950442/892609ac-3fe5-41d1-b918-34eef9deda1f)|![projectCreate2](https://github.com/hilmaf/gamepound/assets/142950442/e9fb3054-3224-4b65-a278-c7d867b98cfc)|![projectCreate3](https://github.com/hilmaf/gamepound/assets/142950442/b62f1b93-c716-4035-b3e6-4fc35ba56d4e)|
|프로젝트 작성중인 내역이 있을 시 화면에 보여지게 됩니다.<br>프로젝트 시작하기 버튼을 누를 시 프로젝트 테이블에 카테고리와 함께insert됩니다.|작성된 내용이 있다면 조회됩니다. (공통)<br>프로젝트의 카테고리, 제목, 대표이미지를 수정할 수 있습니다.<br>저장하지 않고 다른 탭을 클릭 시 작성중인 내용이 있음을 알립니다. (공통)<br>Header에 저장버튼을 누르면 프로젝트 테이블에 UPDATE 됩니다. (공통)<br>작성한 input에 내용이 있으면 프로젝트 기획 작성률이 계산됩니다. (공통)|목표금액과 펀딩일자를 수정할 수 있습니다.<br>사용자의 편의를 위해 react datepicker 라이브러리를 사용하였습니다.|

|선물 구성 설정|프로젝트 계획 설정|창작자 정보 설정|프로젝트 승인요청|
|:---|:---|:---|:---|
|![projectCreate4](https://github.com/hilmaf/gamepound/assets/142950442/b542a27c-c251-4309-a472-1f20162a7899)|![projectCreate5](https://github.com/hilmaf/gamepound/assets/142950442/b020531e-7461-4e55-94f5-a3ad8c97c498)|![projectCreate6](https://github.com/hilmaf/gamepound/assets/142950442/367828ce-02b3-4f99-935c-06efda44add7)|![projectCreate7](https://github.com/hilmaf/gamepound/assets/142950442/fe8d3daa-8762-46ff-be68-3d7def1be8a3)|
|선물의 이름과 금액을 추가할 수 있습니다. INSERT로 테이블에 추가됩니다.<br>왼쪽에 선물 리스트를 클릭하면 수정하기 화면으로 전환되며 수정할 수 있습니다. UPDATE로 테이블에 수정됩니다.<br>왼쪽 선물리스트의 삭제버튼을 클릭 시 선물이 삭제됩니다. DELETE로 처리됩니다.|프로젝트 상세조회에 나타나는 내용을 등록할 수 있습니다.<br>사용자의 편의를 위해 react quill 라이브러리를 사용하였습니다.|프로젝트 마감 후 창작자에게 정산될 정산계좌와 이름을 입력하게 됩니다.<br>창작자 정산 테이블에 내용이 있으면 UPDATE되고 없다면 INSERT하게 됩니다.|모든 항목이 전부 작성되면 작성률이 100%로 바뀌면서 승인요청 버튼이 나타나게 됩니다.<br>승인요청 버튼을 클릭 시 프로젝트의 승인여부 칼럼이 Y로 UPDATE됩니다.|


#### [어드민] 로그인, 카테고리 관리, 결제내역 관리
|로그인|카테고리 관리|결제내역 관리|
|:---|:---|:---|
|![adminLogin](https://github.com/hilmaf/gamepound/assets/142950442/1c7da07e-b4db-426b-b4c5-24729639b076)|![adminCategory](https://github.com/hilmaf/gamepound/assets/142950442/76fbf797-31dd-42a4-adc9-f23b968df587)|![adminPayment](https://github.com/hilmaf/gamepound/assets/142950442/38d5c685-aa6f-41e2-a065-05b0c815bf70)|
|관리자 계정으로 로그인 할 수 있습니다.<br>로그인을 하지않고 다른 어드민 url로 요청을 보낼 경우 로그인 검증이 진행됩니다.|카테고리 목록을 10개씩 조회합니다. 페이징 처리가 되어있습니다.<br>검색 시 검색한 내용을 10개씩 조회합니다. 페이징 처리가 되어있습니다.<br>카테고리 추가 버튼 클릭 시 카테고리를 생성할 수 있습니다. 카테고리 테이블에 INSERT됩니다.<br>같은 방식으로 카테고리 목록 행을 클릭 시 카테고리 상세정보가 조회되며 수정할 수 있습니다. 카테고리 테이블에 UPDATE 됩니다.|결제내역 목록을 10개씩 조회합니다. 페이징 처리가 되어있습니다.<br>검색 시 검색한 내용을 10개씩 조회합니다. 페이징 처리가 되어있습니다.|

