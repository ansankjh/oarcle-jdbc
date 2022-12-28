<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>memberOne</title>
	</head>
	<body>
		<h1>회원정보</h1>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>CREATEDATE</th>
			</tr>
			<tr>
				<td>${member.memberId}</td>
				<td>${member.memberName}</td>
				<td>${member.createdate}</td>
			</tr>
		</table>
		<a href="${pageContext.request.contextPath}/member/modifyMember">회원정보수정</a>
		<a href="${pageContext.request.contextPath}/member/modifyMemberPw">비밀번호수정</a>
		<a href="${pageContext.request.contextPath}/member/removeMember">회원탈퇴</a>
		<a href="${pageContext.request.contextPath}/home">뒤로</a>
	</body>
</html>