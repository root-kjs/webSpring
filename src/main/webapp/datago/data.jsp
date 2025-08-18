<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- jsp 기능 제공 받는 코드 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>공공데이터</title>
    <link href="/css/header.css" rel="stylesheet"/>
</head>
<body>
    <jsp:include page = "/header.jsp"></jsp:include>

    <h3>사업자 상태 조회</h3>
    <input type="text" class="b_no" value="" placeholder="사업자 번호"/>
    <button onclick="dataAPI2()" type="button">사업자상태조회</button>
    <h3>인천 부평구 주유소 현황</h3>
   <table>
    <thead>
        <tr>
            <th>No</th>
            <th>상호</th>
            <th>업종</th>
            <th>전화번호</th>
            <th>주소</th>
        </tr>
    </thead>
    <tbody id ="dataTbody">

    </tbody>
   </table>

 <script src="/js/datago/data.js"></script>
</html>