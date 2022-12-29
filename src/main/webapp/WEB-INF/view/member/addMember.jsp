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
		<title>addMember</title>
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
				// ID칸에 커서
				$('#id').focus();
				
				// 아이디 빈칸
				$('#id').blur(function() {
					if($('#id').val() == '') {
						$('#idMsg').text('아이디를 입력해주세요.');
						$('#id').foucs();
					} else {
						$('#idMsg').text('');
						$('#pw').focus();
					}
				}); 
				
				// 비밀번호 빈칸
				$('#pw').blur(function() {
					if($('#pw').val() == '' && $('#id').val() != '') {
						$('#pwMsg').text('비밀번호를 입력해주세요.');
					} else {
						$('#pwMsg').text('');
						$('#pwCk').focus();
					}
				});
				
				// 비밀번호확인 빈칸
				$('#pwCk').blur(function() {
					if($('#pwCk').val() == '' && $('#pw').val() != '') {
						$('#pwCkMsg').text('비밀번호를 입력해주세요.');
					} else {
						$('#pwCkMsg').text('');
					}
				});
				
				// 닉네임 빈칸
				$('#name').blur(function() {
					if($('#name').val() == '') {
						$('#nameMsg').text('닉네임을 입력해주세요.');
						$('#name').focus();
					} else {
						$('#nameMsg').text('');
					}
					
				});
				
				// 페이지 나갈때 확인버튼
				$("#exit").click(function() {
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
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="${pageContext.request.contextPath}/home" id='exit'>취소</a></li>
                    </ul>
                </div>
            </div>
        </nav>
		<div class="container">
			<!-- Contact Section Heading-->
			<h1 class="page-section-heading text-center text-uppercase text-secondary mb-0" style="margin-top:150px;">회원가입</h1>
			<!-- Icon Divider-->
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon"><i class="fas fa-star"></i></div>
				<div class="divider-custom-line"></div>
			</div>
			<!-- Contact Section Form-->
			<div class="row justify-content-center">
				<div class="col-lg-8 col-xl-7">
					<form id="contactForm" data-sb-form-api-token="API_TOKEN" action="${pageContext.request.contextPath}/member/addMember" method="post">
					<!-- Id css -->
					<div class="form-floating mb-3">
						<input class="form-control" id="id" type="text" name="memberId" placeholder="아이디를 입력해주세요." data-sb-validations="required" />
						<span class="msg" id="idMsg"></span>
						<label for="id">ID</label>
					</div>
					<!-- 비밀번호css -->
					<div class="form-floating mb-3">
						<input class="form-control" id="pw" type="password" name="memberPw" placeholder="name@example.com" data-sb-validations="required,email" />
						<span class="msg" id="pwMsg"></span>
						<label for="pw">PassWord</label>
					</div>
					<!-- 비밀번호확인css -->
					<div class="form-floating mb-3">
						<input class="form-control" id="pwCk" type="password" name="memberPwCk" placeholder="name@example.com" data-sb-validations="required,email" />
						<span class="msg" id="pwCkMsg"></span>
						<label for="pwCk">PassWordCheck</label>
					</div>
					<!-- 닉네임css -->
					<div class="form-floating mb-3">
						<input class="form-control" id="name" type="text" name="memberName" placeholder="name@example.com" data-sb-validations="required,email" />
						<span class="msg" id="nameMsg"></span>
						<label for="name">Name</label>
					</div>
					<span class="msg">${msg}</span>
					<!-- Submit Button-->
					<div align="center">
						<button class="btn btn-primary btn-xl" id="submitButton" type="submit">회원가입</button>
					</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>