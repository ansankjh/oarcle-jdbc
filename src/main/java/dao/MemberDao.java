package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Member;

public class MemberDao {
	// MemberListController.java
	public ArrayList<Member> selectMemberList(Connection conn, int beginRow, int endRow) throws Exception {
		// 객체 초기화
		ArrayList<Member> list = null;
		// 쿼리문 작성
		String sql = "SELECT member_name memberName, createdate"
				+ " FROM (SELECT rownum rnum, member_name, createdate"
				+ "		FROM (SELECT member_name, createdate FROM member ORDER BY member_name asc))"
				+ " WHERE rnum between ? and ?";
		// 쿼리 객체 생성
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리 ?값 지정
		stmt.setInt(1, beginRow);
		stmt.setInt(2, endRow);
		// 쿼리 실행
		ResultSet rs = stmt.executeQuery();
		list = new ArrayList<Member>();
		while(rs.next()) {
			Member m = new Member();
			m.setMemberName(rs.getString("memberName"));
			m.setCreatedate(rs.getString("createdate"));
			list.add(m);
		}
		stmt.close();
		rs.close();
		return list;
	}
	
	// LoginActionController.java
	public Member loginMember(Connection conn, Member member) throws Exception {
		// 객체 초기화
		Member resultMember = null;
		// 쿼리문 작성
		String sql = "SELECT member_id memberId, member_pw memberPw, member_name memberName FROM member WHERE member_id = ? AND member_pw = ?";
		// 쿼리 객체 생성
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리문 ?값 지정
		stmt.setString(1, member.getMemberId());
		stmt.setString(2, member.getMemberPw());
		// 쿼리 실행
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			resultMember = new Member();
			resultMember.setMemberId(rs.getString("memberId"));
			resultMember.setMemberPw(rs.getString("memberPw"));
			resultMember.setMemberName(rs.getString("memberName"));
		}
		stmt.close();
		rs.close();
		return resultMember;
	}
	
	// AddMemberActionController.java
	public int insertMember(Connection conn, Member member) throws Exception {
		// 객체 초기화
		int row = 0;
		// 쿼리문 작성
		String sql = "INSERT INTO member (member_id, member_pw, member_name, updatedate, createdate) values(?, ?, ?, sysdate, sysdate)";
		// 쿼리 객체 생성
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리문 ?값 지정
		stmt.setString(1, member.getMemberId());
		stmt.setString(2, member.getMemberPw());
		stmt.setString(3, member.getMemberName());
		// 쿼리 실행
		row = stmt.executeUpdate();
		
		stmt.close();
		return row;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
