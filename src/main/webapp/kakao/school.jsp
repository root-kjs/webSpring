<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- jsp 기능 제공 받는 코드 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>인천 연수구 학교</title>
    <link href="/css/kakao/school.css" rel="stylesheet"/>
</head>
<body>
    <jsp:include page = "/header.jsp"></jsp:include>

    <h3>인천 연수구 학교</h3>
    <div id ="container">

        <div id="map" ></div>
        <div id="sidebar" ></div>

    </div>
    <!-- // 김진숙 : 카카오 JavaScript 키 b47cc59ad7a7b09cf4b9ca38e849df19 -->
     <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b47cc59ad7a7b09cf4b9ca38e849df19&libraries=clusterer"></script>
    <script src="/js/kakao/school.js"></script>
</html>