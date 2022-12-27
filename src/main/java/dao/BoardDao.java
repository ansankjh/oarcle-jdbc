package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Board;

public class BoardDao {
	// 나중에 검색 추가
	public ArrayList<Board> selectBoardListByPage(Connection conn, int beginRow, int endRow) throws Exception {
		ArrayList<Board> list = new ArrayList<Board>();
		// 쿼리문 작성
		String sql = "SELECT board_no boardNo, board_title boardTitle, createdate"
				+ " FROM (SELECT rownum rnum, board_no, board_title, createdate" // rnum을 고정시키기 위해서(where절을 쓰기위해서)
				+ " 	FROM (SELECT board_no, board_title, createdate" // 정렬해서 rnum을 붙이기위해서
				+ "				FROM board ORDER BY board_no DESC))"
				+ " WHERE rnum BETWEEN ? AND ?"; // WHERE rnum이 >=? AND  <=?
		// 쿼리 객체 생성
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리문 ?값 지정
		stmt.setInt(1, beginRow);
		stmt.setInt(2, endRow);
		// 쿼리 실행
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Board b = new Board();
			b.setBoardNo(rs.getInt("boardNo"));
			b.setBoardTitle(rs.getString("boardTitle"));
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
	public int deleteBoard(Connection conn, int boardNo) throws Exception {
		// 객체 초기화
		int row = 0;
		// 쿼리문 작성
		String sql = "DELETE FROM board WHERE board_no = ?";
		// 쿼리 객체 생성
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리문 ?값 지정
		stmt.setInt(1, boardNo);
		// 쿼리 실행
		row = stmt.executeUpdate();
				
		stmt.close();
		return row;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}