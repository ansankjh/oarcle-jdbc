<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>home</title>
	</head>
	<body>
		<h1>${loginMember.memberName}님 환영합니다.</h1>
		<a href="${pageContext.request.contextPath}/BoardListController">boardList</a>
		<a href="${pageContext.request.contextPath}/MemberListController">memberList</a>
		<a href="${pageContext.request.contextPath}/ModifyMemberFormController">회원정보 수정</a>
		<a href="${pageContext.request.contextPath}/LogoutController">logout</a>
	</body>
</html>