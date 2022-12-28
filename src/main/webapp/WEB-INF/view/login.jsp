<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>loginForm</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
		<script>
			$(document).ready(function() {
				// ID칸에 커서
				$('#id').focus();
				
				// 아이디 빈칸
				$('#id').blur(function() {
					if($('#id').val() == '') {
						alert('아이디를 입력해주세요.');
					} else {
						$('#pw').focus();
					}
				}); 
				
				// 비밀번호 빈칸
				$('#pw').blur(function() {
					if($('#pw').val() == '') {
						alert('비밀번호를 입력해주세요.')
					} 
				});
				
				$('#')
			});
		</script>
	</head>
	<body>
		<h1>로그인</h1>
		${msg}
		<form action="${pageContext.request.contextPath}//member/login" method="post">
			<table border="1">
				<tr>
					<td>ID</td>
					<td>
						<input type="text" name="memberId" id="id">
					</td>
				</tr>
				<tr>
					<td>PW</td>
					<td>
						<input type="password" name="memberPw" id="pw">
					</td>
				</tr>
			</table>
			<div>
				<button type="submit">로그인</button>
			</div>
		</form>
		<div>
			<a href="${pageContext.request.contextPath}/member/addMember">회원가입</a>	
			<a href="${pageContext.request.contextPath}/home">뒤로</a>
		</div>
	</body>
</html>