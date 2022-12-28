<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>home</title>
	</head>
	<body>
		<c:if test="${loginMember == null}">
			<h1>Guest님 어서오세요</h1>
			<a href="${pageContext.request.contextPath}//member/addMember">회원가입</a>
			<a href="${pageContext.request.contextPath}//member/login">로그인</a>
		</c:if>
		<c:if test="${loginMember != null}">
			<h1>${loginMember.memberName}님 환영합니다.</h1>
			<a href="${pageContext.request.contextPath}/board/boardList">boardList</a>
			<a href="${pageContext.request.contextPath}/member/memberList">memberList</a>
			<a href="${pageContext.request.contextPath}/member/memberOne">회원정보</a>
			<a href="${pageContext.request.contextPath}/member/logout">logout</a>
		</c:if>
		<!-- 회원가입, 로그인, 리스트 로그인 전후로 리스트 출력&비출력 -->
		
	</body>
</html>