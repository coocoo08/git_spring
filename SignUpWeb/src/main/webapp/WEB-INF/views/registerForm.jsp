<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
<style type="text/css">
* {
	box-sizing: border-box;
}

.title {
	font-size: 50px;
	margin: 40px 0 30px 0;
}

form {
	width: 400px;
	height: 600px;
	display: flex;
	flex-direction: column;
	align-items: center;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	border: 1px solid rgb(89, 117, 196);
	border-radius: 10px;
}

.msg {
	height: 30px;
	text-align: center;
	font-size: 16px;
	color: red;
	margin-bottom: 20px;
}

label {
	width: 300px;
	height: 30px;
	margin-top: 4px;
}

.input-field {
	width: 300px;
	height: 40px;
	border: 1px solid rgb(89, 117, 196);
	border-radius: 5px;
	padding: 0 10px;
	margin-bottom: 10px;
}

.sns-chk {
	margin-top: 5px;
}

button {
	background-color: rgb(89, 117, 196);
	color: white;
	width: 300px;
	height: 50px;
	font-size: 17px;
	border: none;
	boder-radius: 5px;
	margin: 20px 0 30px 0;
}
</style>
<title>회원가입</title>
</head>
<body>
	<form action="<c:url value="/register/save2/"/>" method="post"
		onsubmit="return formCheck(this)">
		<div class="title">Register</div>
		<div id="msg" class="msg"></div>

		<label>아이디</label> <input class="input-field" type="text" name="id"
			placeholder="8~12자리의 영대소문자, 숫자 조합" autofocus> <label>비밀번호</label>
		<input class="input-field" type="password" name="pwd"
			placeholder="8~12자리의 영대소문자, 숫자 조합"> <label>이름</label> <input
			class="input-field" type="text" name="name" placeholder="이순신">

		<label>이메일</label> <input class="input-field" type="text" name="email"
			placeholder="sclee@gmail.com"> <label>생일</label> <input
			class="input-field" type="text" name="birth" placeholder="2000/01/01">

		<div class="sns-chk">
			<label><input type="checkbox" name="sns" value="facebook">페이스북</label>
			<label><input type="checkbox" name="sns" value="kakaotalk">카카오톡</label>
			<label><input type="checkbox" name="sns" value="instagram">인스타그램</label>
		</div>
		<button>회원가입</button>
	</form>

	<script type="text/javascript">
		function formCheck(frm) {
			let msg = ''

			if (frm.id.value.length < 8) {
				setMessage('id의 길이는 8자리 이상이어야 합니다.', frm.id)
				return false;
			}

			if (frm.pwd.value.length < 8) {
				setMessage('pwd의 길이는 8자리 이상이어야 합니다.', frm.pwd)
				return false;
			}

			return true;
		}

		function setMessage(msg, element) {
			document.getElementById("msg").innerHTML = `<i class="fa fa-exclamation-circle">${'${msg}'}</i>`;
			if (element) {
				element.select(); //값을 잘못 입력되었을 때 그 요소를 선택되게하는 것임
			}
		}
	</script>
</body>
</html>