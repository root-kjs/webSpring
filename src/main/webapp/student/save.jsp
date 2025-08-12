<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- jsp 기능 제공 받는 코드 -->
<jsp:include page = "header.jsp"></jsp:include>

    <h3>성적등록</h3>
    <div>
        이름 : <input type="text" class="sname" value="" /><br/>
        국어점수 : <input type="text" class="skor" value="" /><br/>
        수학점수 : <input type="text" class="smath" value="" /><br/>
        <button onclick="save()" type="button">등록</button>

    </div>
<script src="save.js"></script>
<jsp:include page = "footer.jsp"></jsp:include>
