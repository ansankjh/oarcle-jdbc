<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%
	// Controller
	int currentPage = 1;
	if(request.getParameter("currentPage") != null) {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	
	int rowPerPage = 10;
	
	// 2) Model

	// 오라클 드라이버 로딩
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "gdj58", "java1234");
	// System.out.println("오라클 접속 성공");
	/*
		select t2.rnum rnum, t2.name name
		from
			(select rownum rnum, t.member_name name
			from 
				(select member_name
				from member
				order by member_name asc) t) t2
		where rnum between ? and ?;
	*/
	// 쿼리문 작성
	String sql = "SELECT t2.rnum rnum, t2.name name FROM (SELECT rownum rnum, t.member_name name FROM (SELECT member_name FROM member ORDER BY member_name asc) t) t2 WHERE rnum between ? and ?";
	// 쿼리 객체 생성
	PreparedStatement stmt = conn.prepareStatement(sql);
	/*
		page	beginRow	endRow
		1		1			10
		2		11			20
		3		21			30
	*/
	// 페이징
	int beginRow = (currentPage - 1) * rowPerPage + 1;
	int endRow = beginRow + rowPerPage - 1;
	// 쿼리문 ?값 지정
	stmt.setInt(1, beginRow);
	stmt.setInt(2, endRow);
	// 쿼리 실행
	ResultSet rs = stmt.executeQuery();
	
%>

<!-- View -->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>memberList</title>
	</head>
	<body>
		<h1>멤버 이름 목록(페이징)</h1>
		<table border="1">
			<tr>
				<th>번호</th>
				<th>이름</th>
			</tr>
			<%
				while(rs.next()) {
			%>
					<tr>
						<td><%=rs.getInt("rnum")%></td>
						<td><%=rs.getString("name")%></td>
					</tr>
			<%
				}
			%>
		</table>
		<a href="<%=request.getContextPath()%>/memberList.jsp?currentPage=<%=currentPage-1%>">이전</a>
		<a href="<%=request.getContextPath()%>/memberList.jsp?currentPage=<%=currentPage+1%>">다음</a>
	</body>
</html>