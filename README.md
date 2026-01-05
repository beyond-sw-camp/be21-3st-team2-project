# 2팀: 고구마 마켓
###  **고객과 구매자가 마주하는 마켓**
<tr align="center">
  <td>
    <img 
      src="https://github.com/user-attachments/assets/32394f9e-025b-4717-af12-5d19634bb333"
      alt="image"
      width="200"
    />
  </td>
</tr>

----

</br>

## 목차
### 1. 팀 소개
### 2. 프로젝트 개요
### 3. 유사 서비스
### 4. 개발 환경 및 기술 스택 
### 5. 프로젝트 구조
### 6. 프로젝트 기획
### 7. 컨벤션
### 8. 프로젝트 기능
### 9. 회고

</br>

----

</br>

## 1. 팀 소개
<table width="100%">
  <thead>
    <tr align="center">
      <th width="20%"> 정규원 </th>
      <th width="20%"> 진희헌 </th>
      <th width="20%"> 정하경 </th>
      <th width="20%"> 김수진 </th>
    </tr>
  </thead>
  <tbody>
    <tr align="center">
      <td><img width="1024" height="535" alt="image" src="https://github.com/user-attachments/assets/89d0d8a2-0709-419b-be8f-ef3d8105bb2e" width="80%" /></td>
      <td><img width="1024" height="535" alt="image" src="https://github.com/user-attachments/assets/44b45f0e-f5d6-4ba3-b94f-122be36ccdb2" width="80%" /></td>
      <td><img width="1024" height="559" alt="image" src="https://github.com/user-attachments/assets/1db1c290-f118-4286-913d-0ef807d959da" width="80%" /></td>
      <td><img width="1024" height="535" alt="image" src="https://github.com/user-attachments/assets/e7d34bac-2268-4af1-95e9-52a1a38c6b13" width="80%" /></td>
    </tr>
  </tbody>
  <tbody>
    <tr align="center">
      <td> 헤더/게시글 상세조회 </td>
      <td> 유저/보안 </td>
      <td> 메인 페이지 </td>
      <td> 게시글 전체보기/ 글쓰기 </td>
    </tr>
  </tbody>
</table>

</br>

----

</br>

## 2. 프로젝트 개요
### 소개
- **고구마 마켓** 은 지역 기반 중고 거래 서비스인 *당근마켓*을 모티브로 한 **중고 거래 플랫폼 클론 프로젝트**입니다.  
- 사용자는 물품을 등록하고, 목록을 조회하며, 간단한 검색과 카테고리 분류를 통해 원하는 상품을 빠르게 찾을 수 있습니다.
- 본 프로젝트는 **프론트엔드와 백엔드 분리 구조**로 설계되었으며, 실제 서비스와 유사한 사용자 경험(UX)을 제공하는 것을 목표로 개발되었습니다.
### 선정 이유
- 지역 기반 중고 거래 서비스는 **실제 사용자 흐름이 명확하고 기능 단위가 분명**하여 협업 프로젝트에 적합하다고 판단하였습니다.
- 인증, 게시글 CRUD, 검색, 파일 업로드 등 **웹 서비스의 핵심 기능을 전반적으로 경험**할 수 있는 주제입니다.
- 프론트엔드와 백엔드를 분리하여 개발함으로써 **실제 서비스와 유사한 개발 프로세스**를 경험하고자 하였습니다.
- 대중적으로 익숙한 서비스(당근마켓)를 기반으로 하여 **기획과 UX에 대한 이해도를 높이고 구현에 집중**할 수 있다고 판단하였습니다.
### 주요 기능
> 메인 페이지
- 서비스의 전체 흐름을 한눈에 확인할 수 있는 메인 화면 구성
- 최신 등록 상품 및 중고 거래 목록 노출
- 공통 헤더 및 검색 바 제공
> 중고 거래 게시판 (상품 목록)
- 등록된 중고 물품 목록 조회
- 카드형 UI를 활용한 상품 정보 표시
    - 상품 이미지
    - 제목
    - 가격
    - 등록 시간
