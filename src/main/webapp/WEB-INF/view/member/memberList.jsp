<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- View -->
<!DOCTYPE html>
<html>
	<head>
		<style>
			div {
				align : center;
				text-align : center;
			}
			
			.po0 {
				position : relative;
				top : -10px;
				left : 1415px;
			}
			
			.po1 {
				position : relative;
				top : -30px;
				left : 1350px;
			}
			
			.po2 {
				position : relative;
				top : -30px;
				left : 1350px;
			}
		</style>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
		<meta name="description" content="" />
		<meta name="author" content="" />
		<title>memberList</title>
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
				$('#rowPerPage').change(function() {
					$('#pageForm').submit();
					alert('change');
				})
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
						<li class="nav-item mx-0 mx-lg-1"><span class="nav-link py-3 px-0 px-lg-3 rounded">${loginMember.memberId}???</span></li>
						<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="${pageContext.request.contextPath}/board/boardList">?????????</a></li>
						<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="${pageContext.request.contextPath}/member/memberOne">??? ??????</a></li>
						<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="${pageContext.request.contextPath}/member/logout" id='logout'>????????????</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<h1 class="page-section-heading text-center text-uppercase text-secondary mb-0" style="margin-top:150px;">
			<a href="${pageContext.request.contextPath}/member/memberList" style="text-decoration-line : none;">?????? ??????</a>
		</h1>
		<form action="${pageContext.request.contextPath}/member/memberList" method="get" id="pageForm">
			<select class="po0" name="rowPerPage" id="rowPerPage">
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
		<div>
			<table class="table table-bordered" style="width:1000px;" align="center">
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
		</div>
		<div>
			<a href="${pageContext.request.contextPath}/member/memberList?rowPerPage=${rowPerPage}&currentPage=${currentPage-1}" style="text-decoration-line : none;"><-??????</a>
			${currentPage}
			<a href="${pageContext.request.contextPath}/member/memberList?rowPerPage=${rowPerPage}&currentPage=${currentPage+1}" style="text-decoration-line : none;">??????-></a>
		</div>
	</body>
</html>