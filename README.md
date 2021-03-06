

<img src = "https://blog.kakaocdn.net/dn/bgaNox/btrAheqdnVX/FUcX3krKTkr6akxv62kE3k/img.png" width="1000" height="500" />

# 에브리타임 클론코딩



## 프로젝트 5조
- 정재원(팀장) 
- 김정민
- 허희주


## 📌시연영상 [(유튜브 링크)](https://youtu.be/6T7MUtjkio8 "시연영상")





## ⚒️기술스택

### Backend
|<img src = "https://blog.kakaocdn.net/dn/cKtAuQ/btrAIO5fzCU/NVWnU8UlhL93kq81Ve87uK/img.png" width="150" height="150" />|
|:--:|
|SpringBoot  |

### Frontend
|<img src = "https://blog.kakaocdn.net/dn/cj5mLL/btrAJSMQt43/yfpTni01hZgrvKHmUdVjk1/img.png" width="150" height="150" />|<img src = "https://blog.kakaocdn.net/dn/eG2w1k/btrAD5NJ1dy/YwmkEkygLgmKevkYNgWiPk/img.png" width="150" height="150" />|<img src = "https://blog.kakaocdn.net/dn/dJtW2R/btrAIfhLlRL/cTJDpEZlRWh9m9QczAkGqK/img.png" width="150" height="150" />|<img src = "https://blog.kakaocdn.net/dn/biJtm8/btrAGfWUCEm/wLv8P9GuJP55PI0AWxOyS1/img.png" width="150" height="150" />|<img src = "https://blog.kakaocdn.net/dn/m3Phc/btrAGgBsKbm/FNYpkhIrVweUUEH4h5tsWK/img.png" width="150" height="150" />|
|:--:|:--:|:--:|:--:|:--:|
|HTML5|CSS|jQuery|Bootstrap|JavaScript|

### 협업도구
|<img src = "https://blog.kakaocdn.net/dn/eyjfrN/btrAKvXV0RA/zkyytdkZy7ESd85knYRDq1/img.png" width="150" height="150" />|<img src = "https://blog.kakaocdn.net/dn/mEK9t/btrAHjxWZX3/iEGILm2rWSrOKsfilmPUA1/img.png" width="150" height="150" />|<img src = "https://blog.kakaocdn.net/dn/b8aff2/btrAIfCbRi8/q2jxorX8z17gF4jFbKvFak/img.png" width="150" height="150" />|
|:--:|:--:|:--:|
|Git|Github|Trello|
### 데이터베이스
|<img src = "https://blog.kakaocdn.net/dn/5J8iY/btrAHiseB54/P1Pkgmigz1aANiQLg0Aip0/img.png" width="150" height="150" />|<img src = "https://blog.kakaocdn.net/dn/ccYmmf/btrAGfJoswn/gVqLJkEUq6WgY1MwOEopD1/img.png" width="150" height="150" />|
|:--:|:--:|
|MariaDB|MySQL|

### 의존성
```java
implementation 'org.springframework.boot:spring-boot-starter-mail' // java mail sender
implementation 'org.springframework.boot:spring-boot-starter-data-jpa' // jpa
implementation 'org.springframework.boot:spring-boot-starter-mustache' // mustache
implementation 'org.springframework.boot:spring-boot-starter-validation' // validation
implementation 'org.springframework.boot:spring-boot-starter-web' // spring web (mvc)
compileOnly 'org.projectlombok:lombok' // lombok
developmentOnly 'org.springframework.boot:spring-boot-devtools' // devtools
runtimeOnly 'org.mariadb.jdbc:mariadb-java-client' // mariaDB
annotationProcessor 'org.projectlombok:lombok'
testImplementation 'org.springframework.boot:spring-boot-starter-test'
```


## 기능 설명 (기능 영상 포함)

**에브리타임**은 전국 400개 대학을 지원하는 대학교 커뮤니티 및 시간표 서비스, 시간표 작성 및 학업 관리, 학교 생활 정보, 학교별 익명 커뮤니티 기능을 제공하는 사이트로써 이 페이지를 **클론 코딩** 했습니다.

### 🙋‍♀️유저 관련 기능

