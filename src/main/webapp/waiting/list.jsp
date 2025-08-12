<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- jsp 기능 제공 받는 코드 -->
<jsp:include page = "header.jsp"></jsp:include>

    <h3>식당대기조회</h3>
    <div>
        <table>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>휴대폰번호</th>
                    <th>인원수</th>
                </tr>
            </thead>
            <tbody id="waitingTbody">
                
            </tbody>
        </table>
    </div>
<script src="list.js"></script>
<jsp:include page = "footer.jsp"></jsp:include>
