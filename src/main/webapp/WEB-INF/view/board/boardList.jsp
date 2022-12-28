<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>boardList</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
		<script>
			$(document).ready(function() {
				$('#rowPerPage').change(function() {
					$('#pageForm').submit();
					alert('change');
				});
			});
		</script>
	</head>
	<body>
		<h1>BOARD LIST</h1>
		
		${msg}
		<c:if test="${loginMember != null}">
			<a href="${pageContext.request.contextPath}/board/addBoard">글입력</a>
		</c:if>
		<form action="${pageContext.request.contextPath}/board/boardList" method="get" id="pageForm">
			<div>
				<label for="word">내용 검색</label>
				<input type="text" name="word" id="word" value=""> <!-- value에 word를 입력하여 a태그로 보낸 word값을 출력한다(다음페이지에도 word값 자동출력) -->
				<button type="submit">검색</button>
			</div>
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
				<th>boardNo</th>
				<th>boardTitle</th>
				<th>memberId</th>
				<th>createdate</th>
			</tr>
			<c:forEach var="b" items="${boardList}">
				<tr>
					<td>${b.boardNo}</td>
					<td><a href="${pageContext.request.contextPath}/board/boardOne?boardNo=${b.boardNo}">${b.boardTitle}</a></td>
					<td>${b.memberId}</td>
					<td>${b.createdate}</td>
				</tr>
			</c:forEach>
		</table>
		<div>
			<c:if test="${word == ''}">
				<a href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=${currentPage-1}">이전</a>
			</c:if>
			<c:if test="${word != ''}">
				<a href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=${currentPage-1}&word=${word}">이전</a>
			</c:if>
			${currentPage}
			<c:if test="${word == ''}">
				<a href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=${currentPage+1}">다음</a>
			</c:if>
			<c:if test="${word != ''}">
				<a href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=${currentPage+1}&word=${word}">다음</a>
			</c:if>
			<a href="${pageContext.request.contextPath}/home">뒤로</a>
			
		</div>
	</body>
</html>