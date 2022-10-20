<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="isErrorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>page 지시어 - errorPage, isErrorPage 속성</title>
</head>
<body>
	<%
		int myAge2 = Integer.parseInt(request.getParameter("age")) + 10; //에러 발생
		out.print(" 추가된 년수가 " + myAge2 + "입니다.");	//실행되지 않음	
		try{
			int myAge = Integer.parseInt(request.getParameter("age")) + 10; //에러 발생
			out.print(" 추가된 년수가 " + myAge + "입니다.");	//실행되지 않음	
		} catch(Exception e){
			out.println("예외 발생 : 매개변수 age가 null입니다.");
		}
	%>
</body>
</html>