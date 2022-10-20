<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 창</title>
<script type="text/javascript">
	function fnValidate() {

		let frmlogin = document.frmlogin
		let userID = frmlogin.userID.value
		let userName = frmlogin.userName.value
		
		if ((userID.length == 0 || userID == "") || (userName.length == 0 || userName == "")){
			alert("아이디와 이름은 필수입니다.")
		} else {
			frmlogin.method = "post"
			frmlogin.action = "${contextPath}/req/login.do"
			frmlogin.submit()
		}
	}
</script>
</head>
<body>
	<form name="frmlogin" action="${contextPath}/req/login.do" method="post">
		<table width = "400">
			<tr>
				<td>아이디<input type="text" name="userID" size="10"></td>
				<td>이름<input type="text" name="userName" size="10"></td>
			</tr>
			<tr>
				<td>
				<input type="button" value="로그인" onclick="fnValidate()">
				<input type="reset" value="다시입력">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>