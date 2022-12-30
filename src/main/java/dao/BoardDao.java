package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Board;

public class BoardDao {
	
	// boardList 총 행의수 BoardListController.java
	public int selectCount(Connection conn, String word) throws Exception {
		// 객체 초기화
		int row = 0;
		// 쿼리문 초기화
		String sql = null;
		// 객체 초기화
		PreparedStatement stmt = null;
		// 쿼리문&쿼리객체 생성
		if(word == null) {
			// 검색어 없을때
			// 쿼리문 작성
			sql = "SELECT COUNT(*) cnt FROM board";
			// 객체 생성
			stmt = conn.prepareStatement(sql);
		} else if(word != null) {
			// 검색어가 있을때
			// 쿼리문 작성
			sql = "SELECT COUNT(*) cnt FROM board WHERE board_content like ?";
			// 객체 생성
			stmt = conn.prepareStatement(sql);
			// 쿼리문 ?값 지정
			stmt.setString(1, "%"+word+"%");
		}
		// 쿼리 실행
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			row = rs.getInt("cnt");
		}
		
		stmt.close();
		rs.close();
		return row;
	}
	// 나중에 검색 추가
	// SELECT board_no boardNo, board_title boardTitle FROM board WHERE board_content LIKE ? ORDER BY board_no ASC LIMIT ?, ?";
	public ArrayList<Board> selectBoardListByPage(Connection conn, String word, int beginRow, int endRow) throws Exception {
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = null;
		PreparedStatement stmt = null;
		// 쿼리문 작성
		if(word == null) {
			sql = "SELECT board_no boardNo, board_title boardTitle, member_id memberId, createdate"
					+ " FROM (SELECT rownum rnum, board_no, board_title, member_id, createdate" // rnum을 고정시키기 위해서(where절을 쓰기위해서)
					+ " 	FROM (SELECT board_no, board_title, member_id, createdate" // 정렬해서 rnum을 붙이기위해서
					+ "				FROM board ORDER BY to_number(board_no) ASC))"
					+ " WHERE rnum BETWEEN ? AND ?"; // WHERE rnum이 >=? AND  <=?
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, beginRow);
			stmt.setInt(2, endRow);
			word = "";
		} else if(word != null) {
			sql = "SELECT board_no boardNo, board_title boardTitle, member_id memberId, createdate"
					+ " FROM (SELECT rownum rnum, board_no, board_title, member_id, createdate" // rnum을 고정시키기 위해서(where절을 쓰기위해서)
					+ " 	FROM (SELECT board_no, board_title, member_id, createdate" // 정렬해서 rnum을 붙이기위해서
					+ "				FROM board WHERE board_content like ? ORDER BY to_number(board_no) asc))"
					+ " WHERE rnum BETWEEN ? AND ?"; // WHERE rnum이 >=? AND  <=?
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+word+"%");
			stmt.setInt(2, beginRow);
			stmt.setInt(3, endRow);
		}
		/*
		String sql = "SELECT board_no boardNo, board_title boardTitle, member_id memberId, createdate"
				+ " FROM (SELECT rownum rnum, board_no, board_title, member_id, createdate" // rnum을 고정시키기 위해서(where절을 쓰기위해서)
				+ " 	FROM (SELECT board_no, board_title, member_id, createdate" // 정렬해서 rnum을 붙이기위해서
				+ "				FROM board WHERE board_content like ? ORDER BY board_no asc))"
				+ " WHERE rnum BETWEEN ? AND ?"; // WHERE rnum이 >=? AND  <=?
		*/
		/*
		// 쿼리 객체 생성
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리문 ?값 지정
		stmt.setString(1, "%"+word+"%");
		stmt.setInt(2, beginRow);
		stmt.setInt(3, endRow);
		*/
		// 쿼리 실행
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Board b = new Board();
			b.setBoardNo(rs.getInt("boardNo"));
			b.setBoardTitle(rs.getString("boardTitle"));
			b.setMemberId(rs.getString("memberId"));
			b.setCreatedate(rs.getString("createdate"));
			list.add(b);
		}
		stmt.close();
		rs.close();
		return list;
	}
	
	
	// BoardOneController.java
	public Board selectBoardOne(Connection conn, int boardNo) throws Exception {
		Board board = null;
		// 쿼리문 작성
		String sql = "SELECT board_no boardNo, board_title boardTitle, board_content boardContent, member_id memberId FROM board WHERE board_no = ?";
		// 쿼리 객체 생성
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리문 ?값 지정
		stmt.setInt(1, boardNo);
		// 쿼리 실행
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			board = new Board();
			board.setBoardNo(rs.getInt("boardNo"));
			board.setBoardTitle(rs.getString("boardTitle"));
			board.setBoardContent(rs.getString("boardContent"));
			board.setMemberId(rs.getString("memberId"));
		}
		return board;
	}
	
	// ModifyBoardFormController.java
	public Board selectBoardByModify(Connection conn, int boardNo) throws Exception {
		Board board = null;
		// 쿼리문 작성
		String sql = "SELECT board_no boardNo, board_title boardTitle, board_content boardContent FROM board WHERE board_no = ?";
		// 쿼리 객체 생성
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리문 ?값 지정
		stmt.setInt(1, boardNo);
		// 쿼리 실행
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			board = new Board();
			board.setBoardNo(rs.getInt("boardNo"));
			board.setBoardTitle(rs.getString("boardTitle"));
			board.setBoardContent(rs.getString("boardContent"));
		}
		return board;
	}
	
	// ModifyBoardActionController.java
	public int modifyBoard(Connection conn, Board board) throws Exception {
		// 객체 초기화
		int row = 0;
		// 쿼리문 작성
		String sql = "UPDATE board SET board_title=?, board_content=?, updatedate = sysdate WHERE board_no = ?";
		// 쿼리 객체 생성
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리문 ?값 지정
		stmt.setString(1, board.getBoardTitle());
		stmt.setString(2, board.getBoardContent());
		stmt.setInt(3, board.getBoardNo());
		// 쿼리 실행
		row = stmt.executeUpdate();
		
		stmt.close();
		return row;
	}
	
	// AddBoardActionController.java
	public int insertBoard(Connection conn, Board board) throws Exception {
		// 객체 초기화
		int row = 0;
		// 쿼리문 작성
		String sql = "INSERT INTO board (board_no, board_title, board_content, member_id, updatedate, createdate) "
				+ " values(board_seq.NEXTVAL, ?, ?, ?, sysdate, sysdate)";
		/*
		String sql = "insert into board ("
				+ "    board_no, board_title, board_content, member_id, updatedate, createdate"
				+ ") values ("
				+ "    board_seq.NEXTVAL, ?, ?, ?, sysdate, sysdate"
				+ ")";
		*/
		// 쿼리 객체생성
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리문 ?값 지정
		stmt.setString(1, board.getBoardTitle());
		stmt.setString(2, board.getBoardContent());
		stmt.setString(3, board.getMemberId());
		// 쿼리 실행
		row = stmt.executeUpdate();
		
		stmt.close();
		return row;
	}
	
	// RemoveBoardController.java
	public int deleteBoard(Connection conn, int boardNo, String memberId) throws Exception {
		// 객체 초기화
		int row = 0;
		// 쿼리문 작성
		String sql = "DELETE FROM board WHERE board_no = ? AND member_id=?";
		// 쿼리 객체 생성
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리문 ?값 지정
		stmt.setInt(1, boardNo);
		stmt.setString(2, memberId);
		// 쿼리 실행
		row = stmt.executeUpdate();
				
		stmt.close();
		return row;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
