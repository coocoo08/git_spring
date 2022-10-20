<%@page import="java.util.HashMap"%>
<%@page import="kr.co.ezenac.Person"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Map<String, Person> maps = new HashMap<>();
	maps.put("actor", new Person("현빈", 30));
	maps.put("actor2", new Person("유해진", 40));
	application.setAttribute("maps", maps);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>application 영역</title>
</head>
<body>
	<h2>application 영역의 공유</h2>
	application 영역에 속성이 저장되었습니다.
</body>
</html>