<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
	String[] rgba = {"Red","Green","Blue", "Black"};
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>JSTL - 향상된 for문</title>
</head>
<body>
	<h4>향상된 for문 형태</h4>
	<c:forEach var="c" items="<%=rgba %>">
		<span style="color: ${c};">${c}</span>
	</c:forEach>
	
	<h4>varstatus 속성 확인하기</h4>
	<table border="1">
		<c:forEach items="<%=rgba %>" var="c" varStatus="loop">
			<tr>
				<td>count : ${loop.count }</td>
				<td>index : ${loop.index }</td>
				<td>current : ${loop.current }</td>
				<td>first : ${loop.first }</td>
				<td>last : ${loop.last }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>