<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>JSTL - redirect</title>
</head>
<body>
	<c:set var="requestVar" value="EzenIt" scope="request"/>
	<c:redirect url="/inc/otherPage.jsp">
		<c:param name="user_param1" value="학원"/>
		<c:param name="user_param2" value="이젠IT"/>
	</c:redirect>
</body>
</html>