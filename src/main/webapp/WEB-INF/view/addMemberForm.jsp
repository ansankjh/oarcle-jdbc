<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>addMemberForm</title>
	</head>
	<body>
		<h1>회원가입</h1>
		<form action="${pageContext.request.contextPath}/AddMemberActionController" method="post">
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
				<tr>
					<td>PwCk</td>
					<td>
						<input type="password" name="memberPwCk">
					</td>
				</tr>
				<tr>
					<td>NAME</td>
					<td>
						<input type="text" name="memberName">
					</td>
				</tr>
			</table>
			<div>
				<button type="submit">회원가입</button>
			</div>
		</form>
	</body>
</html>