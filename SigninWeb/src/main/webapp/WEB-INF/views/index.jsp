<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>		<!-- 이 페이지에서는 세션을 새로 시작하지 않음 -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="<c:url value='/resources/css/menu.css'/>">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
	<title>ezen</title>
</head>
<body>
	<div id="menu">
		<ul>
			<li id="logo">ezen</li>
			<li><a href="<c:url value="/"/>">Home</a></li>
			<li><a href="<c:url value="/board/list"/>">Board</a></li>
			<li><a href="<c:url value="/login/login"/>">login</a></li>
			<li><a href="<c:url value="/register/add"/>">SignUp</a></li>
		</ul>
	</div>
	<div style="text-align: center;">
		<h1>세상을 바꾸는 HOME!</h1>
		<h1>다음 세대에게 더 나은 세상을!</h1>
		<h1>지구를 사랑하는 마음!</h1>
	</div>
</body>
</html>