<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>JSTL - choose/when/otherwise</title>
</head>
<body>
	<!-- 변수선언 -->
	<c:set var="number" value="101"/>
	
	<h4>choose 태그로 홀짝 판단</h4>
	<c:choose>
		<c:when test="${ number mod 2 eq 0 }">
			${number }는 짝수입니다.
		</c:when>
		<c:otherwise>
			${number }는 홀수입니다.
		</c:otherwise>
	</c:choose>
	
	<h4>국영수 점수를 입력하면 평균을 내어 학점 출력</h4>
	<form action="#">
		국어 : <input type="text" name="kor"><br>
		영어 : <input type="text" name="eng"><br>
		수학 : <input type="text" name="math"><br>
		<input type="submit" value="학점 구하기">
	</form>
	
	<c:if test="${ not(empty param.kor or empty param.eng or empty param.math) }">
		<!-- 평균계산 -->
		<c:set var="avg" value="${ (param.kor+param.eng+param.math)/3 }"/>
		평균 점수는 ${avg }으로
		<!-- 학점출력 -->
		<c:choose>
			<c:when test="${avg >= 90 }">A 학점</c:when>
			<c:when test="${avg >= 80 }">B 학점</c:when>
			<c:when test="${avg ge 70 }">C 학점</c:when>
			<c:when test="${avg ge 60 }">D 학점</c:when>
			<c:otherwise>F 학점</c:otherwise>
		</c:choose>
		입니다.
	</c:if>
</body>
</html>