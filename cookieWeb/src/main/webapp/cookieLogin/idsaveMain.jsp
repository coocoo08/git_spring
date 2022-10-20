<%@page import="kr.co.ezenac.utils.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String loginId = CookieManager.readCookie(request, "loginId");
	String cookieCheck = "";
	if(!loginId.equals("")){
		cookieCheck = "checked";
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Cookie - 아이디 저장하기</title>
</head>
<body>
	<h2>로그인 페이지</h2>
	<form action="idsaveProcess.jsp" method="post">
		아이디 : <input type="text" name="user_id" value="<%=loginId%>">
			   <input type="checkbox" name="save_ck" value="Y" <%=cookieCheck%>> 아이디 저장하기<br>
		패스워드 : <input type="password" name="user_pw"><br>
		<input type="submit" value="로그인하기">
	</form>
</body>
</html>