- 카테고리별 상품 분류 기능
> 상품 등록 기능
- 사용자가 판매하고자 하는 중고 물품 등록
- 상품 정보 입력
    - 제목
    - 가격
    - 설명
    - 카테고리
- 등록 완료 시 목록 페이지에 즉시 반영
> 검색 기능
- 키워드 기반 상품 검색
- 제목 기준 검색을 통한 원하는 상품 빠른 탐색
- 검색 결과에 따른 상품 목록 동적 렌더링
> 로그인 기능
- 사용자 인증을 위한 로그인 기능 구현
- 로그인 상태에 따른 기능 접근 제어
    - 로그인 사용자만 상품 등록 가능
- 인증 정보 기반 사용자 식별

</br>

----

</br>

## 3. 유사 서비스 
### 당근 마켓
- 지역 인증을 기반으로 한 중고 거래 플랫폼으로, **동네 중심의 거래 경험**을 제공합니다.
- 직관적인 UI와 간단한 게시글 작성 흐름으로 **사용자 접근성이 높은 서비스**입니다.
- 채팅, 관심 상품, 카테고리 분류 등 **중고 거래에 최적화된 기능 구조**를 가지고 있습니다.

</br>

----

</br>
## 4. 개발 환경 및 기술 스택

### Backend
- Java <img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white">
- Spring Boot <img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
- Spring Security <img src="https://img.shields.io/badge/Spring%20Security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white">
- MariaDB <img src="https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=white">
- Redis <img src="https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=redis&logoColor=white">
- MinIO <img src="https://img.shields.io/badge/MinIO-C72E49?style=for-the-badge&logo=minio&logoColor=white">

### Frontend
- Vue.js <img src="https://img.shields.io/badge/Vue.js-4FC08D?style=for-the-badge&logo=vue.js&logoColor=white">
- Axios <img src="https://img.shields.io/badge/Axios-5A29E4?style=for-the-badge&logo=axios&logoColor=white">

### IDE & Tools
- IntelliJ IDEA <img src="https://img.shields.io/badge/IntelliJ%20IDEA-000000?style=for-the-badge&logo=intellijidea&logoColor=white">
- Git <img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white">

### Collaboration
- GitHub <img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white">
- Jira <img src="https://img.shields.io/badge/Jira-0052CC?style=for-the-badge&logo=jira&logoColor=white">
- Notion <img src="https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=notion&logoColor=white">
- Discord <img src="https://img.shields.io/badge/Discord-5865F2?style=for-the-badge&logo=discord&logoColor=white">


</br>

----

</br>

## 5. 프로젝트 구조

### Back-end 구조
<img width="456" height="931" alt="image" src="https://github.com/user-attachments/assets/4b28d522-8392-4971-8588-f9a90cf7b0c9" />

### Front-end 구조
<img width="526" height="808" alt="image" src="https://github.com/user-attachments/assets/7f29733a-05a7-4643-b2fd-392c8537a81b" />

</br>

----

</br>

## 6. 프로젝트 기획
### 요구사항 명세서
<img width="1204" height="618" alt="image" src="https://github.com/user-attachments/assets/aa64cb70-deb3-459d-a7b8-f52ca373eee9" />

### 스토리보드(figma)

<details>
<summary style = " font-size:1.3em;"> 더 보기 </summary>
<div markdown="1">

  <img width="1780" height="980" alt="image" src="https://github.com/user-attachments/assets/f1a522b2-fed6-4b33-b60b-3e1193a54294" />

  <img width="1780" height="980" alt="image" src="https://github.com/user-attachments/assets/cf0a2472-af26-45e6-9fa8-6e7415f7d00d" />

  <img width="1780" height="980" alt="image" src="https://github.com/user-attachments/assets/377771ae-0f05-4423-a0d2-796593018dc9" />

  <img width="1780" height="980" alt="image" src="https://github.com/user-attachments/assets/e8606eaa-5d3d-4a80-bd23-4913b85b1b75" />

  <img width="1780" height="980" alt="image" src="https://github.com/user-attachments/assets/377705a7-34bd-4c70-9072-e84a7d2f524b" />

