<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<style>
			.msg {
				color : red;
			}
		</style>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
		<meta name="description" content="" />
		<meta name="author" content="" />
		<title>addForm</title>
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
				// 게시판 입력 페이지 들어오면 boardTitle에서 커서 시작
				$('#title').focus();
				// 빈칸이면 입력하라고 메시지 뜨게하기
				$('#title').blur(function() {
					if($('#title').val().length < 1) {
						$('#titleMsg').text('제목을 입력해주세요.');
						$('#title').focus();
					} else {
						$('#titleMsg').text('');
						$('#content').focus();
					}
				});
				
				$('#content').blur(function() {
					if($('#content').val().length < 1) {
						$('#contentMsg').text('내용을 입력해주세요.');
						$('#content').focus();
					} else {
						$('#contentMsg').text('');
					}
				});
			});
		</script>
	</head>
	<body id="page-top">
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
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="${pageContext.request.contextPath}/board/boardList">글 입력 취소</a></li>
                    </ul>
                </div>
            </div>
        </nav>
		 <section class="page-section" id="contact">
		    <div class="container">
		        <!-- Contact Section Heading-->
		        <h1 class="page-section-heading text-center text-uppercase text-secondary mb-0" style="margin-top:80px;">게시판 글입력</h1>
		        <!-- Icon Divider-->
		        <div class="divider-custom">
		            <div class="divider-custom-line"></div>
		            <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
		            <div class="divider-custom-line"></div>
		        </div>
		        <!-- Contact Section Form-->
		        <div class="row justify-content-center">
		            <div class="col-lg-8 col-xl-7">
		                <form id="contactForm" data-sb-form-api-token="API_TOKEN" action="${pageContext.request.contextPath}/board/addBoard" method="post">
		                    <!-- 제목 -->
		                    <div class="form-floating mb-3">
		                        <input class="form-control" id="title" type="text" name="boardTitle" placeholder="Enter your name..." data-sb-validations="required" />
		                        <span class="msg" id="titleMsg"></span>
		                        <label for="title">제목</label>
		                    </div>
		                    <!-- 내용 -->
		                    <div class="form-floating mb-3">
		                    	<textarea class="form-control" name="boardContent" id="content" style="height: 10rem" placeholder="name@example.com" data-sb-validations="required,email"></textarea>
		                        <span class="msg" id="contentMsg"></span>
		                        <label for="content">내용</label>
		                    </div>
		                    <!-- 작성자 -->
		                    <div class="form-floating mb-3">
		                        <input class="form-control" type="text" id="id" name="memberId" value="${loginMember.memberId}" />
		                        <label for="id">작성자</label>
		                    </div>
		                    <!-- Submit Button-->
		                    <div align="center">
		                    	<button class="btn btn-primary btn-xl" id="submitButton" type="submit">등록</button>
		                    </div>
		                </form>
		            </div>
		        </div>
		    </div>
		</section>
	</body>
</html>