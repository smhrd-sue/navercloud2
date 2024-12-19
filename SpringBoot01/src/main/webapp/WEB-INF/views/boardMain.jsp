<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Forty by HTML5 UP</title>
<meta charset="utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="assets/css/main.css" />
<link rel="stylesheet" href="assets/css/board.css" />
<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->

</head>
<body>
	<div id="board">
	<h1>게시판 메인 페이지</h1>
		<table id="list">
			<thead>
				<tr>
					<td colspan="3">
						<input id="text" type="text">
					</td>
					<td>
						<button id="searchBtn">검색하기</button>
					</td>
				</tr>
			
			
				<tr>
					<td>번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>시간</td>
				</tr>
			</thead>
			<tbody>
				<%--Ex10.게시글 목록을 출력해봅시다. --%>
				<%--예시) --%>
				<%--
					begin : 시작하는 숫자
					end : 끝나는 숫자
					step : 증감
					>> for(int i = begin; i <= end; i+=step)
					
					var : 어떤 이름으로 저장할지
					items : 배열
					>> for( i : items ){
						pageContext.setAttribute( "var" , i );
					}
				--%>
				<c:forEach var="board" items="${list}" >
					<tr>
						<td>${board.idx}</td>
						<td><a href="view?idx=${board.idx}">${board.title}</a></td>
						<td>${board.writer}</td>
						<td>${board.indate }</td>
						<td> <a href="delete/${board.idx }" > X </a> </td>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>

		<a href="writerBoard"><button id="writer">작성하러가기</button></a>
	</div>
	
	<div>
	  <canvas id="myChart"></canvas>
	</div>


	<!-- Scripts -->
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="assets/js/main.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
	<script src="assets/js/search.js"></script>
	
	
	
	
</body>
</html>