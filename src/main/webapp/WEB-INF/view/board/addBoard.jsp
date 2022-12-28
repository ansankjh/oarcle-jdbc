<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>addBoardForm</title>
	</head>
	<body>
		<h1>글입력</h1>
		<form action="${pageContext.request.contextPath}/board/addBoard" method="post">
			<table border="1">
				<tr>
					<th>boardTitle</th>
					<th>boardContent</th>
					<th>memberId</th>
				</tr>
				<tr>
					<td>
						<input type="text" name="boardTitle">
					</td>
					<td>
						<textarea cols="50" rows="5" name="boardContent"></textarea>
					</td>
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