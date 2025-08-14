<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- jsp 기능 제공 받는 코드 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>회원관련 프로그램</title>
    <link href="/css/header.css" rel="stylesheet"/>
</head>
<body>
    <header>
        <ul>
            <li><a href="/index.jsp"><img src="/img/logo.jpg"></a> </li>
            <li><a href="/index.jsp">메뉴1</a></li>
            <li><a href="/index.jsp">메뉴2</a></li>
            <li><a href="/index.jsp">메뉴3</a></li>
        </ul>
        <ul class="user_menu">
            <!-- 로그인 전 -->
            <li><a href="/member/login.jsp">로그인</a></li>
            <li><a href="/member/signup.jsp">회원가입</a></li>
            <!-- 로그인 후 -->
            <li><span>000님 100 point</span></li>
            <li><a href="/member/info.jsp">내정보</a></li>
            <li><a href="#" onclick="logout()">로그아웃</a></li> 
        </ul>
    </header>
   

 <script src="/js/header.js"></script>

