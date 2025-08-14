<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- jsp 기능 제공 받는 코드 -->
<jsp:include page = "/header.jsp"></jsp:include>

    <h3>회원가입</h3>
    아이디 : <input type="text" class ="idInput" onkeyup="idCheck()"/><br/> <!-- onkeyup = 카크업 키를 떼었을 때 -->
    <div class ="idCheck"></div>  <!-- 아이디 중복검사 -->
    비밀번호 : <input type="password" class ="pwdInput"/><br/>
    이름 : <input type="text" class ="nameInput"/><br/>
    휴대폰번호 : <input type="text" class ="phoneInput" onkeyup="phoneCheck()"/><br/>
    <div class ="phoneCheck"></div><!-- 휴대폰번호 중복검사 -->
    <button type="button" onclick="signUp()">회원가입</button><br/>
    <a href="/member/login.jsp">로그인</a>
    <a href="/member/find.jsp">id/pw 찾기</a>

<script src="/js/signup.js"></script>
<jsp:include page = "/footer.jsp"></jsp:include>
