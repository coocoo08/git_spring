<%@page import="kr.co.ezenac.Person"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>JSTL - set</title>
</head>
<body>
	<!-- 변수 선언 -->
	<c:set var="directVar" value="100"/>
	<c:set var="elVar" value="${directVar mod 5 }"/>
	<c:set var="beansVar" value="<%= new Date() %>"/>
	<c:set var="betweenVar">
		변수값 설정
	</c:set>
	
	<h4>EL 이용해 변수 출력</h4>
	<ul>
		<li>directVar: ${pageScope.directVar }</li>
		<li>elVar: ${elVar }</li>
		<li>beansVar: ${beansVar }</li>
		<li>betweenVar: ${betweenVar }</li>
	</ul>
	
	<h4>자바빈즈 생성 - 생성자 사용</h4>
	<c:set var="personVar" value='<%= new Person("이순신", 40) %>' scope="request"/>
	<ul>
		<li>이름 : ${requestScope.personVar.name }</li>
		<li>나이 : ${personVar.age }</li>
	</ul>
	
	<h4>자바빈즈 생성2 - target, property</h4>
	<c:set var="personVar2" value="<%= new Person() %>" scope="request"/>
	<c:set target="${personVar2 }" property="name" value="이도"/>
	<c:set target="${personVar2 }" property="age" value="30"/>
		<ul>
		<li>이름 : ${requestScope.personVar2.name }</li>
		<li>나이 : ${personVar2.age }</li>
	</ul>
</body>
</html>