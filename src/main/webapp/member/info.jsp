<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- jsp 기능 제공 받는 코드 -->
<jsp:include page = "/header.jsp"></jsp:include>

    <h3>마이페이지 </h3>
    회원번호 : <span class="mno">???</span><br/>
    아이디 : <span class="mid">???</span><br/>
    이름 : <span class="mname">???</span><br/>
    휴대폰번호 : <span class="mphone">???</span><br/>
    가입일 : <span class="mdate">???</span><br/>
    <a href="/member/update.jsp">정보수정</a><br/>
    <a href="/member/pwdUpdate.jsp">비밀번호 수정</button><br/>
     <button type="button" onclick="deleteUser()">회원탈퇴</button><br/>


<script src="/js/info.js"></script>
<jsp:include page = "/footer.jsp"></jsp:include>