<img width="1780" height="980" alt="image" src="https://github.com/user-attachments/assets/6903e237-997c-449c-95ad-75d4759c0c98" />

<img width="1780" height="980" alt="image" src="https://github.com/user-attachments/assets/f7fc19af-7ef2-44c2-9f4c-1ef0f0136257" />

<img width="1780" height="980" alt="image" src="https://github.com/user-attachments/assets/97b29b9b-d771-4754-aab4-8d3b61168263" />

<img width="1780" height="980" alt="image" src="https://github.com/user-attachments/assets/5a5a761e-e296-4637-ba14-089b26d4645b" />

<img width="1780" height="980" alt="image" src="https://github.com/user-attachments/assets/b51a4949-b128-4420-9b40-27dc7a91f937" />

<img width="1780" height="980" alt="image" src="https://github.com/user-attachments/assets/d744377d-a6e3-43e2-9a52-b209bc62a63b" />

<img width="1780" height="980" alt="image" src="https://github.com/user-attachments/assets/0fc00428-52e4-417b-b08b-462dfe141e3b" />

<img width="1780" height="980" alt="image" src="https://github.com/user-attachments/assets/eeae6d6b-5e4d-4ee3-9088-921527708984" />

</div>
</details>

### 테스트 케이스 
<img width="1481" height="383" alt="image" src="https://github.com/user-attachments/assets/ade6ef50-1ea9-46ba-a80b-a16778ceda9e" />

### 화면구현코드소스 
<img width="611" height="492" alt="image" src="https://github.com/user-attachments/assets/afb81a99-4f31-4ec9-9a37-e702a23aaf73" />

</br>

----

</br>

## 7. 컨벤션

## Back-end
### 공통 사항
- 단위 테스트 작성(service 메소드 별로) : Junit 사용
- 다른 사람이 알아보기 쉽도록 주석처리해야 합니다.
    - javadoc 형식 https://jake-seo-dev.tistory.com/59
- 지라 티켓 생성하고 작업 시작합시다.
- 사용 내역 같은 로그 확인할 수 있도록 잘 남겨야 합니다.


<br>

### 개발규칙

**Code Convention**

<details>
<summary style = " font-size:1.3em;">Naming</summary>
<div markdown="1">

- 패키지 : 언더스코어(`_`)나 대문자를 섞지 않고 소문자를 사용하여 작성합니다.
- 클래스 : 클래스 이름은 명사나 명사절로 지으며, 대문자 카멜표기법(Upper camel case)을 사용합니다.
- 메서드 : 메서드 이름은 동사/전치사로 시작하며, 소문자 카멜표기법(Lower camel case)를 사용합니다. 의도가 전달되도록 최대한 간결하게 표현합니다.
- 변수 : 소문자 카멜표기법(Lower camel case)를 사용합니다.
- ENUM, 상수 : 상태를 가지지 않는 자료형이면서 `static final`로 선언되어 있는 필드일 때를 상수로 간주하며, 대문자와 언더스코어(Upper_snake_case)로 구성합니다.
- DB 테이블: 소문자와 언더스코어로(lower_snake_case) 구성합니다.
- 컬렉션(Collection): **복수형**을 사용하거나 **컬렉션을 명시합니다**. (Ex. userList, users, userMap)
- LocalDateTime: 접미사에 **Date**를 붙입니다.


</div>
</details>
<details>
<summary style = " font-size:1.3em;">Comment</summary>
<div markdown="1">

**1. 한줄 주석은 // 를 사용한다.**

```java
// 하이~
```

**2. Bracket 사용 시 내부에 주석을 작성한다.**

```java
/*
   하이~!
*/
```

**3. 주요 함수에 대한 주석**

```java
/*
 * 입력 : 인덱스:Long
 * 기능 : 유저 인덱스로 db에 접근해 유저 객체를 반환한다
 * 출력 : 유저:User
 */
public User getUser(Long idx)
```

</div>
</details>
<details>
<summary style = " font-size:1.3em;">Import</summary>
<div markdown="1">

