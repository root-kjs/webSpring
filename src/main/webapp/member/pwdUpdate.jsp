<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- jsp 기능 제공 받는 코드 -->
<jsp:include page = "/header.jsp"></jsp:include>

    <h3>비밀번호 수정</h3>
    (기존)비밀번호 : <input type="password" class ="oldPwdInput"/><br/>
    (변경)비밀번호 : <input type="password" class ="newPwdInput"/><br/>
    <button type="button" onclick="updatePwd()">수정</button><br/>

<script src="/js/updatePwd.js"></script>
<jsp:include page = "/footer.jsp"></jsp:include>
