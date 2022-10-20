<%@page import="java.text.SimpleDateFormat"%>	<%-- 지시어 --%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--include file=""--%>
<%--taglib uri="" --%>
<%-- 스크립트 요소 (선언부) --%>
<%! 
	String str1 = "JSP";
	String str2 = "안녕하세요..";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>뷰 담당하는 <%= str1 %></h2> <%-- 스크립트 요소 (표현식) --%>
	<%-- 스크립트 요소 (스크립틀릿) --%>
	<% 
		Date today = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String todayStr = dateFormat.format(today);
		out.println("오늘 날짜 : " + todayStr);
	%>
</body>
</html>