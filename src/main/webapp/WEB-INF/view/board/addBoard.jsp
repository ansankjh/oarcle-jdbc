<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>addBoardForm</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
		<script>
			$(document).ready(function() {
				// 게시판 입력 페이지 들어오면 boardTitle에서 커서 시작
				$('#title').focus();
				// 빈칸이면 입력하라고 메시지 뜨게하기
				$('#title').blur(function() {
					if($('#title').val().length < 1) {
						$('#titleMsg').text('제목을 입력해주세요.');
						$('#title').focus();
					} else {
						$('#titleMsg').text('');
						$('#content').focus();
					}
				});
				
				$('#content').blur(function() {
					if($('#content').val().length < 1) {
						$('#contentMsg').text('내용을 입력해주세요.');
						$('#content').focus();
					} else {
						$('#contentMsg').text('');
					}
				});
			});
		</script>
	</head>
	<body>
		<h1>글입력</h1>
		<form action="${pageContext.request.contextPath}/board/addBoard" method="post">
			<table border="1">
				<tr>
					<td>boardTitle</td>
					<td>
						<input type="text" name="boardTitle" id="title">
						<span id="titleMsg"></span>				
					</td>
				</tr>
				<tr>
					<td>boardContent</td>
					<td>
						<textarea cols="50" rows="5" name="boardContent" id="content"></textarea>
						<span id="contentMsg"></span>
					</td>
				</tr>
				<tr>
					<td>memberId</td>
					<td>
						<input type="text" name="memberId" value="${loginMember.memberId}">
					</td>
				</tr>
			</table>
			<div>
				<button type="submit">입력</button>
			</div>	
		</form>
	</body>
</html>