<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<title>boardList</title>
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
				});
				
				// 로그아웃 클릭시 로그아웃 할건지 묻는창 띄우기 
				$("#logout").click(function() {
					var result = confirm("로그아웃 하시겠습니까?");
					if(result == true) {
						alert('로그아웃');
					} else {
						alert('로그아웃취소');
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
						<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="${pageContext.request.contextPath}/member/memberList">회원게시판</a></li>
						<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="${pageContext.request.contextPath}/member/memberOne">내 정보</a></li>
						<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="${pageContext.request.contextPath}/member/logout" id='logout'>로그아웃</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<h1 class="page-section-heading text-center text-uppercase text-secondary mb-0" style="margin-top:150px;">
			<a href="${pageContext.request.contextPath}/board/boardList" style="text-decoration-line : none;">게시글 목록</a>
		</h1>
		<br>
		<form action="${pageContext.request.contextPath}/board/boardList" method="get" id="pageForm">
			<div>
				<label for="word">내용 검색</label>
				<input type="text" name="word" id="word" value="${word}"> <!-- value에 word를 입력하여 a태그로 보낸 word값을 출력한다(다음페이지에도 word값 자동출력) -->
				<button type="submit">검색 : </button>
			</div>
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
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일자</th>
				</tr>
				<c:forEach var="b" items="${boardList}">
					<tr>
						<td style="width:100px;">${b.boardNo}</td>
						<td style="width:500px;"><a href="${pageContext.request.contextPath}/board/boardOne?boardNo=${b.boardNo}" style="text-decoration-line : none;">${b.boardTitle}</a></td>
						<td style="width:200px;">${b.memberId}</td>
						<td style="width:200px;">${b.createdate}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div>
			<!-- 페이지 표시 -->
			
			<!-- 페이징 -->
			<!-- 처음 페이지로 돌아가기 버튼이 있으려면 현재 페이지가 2페이지일때부터 -->
			<c:if test="${currentPage > 1 && word == ''}">
				<a href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=1" style="text-decoration-line : none;">처음</a>
			</c:if>
			<c:if test="${currentPage > 1 && word != ''}">
				<a href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=1&word=${word}" style="text-decoration-line : none;">처음</a>
			</c:if>
			<!-- currentPage가 1보다 작으면 이전버튼은 없어야한다  -->
			<c:if test="${currentPage > 1 && word == ''}">
				<a href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=${currentPage-1}" style="text-decoration-line : none;"><-이전</a>
			</c:if>
			<c:if test="${currentPage > 1 && word != ''}">
				<a href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=${currentPage-1}&word=${word}" style="text-decoration-line : none;"><-이전</a>
			</c:if>
			${currentPage}
			<!-- currentPage가 lastPage보다 작으면 -->
			<c:if test="${currentPage < lastPage && word == ''}">
				<a href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=${currentPage+1}" style="text-decoration-line : none;">다음-></a>
			</c:if>
			<c:if test="${currentPage < lastPage && word != ''}">
				<a href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=${currentPage+1}&word=${word}" style="text-decoration-line : none;">다음-></a>
			</c:if>
			<!-- lastPage -->
			<c:if test="${currentPage != lastPage && word == ''}">
				<a href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=${lastPage}" style="text-decoration-line : none;">마지막</a>
			</c:if>
			<c:if test="${currentPage != lastPage && word != ''}">
				<a href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=${lastPage}&word=${word}" style="text-decoration-line : none;">마지막</a>
			</c:if>
		</div>
		<a class="po1 btn btn-info" href="${pageContext.request.contextPath}/board/addBoard" style="text-decoration-line : none;">게시글 입력</a>
	</body>
</html>