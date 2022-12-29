<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
		<meta name="description" content="" />
		<meta name="author" content="" />
		<title>memberOne</title>
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
				// 페이지 나갈때 확인버튼
				$("#logout").click(function() {
					var result = confirm("이 페이지에서 나가시겠습니까?");
					if(result == true) {
						
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
						<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="${pageContext.request.contextPath}/member/modifyMember">회원정보수정</a></li>
						<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="${pageContext.request.contextPath}/member/modifyMemberPw">비밀번호수정</a></li>
						<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="${pageContext.request.contextPath}/member/removeMember">회원탈퇴</a></li>
						<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="${pageContext.request.contextPath}/member/logout" id='logout'>로그아웃</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<h1 class="page-section-heading text-center text-uppercase text-secondary mb-0" style="margin-top:250px;">회원정보</h1>
		<table class="table table-bordered" style="width:1000px;" align="center">
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
	</body>
</html>