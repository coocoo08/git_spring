<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>내장 객체 - request</title>
</head>
<body>
	<h2>응답 헤더 정보 출력하기</h2>
	<%
		Enumeration<String> headers = request.getHeaderNames();
		while(headers.hasMoreElements()){
			String headerName = headers.nextElement();
			String headerValue = request.getHeader(headerName);
			out.print("헤더명 : " + headerName + ", 헤더값 : " + headerValue + "<br>");
		}
	%>
</body>
</html>