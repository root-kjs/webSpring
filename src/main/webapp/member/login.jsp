<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- jsp 기능 제공 받는 코드 -->
<jsp:include page = "/header.jsp"></jsp:include>

    <h3>로그인</h3>
    아이디 : <input type="text" class ="idInput"/><br/>
    비밀번호 : <input type="password" class ="pwdInput"/><br/>
    <button type="button" onclick="login()">로그인</button><br/>
    <a href="/member/signup.jsp">회원가입</a>
    <a href="/member/find.jsp">id/pw 찾기</a>

<script src="/js/login.js"></script>
<jsp:include page = "/footer.jsp"></jsp:include>