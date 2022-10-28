<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="loginout" value="${sessionScope.id==null ? 'Login' : 'Logout'}"/>
<c:set var="loginoutlink" value="${sessionScope.id==null ? '/login/login' : '/login/logout' }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>게시판 리스트</title>
	<link rel="stylesheet" href="<c:url value='/resources/css/menu.css'/>">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
</head>
<body>
	<div id="menu">
		<ul>
			<li id="logo">ezen</li>
			<li><a href="<c:url value="/"/>">Home</a></li>
			<li><a href="<c:url value="/board/list"/>">Board</a></li>
			<li><a href="<c:url value="${loginoutlink}"/>">${loginout}</a></li>
			<li><a href="<c:url value="/register/add"/>">SignUp</a></li>
			<li><a href=""><i class="fas fa-search small"></i></a></li>
		</ul>
	</div>
	<div style="text-align: center;">
		<h2>당신의 건강 대한 보다 큰 그림</h2>
		<h2>'하이라이트' 항목은 머신 러닝을 활용</h2>
		<h2>혈당, 심박수, 호흡수와 같은 변화 추세를 정확하게</h2>
		<h2>모션 센서에 기록된 정보, 걸음 수, 이동 거리, 서트파티 운동 기록을 활용</h2>
		<h2>당신의 주요 건강 정보를 한데 안전하게 모아 정리</h2>
	</div>
</body>
</html>