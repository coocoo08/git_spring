<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>포함된 파일</title>
</head>
<body>
	<%
		LocalDate today = LocalDate.now(); //오늘 날짜
		LocalDate tomorrow = today.plusDays(1); //내일 날짜
	%>
</body>
</html>