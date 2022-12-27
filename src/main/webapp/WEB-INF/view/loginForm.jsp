<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>loginForm</title>
	</head>
	<body>
		<h1>로그인</h1>
		${msg}
		<form action="${pageContext.request.contextPath}/LoginActionController" method="post">
			<table border="1">
				<tr>
					<td>ID</td>
					<td>
						<input type="text" name="memberId">
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
				<button type="submit">로그인</button>
			</div>
		</form>
		<div>
			<a href="${pageContext.request.contextPath}/AddMemberFormController">회원가입</a>	
		</div>
	</body>
</html>