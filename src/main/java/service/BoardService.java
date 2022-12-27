package service;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDao;
import util.DBUtil;
import vo.Board;

public class BoardService {
	private BoardDao boardDao;
	
	public ArrayList<Board> getBoardListByPage(int currentPage, int rowPerPage) { // 
		/*
		 * 1) Connection 생성
		 * 2) currentPage와 rowPerPage를 가공하여 beginRow와 endRow를 만들어서 Controller로 넘겨준다. 서비스레이어가 하는일임
		 */
		// dao 초기화&공간확보
		boardDao = new BoardDao();
		// 객체 초기화
		ArrayList<Board> list = null;
		// 드라이버 초기화
		Connection conn = null;
		int beginRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = beginRow + rowPerPage - 1;
		
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			list = boardDao.selectBoardListByPage(conn, beginRow, endRow); // 여기서 만들어서 Controller로 넘겨준다.
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch(Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
			} catch(Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	// BoardOneController.java
	public Board getBoardOne(int boardNo) {
		// dao 초기화&공강확보
		boardDao = new BoardDao();
		// 객체 초기화
		Board board = null;
		// 드라이버 초기화
		Connection conn = null;
		
		try {
			// 드라이버 연결
			conn = DBUtil.getConnection();
			// 오토커밋끄기
			conn.setAutoCommit(false);
			// 메서드 호출
			board = boardDao.selectBoardOne(conn, boardNo);
			// 커밋
			conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return board;
	}
	
	// ModifyBoardFormController.java
		public Board getBoardModify(int boardNo) {
			// dao 초기화&공강확보
			boardDao = new BoardDao();
			// 객체 초기화
			Board board = null;
			// 드라이버 초기화
			Connection conn = null;
			
			try {
				// 드라이버 연결
				conn = DBUtil.getConnection();
				// 오토커밋끄기
				conn.setAutoCommit(false);
				// 메서드 호출
				board = boardDao.selectBoardOne(conn, boardNo);
				// 커밋
				conn.commit();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			return board;
		}
		
	// ModifyBoardActionController.java
	public int modify(Board board) {
		// dao 초기화&공간확보
		this.boardDao = new BoardDao();
		// 객체 초기화
		int row = 0;
		// 드라이버 초기화
		Connection conn = null;
		
		try {
			// 드라이버 연결
			conn = DBUtil.getConnection();
			// 오토커밋 끄기
			conn.setAutoCommit(false);
			// dao 호출
			row = boardDao.modifyBoard(conn, board);
			// 커밋하기
			conn.commit();
		} catch(Exception e) {
			// 수정 실패시 롤백
			try {
				conn.rollback();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			// 수정 완료시 자원반납
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
		
		
	// AddBoardActionController.java
	public int insertBoard(Board board) {
		// dao 초기화&공간확보
		boardDao = new BoardDao();
		// 객체 초기화
		int row = 0;
		// 드라이버 초기화
		Connection conn = null;
		
		try {
			// 드라이버 연결
			conn = DBUtil.getConnection();
			// 오토커밋 끄기
			conn.setAutoCommit(false);
			// dao 호출
			row = boardDao.insertBoard(conn, board);
			// 커밋하기
			conn.commit();
		} catch(Exception e) {
			// 입력 실패시 롤백
			try {
				conn.rollback();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			// 입력 성공시 자원반납
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	// RemoveBoardController.java
	public int deleteBoard(int boardNo) {
		// dao 초기화&공간 확보
		boardDao = new BoardDao();
		// 객체 초기화
		int row = 0;
		// 드라이버 초기화
		Connection conn = null;
		
		try {
			//드라이버 연결
			conn = DBUtil.getConnection();
			// 오토커밋 끄기
			conn.setAutoCommit(false);
			// dao 호출
			row = boardDao.deleteBoard(conn, boardNo);
			// 커밋하기
			conn.commit();
		} catch(Exception e) {
			// 삭제 실패시 롤백
			try {
				conn.rollback();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			// 삭제 성공후 자원반납
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
