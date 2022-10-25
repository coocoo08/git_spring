<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>JSTL - catch</title>
</head>
<body>
	<h4>자바코드에서의 예외</h4>
	<% int num1 = 100; %>
	
	<c:catch var="eMessage">
		<% int result = num1/0; %>
	</c:catch>
	예외 내용 : ${eMessage}
	
	<h4>EL에서의 예외</h4>
	<c:set var="num2" value="200"/>
	
	<c:catch var="eMessage2">
		${"일" + num2 }
	</c:catch>
	예외 내용 : ${eMessage2}
</body>
</html>