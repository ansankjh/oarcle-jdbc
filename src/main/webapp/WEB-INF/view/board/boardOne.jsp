<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>boardOne</title>
	</head>
	<body>
		<h1>BOARD ONE</h1>
		<table border="1">
			<tr>
				<th>boardTitle</th>
				<th>boardContent</th>
			</tr>
			<tr>
				<td>${board.boardTitle}</td>
				<td>${board.boardContent}</td>
			</tr>
		</table>
		<!-- 나중에 로그인이 안되어있으면 이 버튼들은 안뜨게끔? -->
		<c:if test="${loginMember != null}">
			<a href="${pageContext.request.contextPath}/board/modifyBoard?boardNo=${board.boardNo}">수정</a>
			<a href="${pageContext.request.contextPath}/board/removeBoard?boardNo=${board.boardNo}">삭제</a>
		</c:if>
		<a href="${pageContext.request.contextPath}/board/boardList">뒤로</a>
	</body>
</html>