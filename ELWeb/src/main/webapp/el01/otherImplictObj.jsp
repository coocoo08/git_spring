<%@ page import= "kr.co.ezenac.util.CookieManager" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CookieManager.makeCookie(response, "ELCookie", "10월의추위", 10); /* 10초 */
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>EL - 그 외 내장 객체</title>
</head>
<body>
	<h3>쿠키값 읽기</h3>
	<li>ELCookie 값 : ${cookie.ELCookie.value }</li>
	
	<h3>HTTP 헤더 읽기</h3>
	<ul>
		<li>host : ${header.host}</li>
		<li>user-agent : ${header['user-agent']}</li>
		<li>cookie : ${header.cookie}</li>
	</ul>
	
	<h3>컨텍스트 초기화 매개변수 읽기</h3>
		<li>Ezen : ${initParam.Ezen}</li>
	<h3>컨텍스트 루트 경로 읽기</h3>
	<li>${pageContext.request.contextPath}</li>
</body>
</html>