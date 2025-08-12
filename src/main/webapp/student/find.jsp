<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- jsp 기능 제공 받는 코드 -->
<jsp:include page = "header.jsp"></jsp:include>

    <h3>성적조회</h3>
    <div>
        <table>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>이름</th>
                    <th>국어</th>
                    <th>수학</th>
                </tr>
            </thead>
            <tbody id="studentTbody">
                
            </tbody>
        </table>
    </div>
<script src="find.js"></script>
<jsp:include page = "footer.jsp"></jsp:include>
