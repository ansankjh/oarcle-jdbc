<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- View -->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>memberList</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
		<script>
			$(document).ready(function() {
				$('#rowPerPage').change(function() {
					$('#pageForm').submit();
					alert('change');
				})
			});
		</script>
	</head>
	<body>
		<h1>멤버 이름 목록(페이징)</h1>
		<form action="${pageContext.request.contextPath}/MemberListController" method="get">
			<select name="rowPerPage" id="rowPerPage">
				<c:if test="${rowPerPage == 10}">
					<option value="10" selected="selected">10</option>
					<option value="20">20</option>
					<option value="30">30</option>
				</c:if>
				<c:if test="${rowPerPage == 20}">
					<option value="10">10</option>
					<option value="20" selected="selected">20</option>
					<option value="30">30</option>
				</c:if>
				<c:if test="${rowPerPage == 30}">
					<option value="10">10</option>
					<option value="20">20</option>
					<option value="30" selected="selected">30</option>
				</c:if>
			</select>
		</form>
		<table border="1">
			<tr>
				<th>memberName</th>
				<th>createdate</th>
			</tr>
			<c:forEach var="m" items="${memberList}">
				<tr>
					<td>${m.memberName}</td>
					<td>${m.createdate}</td>
				</tr>
			</c:forEach>
		</table>
		<a href="${pageContext.request.contextPath}/MemberListController?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}">이전</a>
		<a href="${pageContext.request.contextPath}/MemberListController?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}">다음</a>
		<a href="${pageContext.request.contextPath}/HomeController">뒤로</a>
	</body>
</html>