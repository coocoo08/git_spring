<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>쿠키를 이용한 팝업</title>
	<style type="text/css">
		div#popup {
			position: absolute;
			top: 100px; left: 50px;
			color: yellow;
			width: 300px; height: 100px;
			background-color: gray;
		}
		div#popup > div {
			position: relative;
			background-color: white;
			top: 0px;
			border: 1px solid gray;
			padding: 10px;
			color: black;
		}
		#popimg {
			width: 300px;
		}
	</style>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$('#closeBtn').click(function() {	/* 닫기 버튼 누르면 팝업창 숨김 처리 */
				$('#popup').hide();
				/* id가 "notopenToday"이면서 "체크된" 체크박스의 값을 읽어옴 */
				let chkVal = $('input:checkbox[id=notopenToday]:checked').val()  //체크여부
				if(chkVal == 1){
					$.ajax({						// 비동기로 요청을 보냄 (다양한 설정값)
						url : "./popupCookie.jsp",		// popupCookie.jsp 파일에
						type : "get",				// HTTP GET 방식으로
						data : {notopenToday : chkVal},	//notopenToday=chkVal 데이터를
						dataType : "text",			// 응답 데이터의 타입은 일반 텍스트이며
						success : function(resData) {	//요청 성공시
							if (resData != '') {		//응답데이터가 있다면
								alert(chkVal);
								location.reload();		//페이지 새로고침
							}
						}
					});					
				}
			});
		});
	</script>
	
</head>
<body>
	<%
		String popupMode = "on";		//레이어 팝업창 띄울지 여부
		Cookie[] cookies = request.getCookies();	// 쿠키를 읽어 popupMode 값 설정
		if(cookies != null){
			for(Cookie c : cookies){
				String cookieName = c.getName();
				String cookieValue = c.getValue();
				
				if(cookieName.equals("PopupClose")){	//popupClose쿠키가 존재하면
					popupMode = cookieValue;			//popupMode의 값 업데이트
				}
			}
		}
		
		for(int i =0; i<=10; i++){
			out.println("현재 팝업창은 " + popupMode + " 상태입니다.<br>");
		}
		
		if(popupMode.equals("on")){
	%>
	<div id="popup">
		<h2 align="center">앱 다운받고 사과시계울트라 받아가자!</h2>
		<img id="popimg" alt="사진" src="../resources/img/AppleUltra.jpg">
		<div align="right">
			<form action="#" name="popFrm">
				<input type="checkbox" id="notopenToday" value="1">하루 동안 열지 않음
				<input type="button" id="closeBtn" value="닫기">
			</form>
		</div>
	</div>
	<%
		}
	%>
</body>
</html>