- 회원가입 시 유저 네임 중복 체크 기능
- 로그인 시 쿠키에 username 기억 기능
- 로그아웃 기능
- 이메일 변경 기능 : 입력한 비밀번호가 일치하면 이메일 변경
- 비밀번호 변경 기능
- 닉네임 변경 기능
- 회원 탈퇴 기능
- 아이디 찾기 : 입력받은 이메일로 유저를 찾은 뒤, 존재한다면 해당  **이메일로 유저네임 전송** 기능
- 임시 비밀번호 발급 기능 제공 : 이메일을 입력 받아 **세션 유저**와 **이메일이 동일한 유저**가 **DB에 존재**하면 해당 유저의 패스워드를 **6자리 난수로 변환**한 뒤 **이메일로 패스워드 전송** 기능
- 내가 쓴 글
- 내가 댓글 단 글
- 내가 스크랩 한 글

|||
| :------------: | :-------------: |
| 회원가입![회원가입](https://blog.kakaocdn.net/dn/nV2aC/btrAmzfyIzu/Xfn8qwfKkFMRzjtbhs5cO0/img.gif) | 로그아웃 후 로그인 ![로그아웃 후 로그인](https://blog.kakaocdn.net/dn/budn1v/btrAgoNoBmG/wL76LpbvGPLPzCKyKqzygk/img.gif) |
| 유저네임 찾기![아이디찾기](https://blog.kakaocdn.net/dn/Z3qMl/btrAmzNnqUn/FbdKbkgI0baS49vki1oGj0/img.gif) | 비밀번호 초기화![비밀번호초기화](https://blog.kakaocdn.net/dn/bSnZrS/btrAheqc8NG/o0qjTbETJZnQQ02EA8xnb1/img.gif) |
| 이메일 변경![이메일변경](https://blog.kakaocdn.net/dn/P12w4/btrAoIQBUPo/Cfz5PE4eEEFSA3Eg8jHhCK/img.gif) | 비밀번호 변경![비밀번호변경](https://blog.kakaocdn.net/dn/bLyfm6/btrAh8wwWad/iplWR0t6xzjNXtunXEn9I1/img.gif) |
| 닉네임 변경![닉네임변경](https://blog.kakaocdn.net/dn/nDih9/btrAlf9tQcD/X79PKFJJFxq0H82j52VWk0/img.gif) | 회원 탈퇴![회원탈퇴](https://blog.kakaocdn.net/dn/YoTc4/btrAoIJRrRM/H8LeITyku41zDGqoYhT5hK/img.gif) |
|내가 쓴 글![내가쓴글](https://blog.kakaocdn.net/dn/Y4L2G/btrAoJvetf3/QzkDvWEKUsgmhz17l8K7CK/img.png)|내가 댓글 단 글![내가댓글단글](https://blog.kakaocdn.net/dn/cPYVfw/btrAhejnF1y/MRwlM88uGDEKKtAGg4Ueek/img.png)|
|내가 스크랩 한 글![내가스크랩한글](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbjAHCx%2FbtrAhdEQQoh%2Fn6kwHbkUgaENypkkMP7l6k%2Fimg.png)|학교 인증![학교인증](https://blog.kakaocdn.net/dn/cCSsFu/btrAjn1fzi0/XBOfSteKWNyxAXYOkI3Ff1/img.gif)|




### 게시글 관련 기능

- 글 쓰기, 글 목록, 글 상세보기, 글 수정하기, 글 삭제하기, 글 공감하기, 글 스크랩하기, 댓글 쓰기, 댓글 삭제하기, 실시간 인기글(공감순) 기능 제공
- 로그인 하지 않으면 아무런 게시판에 들어갈 수 없음

|  |  |
|:------------------:|:------------------:|
|글 쓰기![글쓰기](https://blog.kakaocdn.net/dn/oeGEI/btrAlf9tQiA/hfOmRB5SVxzp73xBJikrFK/img.gif)  |글 수정, 삭제, 댓글쓰기![글 수정, 삭제, 댓글쓰기](https://blog.kakaocdn.net/dn/dtDYpv/btrAnF0UKNb/5JaBONVyoDkyhB4Kg9jF0K/img.gif)  |
|공감, 스크랩, 댓글 삭제![공감, 스크랩, 댓글 삭제](https://blog.kakaocdn.net/dn/cUv8NU/btrAj4G9ydW/4rQhQnXE2rQCrYGmKaN4s0/img.gif)|문의하기![문의하기](https://blog.kakaocdn.net/dn/eDhqtq/btrAmz0WVXX/yQIhFnIWC42joBxHGe84bk/img.gif)|



### 시간표 관련 기능

- 관리자가 만들어 둔 강의 목록과 교수 목록에 따라 자신의 시간표대로 그림 그리기 기능 제공

![시간표등록](https://blog.kakaocdn.net/dn/b9bAfo/btrAoHRHN8x/tWuoaMCKqQeF6JRwfUxgKk/img.gif) 


### 관리자 관련 기능

- **username = "admin"** 으로 로그인 시 관리자 페이지로 이동
- 시간표에 추가 가능한 교수 목록과 강의 목록 생성, 삭제 기능 제공

||  |
|:--:|:--:|
|관리자 로그인, 교수 등록, 삭제![관리자 로그인, 교수 등록, 삭제](https://blog.kakaocdn.net/dn/03Z9t/btrAnFs5FqP/AO7NNU9HWXKrk6XZHpNAh1/img.gif)|강의 등록, 삭제![강의 등록, 삭제](https://blog.kakaocdn.net/dn/bxU568/btrAhc60cN8/vUobJGGh2EduQe39LqtPq0/img.gif)|



# 모델링 연관관계

![ERD](https://blog.kakaocdn.net/dn/tVVh2/btrAj5zyWVI/OwFd10wKxascPFsej58jK0/img.png)



# 트렐로

https://trello.com/b/m8JW2hX8/everytime  
역할분담, 계획수립 등 트렐로를 유용하게 사용하였다.



# 블로그 테스트링크

- 공부 내용 블로그 정리  
https://jaewon2336.tistory.com/category/Spring/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8  

- 깃헙에 푸시한 테스트 코드  
https://github.com/jaewon2336/Everytime-timetable-Test  
https://github.com/jaewon2336/jpa-paging-search  
https://github.com/jaewon2336/Everytime-Back  
https://github.com/jaewon2336/Everytime-Front  
https://github.com/orangefield/Springboot-File-Upload-Sample  
 
# 보완할 점

- 학교 인증을 위해 받은 증명서를 관리자 페이지에서 확인 후 인증 처리
- 대댓글
- 글/댓글 신고 -> 5회 이상 신고당한 게시글/댓글은 관리자 페이지에서 유저 탈퇴(경고) 처리
- 게시글을 통해 글을 쓴 유저에게 쪽지 보내기 기능
- 쪽지 보내는 사용자 차단 기능
- 글 쓰기에서 파일 업로드 기능 + 썸네일
- 글 쓰기에서 해시 태그 기능 + 해시 태그로 검색 기능
- 완성 후 배포해보기
- 학점계산기 

# 느낀점

- 주소 설계, 변수명 등 설계 과정에 미흡한 점 때문에 놓친 시간이 많았던 점이 아쉽다. 다음 프로젝트에선 이 부분을 보완하여 더 꼼꼼한 설계가 필요해보인다.
- Github로 협업하며 PR 과정에서 머지 충돌이 많이 일어났다. 어떤 파일에서 어떤 부분이 변경되고 추가되었는지 확인했음에도 충돌이 나는 것으로 보아 커뮤니케이션이 부족했음을 깨달았다. 짧은 시간이라도 더 많은 회의와 소통이 필요함을 느꼈다.
- 회의 할 때 진행사항 확인을 위주로 진행했는데 내가 짠 코드를 소개하고 설명하면서 내 코드의 빈틈을 볼 수 있었다. 팀원의 피드백으로 한번 더 코드를 수정하는데 도움이 됐다. 정답이라고 생각하고 짰던 코드도 다시보니 지저분하게 보이기도 했다. 코드 리팩토링 과정은 꼭 필요한 것 같다.
- 실제 프로젝트 파일에 적용하기 전에 테스트 과정이 필수적이라고 느꼈다. 무거운 프로그램에서 돌려보기 전에 잘 작동하는 코드인지 테스트하지 않으면 어디에서부터 수정해야할지 막막했기 때문이다.
- 웹 사이트의 대부분의 기능이 CRUD 범주 안에 들어간다는 것이 신기했고, 계속해서 반복함으로써 개념이 더 확실하게 잡혔다.
- 프로젝트를 통해 공부했던 내용을 실제로 활용해 보며 부족한 점을 파악하고 보완하기 좋은 기회가 되었다.
