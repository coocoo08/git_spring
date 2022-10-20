<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>EL - 폼값 처리</title>
</head>
<body>
	<h2>폼값 전송하기</h2>
	<form action="formResult.jsp" name="frm" method="post">
		이름 : <input type="text" name="name" autofocus><br>
		성별 : <input type="radio" name="gender" value="Man">남자
			 <input type="radio" name="gender" value="Woman">여자<br>
		학력 : 
			<select name="grade">
				<option value="ele">초딩</option>
				<option value="mid">중딩</option>
				<option value="heig">고딩</option>
				<option value="uni">대딩</option>
			</select><br>
		관심 사항 :
			<input type="checkbox" name="inter" value="pol">정치
			<input type="checkbox" name="inter" value="eco">경제
			<input type="checkbox" name="inter" value="ent">연예
			<input type="checkbox" name="inter" value="spo">운동<br>
		<input type="submit" value="전송하기">
	</form>
</body>
</html>