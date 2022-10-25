<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>JSTL - fmt</title>
</head>
<body>
	<h4>숫자 포맷 설정</h4>
	<c:set var="number1" value="12345"/>
	콤마 O : <fmt:formatNumber value="${number1}"/><br>
	콤마 X : <fmt:formatNumber value="${number1}" groupingUsed="false"/><br>
	<fmt:formatNumber value="${number1}" type="currency" var="printNum1"/>
	통화기호 : ${printNum1}<br>
	
	<fmt:formatNumber value="0.03" type="percent" var="printNum2"/>
	통화기호 : ${printNum2}<br>
</body>
</html>