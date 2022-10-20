<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("scopeValue", "값-페이지 영역");
	request.setAttribute("scopeValue", "값-리퀘스트 영역");
	session.setAttribute("scopeValue", "값-세션 영역");
	application.setAttribute("scopeValue", "값-애플리케이션 영역");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>EL - 내장객체</title>
</head>
<body>
	<h2>가지 영역에 저장된 속성 읽기(EL 내장객체 사용)</h2>
	<ul>
		<li>페이지 영역 : ${pageScope.scopeValue}</li>
		<li>리퀘스트 영역 : ${requestScope.scopeValue}</li>
		<li>세션 영역 : ${sessionScope.scopeValue}</li>
		<li>애플리케이션 영역 : ${applicationScope.scopeValue}</li>
	</ul>
	
	<h3>영역 지정없이 속성 읽기</h3>
		<ul>
			<li>${scopeValue }</li>
		</ul>
	
	<jsp:forward page="implicitForward.jsp"></jsp:forward>
</body>
</html>