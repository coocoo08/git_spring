<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>page 영역</title>
</head>
<body>
	<h4>Include 페이지</h4>
	<%
		/* 속성읽기 */
		int pInteger2 = (Integer)(pageContext.getAttribute("ezenInter"));
	%>
	<ul>
		<li>Integer 객체 : <%=pInteger2 %></li>
	</ul>
</body>
</html>