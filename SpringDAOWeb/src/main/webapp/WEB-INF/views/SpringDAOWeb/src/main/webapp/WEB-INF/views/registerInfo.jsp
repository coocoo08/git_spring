<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
</head>
<body>
	<h1>id : ${param.id }</h1>
	<h1>pwd : ${param.pwd }</h1>
	<h1>name : ${param.name }</h1>
	<h1>email :  ${param.email }</h1>
	<h1>birth :  ${param.birth }</h1>
	<h1>sns :  ${paramValues.sns[0] }</h1>
	<h1>sns :  ${paramValues.sns[1] }</h1>
	<h1>sns :  ${paramValues.sns[2] }</h1>
</body>
</html>