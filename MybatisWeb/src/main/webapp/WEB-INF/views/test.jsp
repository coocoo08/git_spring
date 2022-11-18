<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
  	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.js"></script>
	<title>comment list</title>
</head>
<body>
	<h2>CommentTest</h2>
	comment : <input type="text" name="comment">
	<button id="sendBtn" type="button">SEND</button>
	<button id="modBtn" type="button">수정하기</button>
	<div id="commentList"></div>
	
	<script type="text/javascript">
		let bno = 301
		
		let showList = function(bno) {
			$.ajax({
				type : 'GET' // 요청 메서드
				, url : '/heart/comments?bno=' + bno // 요청 URI
				, success : function(result) { // 서버로부터 응답이 도착하면 호출될 함수 
						$("#commentList").html(toHtml(result)) // result는 서버가 전송한 데이터 
				}
				, error : function() { alert("error") } // 에러가 발생할 때 호출될 함수 
			})
		}
		
		
		$(document).ready(function() {

			showList(bno)
			
			$("#modBtn").click(function() {
				//showList(bno)
				let cno = $(this).attr("data-cno")
				let comment = $('input[name=comment]').val();
				
				if (comment.trim() == '') {
					alert("댓글을 입력해 주세요.")
					$('input[name=comment]').focus()
					return
				}
				
				$.ajax({
					type : 'PATCH',			// 요청 메서드
					url : '/heart/comments/' + cno,		// 요청 URI
					headers : { "content-type" : "application/json"},	//요청 헤더
					data : JSON.stringify({cno:cno, comment:comment}),		//서버로 전송할 데이터. stringify()로 직렬화 필요.
					success : function(result) {		//서버로부터 응답이 도착하면 호출될 함수
						alert(result)
						showList(bno)
					},
					error : function() {alert("error")}		//에러가 발생했을 때 호출될 함수
				})
			})
			
			$("#sendBtn").click(function() {
				//showList(bno)
				let comment = $('input[name=comment]').val();
				
				if (comment.trim() == '') {
					alert("댓글을 입력해 주세요.")
					$('input[name=comment]').focus()
					return
				}
				$.ajax({
					type : 'post',			// 요청 메서드
					url : '/heart/comments?bno='+bno,		// 요청 URI
					headers : { "content-type" : "application/json"},	//요청 헤더
					data : JSON.stringify({bno:bno, comment:comment}),		//서버로 전송할 데이터. stringify()로 직렬화 필요.
					success : function(result) {		//서버로부터 응답이 도착하면 호출될 함수
						alert(result)
						showList(bno)
					},
					error : function() {alert("error")}		//에러가 발생했을 때 호출될 함수
				})
			})
			// $(".delBtn").click(function() { // [send]버튼을 클릭하고 나서 [삭제]버튼이 보이므로 이벤트 활성화가 안됨.
			$("#commentList").on("click", ".delBtn", function() { // commentList 안에 있는 delBtn 버튼에다가 클릭이벤트를 등록해야함.
				// alert("삭제 버튼 클릭됨")
				let cno = $(this).parent().attr("data-cno") // <li>태그는 <button>의 부모임.
				let bno = $(this).parent().attr("data-bno") // attr 중 사용자 정의 attr를 선택함.
				
				$.ajax({
					type : 'DELETE' // 요청 메서드 
					, url :	'/heart/comments/'+cno+'?bno='+bno // 요청 URI
					, success : function(result) { // 서버로부터 응답이 도착하면 호출될 함수 
							alert(result)
							showList(bno)
					}
					, error : function() { alert("error") } // 에러가 발생했을 때 호출될 함수 
				})
			})
			
			$("#commentList").on("click", ".modBtn", function() { // commentList 안에 있는 delBtn 버튼에다가 클릭이벤트를 등록해야함.
				//alert("댓글수정 버튼 클릭됨")
				let cno = $(this).parent().attr("data-cno") // <li>태그는 <button>의 부모임.
				//클릭된 수정버튼의 부모(li)의 span 태그의 텍스트만 가져옴.
				let comment = $("span.comment", $(this).parent()).text()
				//1. comment의 내용을 input에 출력해주기
				$("input[name=comment]").val(comment)
				//2. cno 전달하기
				$("#modBtn").attr("data-cno", cno)
				
			})
		})
		
		let toHtml = function(comments) {
			let tmp = "<ul>"
			
			comments.forEach(function(comment) {
				tmp += '<li data-cno='+comment.cno
				tmp += ' data-bno='+comment.bno
				tmp += ' data-pcno='+comment.pcno+'>'
				tmp += ' commenter=<span class="commenter">'+comment.commenter+'</span>'
				tmp += ' comment=<span class="comment">'+comment.comment+'</span>'
				tmp += ' <button class="delBtn">삭제</button>'
				tmp += ' <button class="modBtn">수정</button>'
				tmp += '</li>'
			})
			
			return tmp += "</ul>"
		}
	</script>
</body>
</html>