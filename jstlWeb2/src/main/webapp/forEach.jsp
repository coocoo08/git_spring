<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>JSTL - forEach</title>
</head>
<body>
	<h4>일반 for문 형태의 forEach 태그</h4>
	<c:forEach begin="1" end="3" step="1" var="i">
		<p>반복 ${i }입니다.</p>
	</c:forEach>
	
	<h4>varStatus 속성 확인하기</h4>
	<table border="1">
		<!-- 상태를 알려줄 변수명을 "loop"로 지정함 -->
		<c:forEach begin="3" end="5" var="i" varStatus="loop">
			<tr>
				<td>count : ${loop.count }</td>
				<td>index : ${loop.index }</td>
				<td>current : ${loop.current }</td>
				<td>first : ${loop.first }</td>
				<td>last : ${loop.last }</td>
			</tr>
		</c:forEach>
	</table>	
		<h4>1에서 100까지 정수 중 홀수의 합</h4>

		<c:forEach begin="1" end="100" var="i">
			<c:choose>
				<c:when test="${i mod 2 == 1 }">
					<c:set var="result" value="${result+i }"/>
				</c:when>
			</c:choose>
		</c:forEach>
		1에서 100까지의 정수 중 홀수의 합은? ${result}
		
</body>
</html>