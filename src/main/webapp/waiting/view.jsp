<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- jsp 기능 제공 받는 코드 -->
<jsp:include page = "header.jsp"></jsp:include>

    <h3>식당대기 상세조회</h3>
    <div>
        휴대폰번호 : <span class="wphoneBox"></span><br/>
        대기인원수 : <span class="wcountBox"></span><br/>

        <button onclick="updateView()" type="button">수정</button>
        <button onclick="deleteWaiting()" type="button">삭제</button>

    </div>
<script src="viewWaiting.js"></script>
<jsp:include page = "footer.jsp"></jsp:include>
