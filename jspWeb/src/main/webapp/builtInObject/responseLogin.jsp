<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>내장객체 - response</title>
</head>
<body>
	<%
		String id = request.getParameter("user_id");
		String pwd = request.getParameter("user_pw");
		if(id.equalsIgnoreCase("ezen")&&pwd.equalsIgnoreCase("0111")) {
			response.sendRedirect("responseWelcome.jsp");
		} else {
			request.getRequestDispatcher("responseMain.jsp?loginError=1").forward(request, response);
		}
	%>
</body>
</html>