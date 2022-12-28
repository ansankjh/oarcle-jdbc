<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>removeMemberForm</title>
	</head>
	<body>
		<h1>회원탈퇴</h1>
		<form action="${pageContext.request.contextPath}/member/removeMember" method="post">
			<table border="1">
				<tr>
					<td>ID</td>
					<td>
						<input type="text" name="memberId" value="${loginMember.memberId}">
					</td>
				</tr>
				<tr>
					<td>PW</td>
					<td>
						<input type="password" name="memberPw"> 
					</td>
				</tr>
			</table>
			<div>
				<button type="submit">회원탈퇴</button>
			</div>
		</form>
		<a href="${pageContext.request.contextPath}/member/memberOne">취소</a>
	</body>
</html>