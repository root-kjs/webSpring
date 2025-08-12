<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- jsp 기능 제공 받는 코드 -->
<jsp:include page = "header.jsp"></jsp:include>

    <h3>식당대기 수정</h3>
    <div>
        휴대폰번호 : <input type="text" class="wphoneInput" value="" /><br/>
        대기인원수 : <input type="number" class="wcountInput" value="" /><br/>
        <button onclick="updateWaiting();" type="button">수정</button>

    </div>
<script src="updateWaiting.js"></script>
<jsp:include page = "footer.jsp"></jsp:include>
