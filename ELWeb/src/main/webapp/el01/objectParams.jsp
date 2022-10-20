<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.co.ezenac.Person" %>
<%
	request.setAttribute("personObj", new Person("이순신", 35));
	request.setAttribute("stringObj", "이것은 문자열임");
	request.setAttribute("integerObj", new Integer(100));
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>EL - 객체 매개변수</title>
</head>
<body>
	<%-- 액션태그를 이용해 포워드함. 이때 파라미터값 10, 20도 함께 포워드 된 페이지로 전달 --%>
	<jsp:forward page="objectResult.jsp">
		<jsp:param value="10" name="firstNum"/>
		<jsp:param value="20" name="secondNum"/>
	</jsp:forward>
</body>
</html>