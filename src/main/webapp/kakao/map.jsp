<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- jsp 기능 제공 받는 코드 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>카카오지도</title>
    <link href="/css/header.css" rel="stylesheet"/>
</head>
<body>
    <jsp:include page = "/header.jsp"></jsp:include>

    <h3>카카오지도</h3>
    <div id ="container">

        <div id="map" style="width:500px;height:400px;"></div>

    </div>



    <!-- 카카오 지도 API JS  -->
    <!-- 김현수 강사님 APP KEY :  1ac4a57d8a5927d34020a891fcdbbcbd -->
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1ac4a57d8a5927d34020a891fcdbbcbd"></script>
    <!-- 개발자 정의 js 나중에 넣기 -->
    <script src="/js/kakao/map.js"></script>
</html>