**1. 소스파일당 1개의 탑레벨 클래스를 담기**

> 탑레벨 클래스(Top level class)는 소스 파일에 1개만 존재해야 한다. ( 탑레벨 클래스 선언의 컴파일타임 에러 체크에 대해서는 [Java Language Specification 7.6](http://docs.oracle.com/javase/specs/jls/se7/html/jls-7.html#jls-7.6) 참조 )

**2. static import에만 와일드 카드 허용**

> 클래스를 import할때는 와일드카드(`*`) 없이 모든 클래스명을 다 쓴다. static import에서는 와일드카드를 허용한다.

**3. 애너테이션 선언 후 새줄 사용**

> 클래스, 인터페이스, 메서드, 생성자에 붙는 애너테이션은 선언 후 새줄을 사용한다. 이 위치에서도 파라미터가 없는 애너테이션 1개는 같은 줄에 선언할 수 있다.

**4. 배열에서 대괄호는 타입 뒤에 선언**

> 배열 선언에 오는 대괄호(`[]`)는 타입의 바로 뒤에 붙인다. 변수명 뒤에 붙이지 않는다.

**5. `long`형 값의 마지막에 `L`붙이기**

> long형의 숫자에는 마지막에 대문자 'L’을 붙인다. 소문자 'l’보다 숫자 '1’과의 차이가 커서 가독성이 높아진다.

</div>
</details>
<details>
<summary style = " font-size:1.3em;">URL</summary>
<div markdown="1">

**URL**

URL은 RESTful API 설계 가이드에 따라 작성합니다.

- HTTP Method로 구분할 수 있는 get, put 등의 행위는 url에 표현하지 않습니다.
- 마지막에 `/` 를 포함하지 않습니다.
- `_` 대신 `-`를 사용합니다.
- 소문자를 사용합니다.
- 확장자는 포함하지 않습니다.


</div>
</details>

<br>

**Commit Convention**


<details>
<summary style = " font-size:1.3em;">Rules</summary>
<div markdown="1">

**1. Git Flow**

작업 시작 시 선행되어야 할 작업은 다음과 같습니다.


> 1. issue를 생성합니다.
> 2. feature branch를 생성합니다.
> 3. add → commit → push → pull request 를 진행합니다.
> 4. pull request를 develop branch로 merge 합니다.
> 5. 이전에 merge된 작업이 있을 경우 다른 branch에서 진행하던 작업에 merge된 작업을 pull 받아옵니다.
> 6. 종료된 issue와 pull request의 label을 관리합니다.

**2. IntelliJ**

IntelliJ로 작업을 진행하는 경우, 작업 시작 시 선행되어야 할 작업은 다음과 같습니다.

> 1. 깃허브 프로젝트 저장소에서 issue를 생성합니다.
> 2. IntelliJ의 git 탭 → local develop branch 우클릭 → update 를 진행합니다.
> 3. IntelliJ의 git 탭 → local develop branch 우클릭 → new branch from ‘develop’ 을 진행합니다.
> 4. 생성한 issue 번호에 맞는 feature branch를 생성함과 동시에 feature branch로 checkout 합니다.
> 5. feature branch에서 issue 단위 작업을 진행합니다.
> 6. 작업 완료 후, add → commit을 진행합니다.
> 7. push 하기 전, remote develop branch의 변경 사항을 확인하기 위해 2번 과정을 다시 수행합니다.
> 8. IntelliJ의 git 탭 → local develop branch 우클릭 → merge ‘develop’ into ‘4번 과정에서 생성한 feature branch’ 를 진행합니다.
> 9. 만약 코드 충돌이 발생하였다면, IntelliJ에서 코드 충돌을 해결하고 add → commit을 진행합니다.
> 10. push → pull request (feature branch → develop branch) 를 진행합니다.
> 11. pull request가 작성되면 작성자 이외의 다른 팀원이 code review를 진행합니다.
> 12. 최소 한 명 이상의 팀원에게 code review와 approve를 받은 경우 pull request 생성자가 merge를 진행합니다.
> 13. 종료된 issue와 pull request의 label과 milestone을 관리합니다.


**3. Etc**

준수해야 할 규칙은 다음과 같습니다.

> 1. develop branch에서의 작업은 원칙적으로 금지합니다. 단, README 작성은 develop branch에서 수행합니다.
> 2. commit, push, merge, pull request 등 모든 작업은 오류 없이 정상적으로 실행되는 지 확인 후 수행합니다.

</div>
</details>

<details>
<summary style = " font-size:1.3em;">Branch</summary>
<div markdown="1">

**1. Branch**

branch는 작업 단위 & 기능 단위로 생성하며 이는 issue를 기반으로 합니다.

**2. Branch Naming Rule**

branch를 생성하기 전 issue를 먼저 작성합니다. issue 작성 후 생성되는 번호와 domain 명을 조합하여 branch의 이름을 결정합니다. `<Prefix>/<JiraEpicNumber>-<Domain>` 의 양식을 준수합니다.

**3. Prefix**

- `main` : 개발이 완료된 산출물이 저장될 공간입니다.
- `develop`: feature branch에서 구현된 기능들이 merge될 default branch 입니다.
- `feature`: 기능을 개발하는 branch 입니다. 이슈 별 & 작업 별로 branch를 생성 후 기능을 개발하며 naming은 소문자를 사용합니다.

**4. Domain**

- `approval`, `attendance`, `auth`, `security`, `comm`, `alarm`, `resource`, `error`, `config` 


**5. Etc**

- `feature/APPR-2-approval`, `feature/APPR-1-config`


</div>
</details>

<details>
<summary style = " font-size:1.3em;">Issue</summary>
<div markdown="1">

**1. Issue**

작업 시작 전 issue 생성이 선행되어야 합니다. issue 는 작업 단위 & 기능 단위로 생성하며 생성 후 표시되는 issue number 를 참조하여 branch 이름과 commit message를 작성합니다.

issue 제목에는 기능의 대표적인 설명을 적고 내용에는 세부적인 내용 및 작업 진행 상황을 작성합니다.

issue 생성 시 github 오른편의 assignee, label을 적용합니다. assignee는 해당 issue 담당자, label은 작업 내용을 추가합니다.

**2. Issue Naming Rule**

`[<Prefix>] <Description>` 의 양식을 준수하되, prefix는 commit message convention을 따릅니다.

**3. Etc**

<aside>
[feat] 약속 잡기 API 구현
<br/>[chore] spring data JPA 의존성 추가

</aside>

---

</div>
</details>

<details>
<summary style = " font-size:1.3em;">Commit</summary>
<div markdown="1">

**1. Commit Message Convention**

`[<Prefix>] #<Issue_Number> <Description>` 의 양식을 준수합니다.

- **feat** : 새로운 기능 구현 `[feat] #11 구글 로그인 API 기능 구현`
- **fix** : 코드 오류 수정 `[fix] #10 회원가입 비즈니스 로직 오류 수정`
- **del** : 쓸모없는 코드 삭제 `[del] #12 불필요한 import 제거`
- **docs** : README나 wiki 등의 문서 개정 `[docs] #14 리드미 수정`
- **refactor** : 내부 로직은 변경 하지 않고 기존의 코드를 개선하는 리팩터링 `[refactor] #15 코드 로직 개선`
- **chore** : 의존성 추가, yml 추가와 수정, 패키지 구조 변경, 파일 이동 `[chore] #21 yml 수정`, `[chore] #22 lombok 의존성 추가`
- **test**: 테스트 코드 작성, 수정 `[test] #20 로그인 API 테스트 코드 작성`
- **style** : 코드에 관련 없는 주석 달기, 줄바꿈

</div>
</details>

<details>
<summary style = " font-size:1.3em;">Pull Request</summary>
<div markdown="1">

**1. Pull Request**

develop & main branch로 merge할 때에는 pull request가 필요합니다. pull request의 내용에는 변경된 사항에 대한 설명을 명시합니다.

**2. Pull Request Naming Rule**

`[<Prefix>] <Description>` 의 양식을 준수하되, prefix는 commit message convention을 따릅니다.

**3. Etc**

[feat] 약속 잡기 API 구현
<br/>[chore] spring data JPA 의존성 추가

</div>
</details>

</br>

----

## 9. 회고

<details>
<summary style = " font-size:1.3em;"> 정규원 </summary>
<div markdown="1">
프론트로서 Vue는 처음 경험한 부분이라 살짝 익숙하지 않고 어려움이 많았었는데, 이번 프로젝트를 통해 한츰 더 익숙해진 계기가 되었던 것 같습니다.

</div>
</details>

<details>
<summary style = " font-size:1.3em;">진희헌 </summary>
<div markdown="1">
이번 프로젝트에서 JWT 기반 보안 시스템을 직접 구현했다. 처음 도전해보는 보안 영역이었기에 Access Token과 Refresh Token의 역할과 차이를 이해하는 것부터 시작했고, Access Token은 탈취 시 피해를 최소화하기 위해 짧은 수명을 가져야 하며 Refresh Token은 잦은 재로그인을 방지하기 위해 상대적으로 긴 수명을 가져야 한다는 점, 그리고 TTL(Time To Live)이 토큰의 유효 기간을 서버 차원에서 통제하는 핵심 개념이라는 것을 알게 되었다. 설계 과정에서는 회원가입, 로그인, 로그아웃 로직을 하나의 컨트롤러와 서비스에 두는 것이 과연 적절한가라는 고민을 하게 되었고, 사용자 도메인과 인증 도메인을 user와 auth로 분리하는 것이 역할과 책임 측면에서 더 바람직하다는 판단에 이르렀다. 로그아웃을 단순히 “토큰을 삭제하는 행위”로 생각했지만, JWT는 이미 발급된 토큰을 서버에서 직접 회수할 수 없다는 구조적 한계를 가진다는 점을 이해하게 되었고, 이를 해결하기 위해 Redis에 Blacklist를 저장하여 Access Token의 남은 TTL 동안만 요청을 차단하는 방식으로 로그아웃을 구현했다.
</div>
</details>

<details>
<summary style = " font-size:1.3em;"> 정하경 </summary>
<div markdown="1">
이번 프로젝트에서 SearchBar, 동작 애니메이션이 적용된 텍스트, 중고거래 아이콘(Buy/Sell) 컴포넌트를 구현하고, 이를 MainPage에 적용한 뒤 라우터 연결까지 진행함.

초기에는 HTML, JavaScript, CSS를 하나의 파일에 작성하려 했으나, 팀원의 권유로 컴포넌트 단위로 분리하여 개발하게 되었음. 그 과정에서 페이지는 pages, 재사용 가능한 UI는 components로 분리하는 구조가 유지보수 측면에서 유리하다는 점을 체감함.

또한 프로젝트 시작 단계에서 라우터 구조를 미리 고려하지 않고 개발을 진행하여, 이후 라우터를 적용하는 과정에서 어려움을 겪었음. 이 경험을 통해 초기에 라우터를 설계해 두는 것이 전체 화면 흐름을 이해하고 개발하는 데 중요하다는 점을 알게 되었음.
</div>
</details>

<details>
<summary style = " font-size:1.3em;"> 김수진</summary>
<div markdown="1">
이번 프로젝트를 통해서, vue라는 것을 처음 써봤는데, 하나의 페이지가 단일 파일로 여러 컴포넌트로 조합되어 화면을 만든다는 점이 인상깊었다. 처음에는 컴포넌트 구조와 데이터 흐름이 익숙하지 않아 어색함을 느꼈지만, 기능별로 컴포넌트를 분리하면서 코드의 가독성과 재사용성이 높아진다는 장점을 체감할 수 있었다.
 또한, 프론트엔드 개발은 단순히 화면을 구현하는 것이 아니라, 컴포넌트 구조와 데이터 흐름을 설계하는 과정이라는 것을 느꼈다.
</div>
</details>
# be21-3st-team2-project
