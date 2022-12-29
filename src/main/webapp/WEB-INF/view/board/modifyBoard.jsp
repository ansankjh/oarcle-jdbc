<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<style>
			.po0 {
				position : relative;
				top : 40px;
			}
			
			.po1 {
				position : relative;
				top : 50px;
			}
		</style>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
		<meta name="description" content="" />
		<meta name="author" content="" />
		<title>modifyBoard</title>
		<!-- Favicon-->
		<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
		<!-- Font Awesome icons (free version)-->
		<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
		<!-- Google fonts-->
		<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
		<link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
		<!-- Core theme CSS (includes Bootstrap)-->
		<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
		<script>
			$(document).ready(function() {
				$('#back').click(function() {
					var result = confirm('이 페이지에서 나가시겠습니까?');
					if(result) {
						
					} else {
						return false;
					}
				});
			});
		</script>
	</head>
	<body>
		<!-- Navigation-->
		<nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
			<div class="container">
				<a class="navbar-brand" href="${pageContext.request.contextPath}/home">HOME</a>
				<button class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
					Menu
					<i class="fas fa-bars"></i>
				</button>
				<div class="collapse navbar-collapse" id="navbarResponsive">
					<ul class="navbar-nav ms-auto">
						<li class="nav-item mx-0 mx-lg-1"><span class="nav-link py-3 px-0 px-lg-3 rounded">${loginMember.memberId}님</span></li>
						<!-- 작성자와 로그인멤버가 다르면 안뜨게끔 -->
						<c:if test="${loginMember.memberId == board.memberId}">
							<li class="nav-item mx-0 mx-lg-1">
								<a class="nav-link py-3 px-0 px-lg-3 rounded" href="${pageContext.request.contextPath}/board/modifyBoard?boardNo=${board.boardNo}">수정</a>
							</li>
							<li class="nav-item mx-0 mx-lg-1">
								<a class="nav-link py-3 px-0 px-lg-3 rounded" href="${pageContext.request.contextPath}/board/removeBoard?boardNo=${board.boardNo}" id='delete'>삭제</a>
							</li>
						</c:if>
						<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="${pageContext.request.contextPath}/board/boardOne?boardNo=${board.boardNo}" id='back'>취소</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<h1 class="page-section-heading text-center text-uppercase text-secondary mb-0" style="margin-top:150px;">${board.boardTitle}</h1>
		<form action="${pageContext.request.contextPath}/board/modifyBoard" method="post">
			<table class="table table-bordered po0" style="width:700px; text-align:center; vertical-align:middle;" align="center">
				<tr>
					<td>제목</td>					
					<td>
						<input type="text" name="boardTitle" value="${board.boardTitle}" style="width : 600px; border : none;">
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<textarea cols="70" rows="5" name="boardContent" style="border:none;">${board.boardContent}</textarea>
					</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>${loginMember.memberId}</td>
				</tr>
			</table>
			<div class="po1" align="center">
				<button type="submit">수정</button>
			</div>
		</form>
	</body>
</html>