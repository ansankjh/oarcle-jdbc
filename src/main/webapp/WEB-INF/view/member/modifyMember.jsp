<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>modifyMemberForm</title>
	</head>
	<body>
		<h1>회원정보 수정</h1>
		<form action="${pageContext.request.contextPath}/member/modifyMember" method="post">
			<table border="1">
				<tr>
					<td>ID</td>
					<td>
						<input type="text" name="memberId" value="${loginMember.memberId}" readonly="readonly">
					</td>
				</tr>
				<tr>
					<td>NAME</td>
					<td>
						<input type="text" name="memberName" value="${loginMember.memberName}">
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
				<button type="submit">정보수정</button>
			</div>
		</form>
	</body>
</html>