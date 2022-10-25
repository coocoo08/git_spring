<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>JSTL - url</title>
</head>
<body>
	<h4>url 태그로 링크 걸기</h4>
	<c:url value="otherUrlPage.jsp" var="url">
		<c:param name="userParam1" value="ezen"/>
		<c:param name="userParam2">ITAcademy</c:param>
	</c:url>
	<a href="${url}">otherUrlPage.jsp 바로가기</a>
</body>
</html>