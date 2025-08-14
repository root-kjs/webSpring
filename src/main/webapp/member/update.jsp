<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- jsp 기능 제공 받는 코드 -->
<jsp:include page = "/header.jsp"></jsp:include>

    <h3>내 정보수정</h3>
    회원번호 : <span class="mno">???</span><br/>
    아이디 : <span class="mid">???</span><br/>
    이름 : <input type="text" class ="mnameInput"/><br/>
    휴대폰번호 : <input type="text" class ="mphoneInput"/><br/>
    가입일 : <span class="mdate">???</span><br/>
    <button type="button" onclick="updateUser()">수정</button><br/>

<script src="/js/update.js"></script>
<jsp:include page = "/footer.jsp"></jsp:include>
