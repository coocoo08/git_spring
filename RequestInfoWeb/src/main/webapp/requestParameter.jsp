<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>내장 객체 - request</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String gender = request.getParameter("gender");
	String[] favo = request.getParameterValues("favo");
	String favoStr = "";
	if (favo != null) {
		for (int i = 0; i < favo.length; i++) {
			favoStr += favo[i] + " ";
		}
	}
	String intro = request.getParameter("intro").replace("\r\n", "<br>");
%>
	<ul>
		<li>아이디 : <%= id %></li>
		<li>성별 : <%= gender%></li>
		<li>관심사 : <%= favoStr %></li>
		<li>자기소개 : <%= intro%></li>
	</ul>
</body>
</html>