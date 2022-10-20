<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<c:forEach begin="2" end="9" var="dan">
			<tr>
				<c:forEach begin="1" end="9" var="su">
					<td>
						${dan } * ${su } = ${dan * su }
					</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>