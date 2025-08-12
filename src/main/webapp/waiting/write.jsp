<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- jsp 기능 제공 받는 코드 -->
<jsp:include page = "header.jsp"></jsp:include>

    <h3>식당대기등록</h3>
    <div>
        휴대폰번호 : <input type="text" class="wphone" value="" /><br/>
        대기인원수 : <input type="number" class="wcount" value="" /><br/>
        <button onclick="add();" type="button">등록</button>

    </div>
<script src="add.js"></script>
<jsp:include page = "footer.jsp"></jsp:include>
