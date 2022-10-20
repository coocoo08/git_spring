<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>page 지시어 - errorPage</title>
</head>
<body>
	<h2>서비스 중 일시적인 오류가 발생했습니다.</h2>
	<img alt="에러이미지" src="resource/img/error-page.gif" width="600px">
	<p>
		오류명 : <%= exception.getClass().getName() %><br>
		오류 메시지 : <%= exception.getMessage() %>
	</p>
</body>
</html>