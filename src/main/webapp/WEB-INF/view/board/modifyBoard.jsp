<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>modifyBoardForm</title>
	</head>
	<body>
		<h1>MODIFY BOARD FORM</h1>
		<form action="${pageContext.request.contextPath}/board/modifyBoard" method="post">
			<table border="1">
				<tr>
					<th>boardNo</th>
					<th>boardTitle</th>
					<th>boardContent</th>
					<th>memberId</th>
				</tr>
				<tr>
					<td>
						<input type="text" name="boardNo" value="${board.boardNo}" readonly="readonly">
					</td>					
					<td>
						<input type="text" name="boardTitle" value="${board.boardTitle}">
					</td>
					<td>
						<textarea cols="50" rows="5" name="boardContent">${board.boardContent}</textarea>
					</td>
					<td>${loginMember.memberId}</td>
				</tr>
			</table>
			<div>
				<button type="submit">수정</button>
			</div>
		</form>
	</body>
</html>