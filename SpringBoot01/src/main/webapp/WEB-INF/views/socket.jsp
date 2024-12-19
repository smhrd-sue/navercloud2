<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
	<style type="text/css">
		.me{
			color: green;
		}
		.other{
			color: blue;
		}
	
	</style>


</head>
<body>
	
	<h1>WebSocket 사용해보기</h1>

	email : <input type="text" id="email"> <br>
	text : <input type="text" id="text">
	<button id="btn">전송</button>
	
	<hr>
	
	<div id="result"></div>
	
	
	<script src="assets/js/chat.js"></script>
</body>
</html>