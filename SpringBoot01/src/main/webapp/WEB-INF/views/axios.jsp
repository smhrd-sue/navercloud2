<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

</head>
<body>
	
	<h1>AXIOS 활용하기</h1>

	<button id="btn01" >요청 보내기</button>
	
	<hr>
	
	<input type="text" id="inp01">
	
	<button id="btn02" >GET 방식</button>
	
	
	<hr>
	
	title : <input type="text" name="title"> <br>
	writer : <input type="text" name="writer"> <br>
	<button id="btn03">POST</button>
	<div id="result"></div> 
	
	
	
	<script src="assets/js/axios01.js" ></script>
	


</body>
</html>