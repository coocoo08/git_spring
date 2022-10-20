<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>otherPage</title>
</head>
<body>
	<ul>
		<li>저장된 값 : ${requestVar }</li>	<!-- 리다이렉트는 request 영역은 공유되지 않음 -->
		<li>매개변수1 : ${param.user_param1 }</li>
		<li>매개변수2 : ${param.user_param2 }</li>
	</ul>
</body>
</html>