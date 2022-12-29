package service;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MemberDao;
import util.DBUtil;
import vo.Member;

public class MemberService {
	private MemberDao memberDao;
	// MemberListController.java
	public ArrayList<Member> getMemberList(int currentPage, int rowPerPage) {
		/*
		 * 1) Connection 생성
		 * 2) currentPage와 rowPerPage를 가공하여 beginRow와 endRow를 만들어서 Controller로 넘겨준다. 서비스레이어가 하는일임
		 */
		// dao 초기화&공간확보
		memberDao = new MemberDao();
		// 객체 초기화
		ArrayList<Member> list = null;
		// 드라이버 초기화
		Connection conn = null;
		// 페이징
		int beginRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = beginRow + rowPerPage - 1;
		
		try {
			// 드라이버 연결
			conn = DBUtil.getConnection();
			// 오토커밋끄기
			conn.setAutoCommit(false);
			// dao 호출
			list = memberDao.selectMemberList(conn, beginRow, endRow);
			// 커밋하기
			conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원반납
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	// LoginActionController.java
	public Member login(Member member) {
		// dao 초기화&공간확보
		memberDao = new MemberDao();
		// 객체 초기화
		Member resultMember = null;
		// 드라이버 초기화
		Connection conn = null;
		
		try {
			// 드라이버 연결
			conn = DBUtil.getConnection();
			// 오토커밋 끄기
			conn.setAutoCommit(false);
			// dao 호출
			resultMember = memberDao.loginMember(conn, member);
			// 커밋
			conn.commit();
		} catch(Exception e) {
			// 로그인 실패시 롤백
			try {
				conn.rollback();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			// 로그인 성공시 자원 반납
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return resultMember;
	}
	
	// AddMemberActionController.java
	public int insertMember(Member member) {
		// dao 초기화&공간확보
		memberDao = new MemberDao();
		// 객체초기화
		int row = 0;
		// 드라이버 초기화
		Connection conn = null;
		
		try {
			// 드라이버 연결
			conn = DBUtil.getConnection();
			// 오토커밋 끄기
			conn.setAutoCommit(false);
			// dao 호출
			row = memberDao.insertMember(conn, member);
			// 커밋하기
			conn.commit();
		} catch(Exception e) {
			// 실패시 롤백
			try {
				conn.rollback();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			// 성공시 자원반납
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	// MemberOneController.java
	public Member getMemberOne(String memberId) {
		// dao 초기화&공간확보
		memberDao = new MemberDao();
		// 객체 초기화
		Member member = null;
		// 드라이버 초기화
		Connection conn = null;
		
		try {
			// 드라이버 연결
			conn = DBUtil.getConnection();
			// 오토커밋 끄기
			conn.setAutoCommit(false);
			// dao 호출
			member = memberDao.selectMember(conn, memberId);
			// 커밋하기
			conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 자원반납
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return member;
	}
	
	// 회원정보 수정 modifyMember
	public int updateMember(Member member) {
		// dao 초기화&공간확보
		memberDao = new MemberDao();
		// 객체 초기화
		int row = 0;
		// 드라이버 초기화
		Connection conn = null;
		
		try {
			// 드라이버 연결
			conn = DBUtil.getConnection();
			// 커밋끄기
			conn.setAutoCommit(false);
			// dao호출
			row = memberDao.updateMember(conn, member);
			// 커밋
			conn.commit();
		} catch(Exception e) {
			// 수정실패시 롤백
			try {
				conn.rollback();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			// 수정성공 자원반납
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	// 비밀번호 수정 modifyMemberPw
	public int updateMemberPw(String updatePw, String memberId, String memberPw) {
		// dao초기화&공간확보
		memberDao = new MemberDao();
		// 객체초기화
		int row = 0;
		// 드라이버 초기화
		Connection conn = null;
		
		try {
			// 드라이버 연결
			conn = DBUtil.getConnection();
			// 커밋끄기
			conn.setAutoCommit(false);
			// dao호출
			row = memberDao.updateMemberPw(conn, updatePw, memberId, memberPw);
			// 커밋
			conn.commit();
		} catch(Exception e) {
			// 수정실패 롤백
			try {
				conn.rollback();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			// 수정성공 자원반납
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	// 회원탈퇴 RemoveMemberController
	public int deleteMember(Member member) {
		// dao초기화&공간확보
		memberDao = new MemberDao();
		// 객체 초기화
		int row = 0;
		// 드라이버 초기화
		Connection conn = null;
		
		try {
			// 드라이버 연결
			conn = DBUtil.getConnection();
			// 커밋끄기
			conn.setAutoCommit(false);
			// dao호출
			row = memberDao.deleteMember(conn, member);
			// 커밋
			conn.commit();
		} catch(Exception e) {
			// 실패시 롤백
			try {
				conn.rollback();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			// 성공시 자원반납
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	// 아이디 중복 AddMemberController.java
	public Boolean memberCk(String memberId) {
		// dao 초기화&공간확보
		memberDao = new MemberDao();
		// 객체 초기화
		boolean result = false;
		// 드라이버 초기화
		Connection conn = null;
		
		try {
			// 드라이버 연결
			conn = DBUtil.getConnection();
			// 커밋끄기
			conn.setAutoCommit(result);
			// dao 호출
			result = memberDao.memberCk(conn, memberId);
			// 커밋
			conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 자원반납
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 닉네임 중복 AddMemberController.java
		public Boolean memberNameCk(String memberName) {
			// dao 초기화&공간확보
			memberDao = new MemberDao();
			// 객체 초기화
			boolean result = false;
			// 드라이버 초기화
			Connection conn = null;
			
			try {
				// 드라이버 연결
				conn = DBUtil.getConnection();
				// 커밋끄기
				conn.setAutoCommit(result);
				// dao 호출
				result = memberDao.memberNameCk(conn, memberName);
				// 커밋
				conn.commit();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				// 자원반납
				try {
					conn.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			return result;
		}
		
	// 닉네임 중복 AddMemberController.java
	public Boolean updateMemberNameCk(String memberName) {
		// dao 초기화&공간확보
		memberDao = new MemberDao();
		// 객체 초기화
		boolean result = false;
		// 드라이버 초기화
		Connection conn = null;
		
		try {
			// 드라이버 연결
			conn = DBUtil.getConnection();
			// 커밋끄기
			conn.setAutoCommit(result);
			// dao 호출
			result = memberDao.updateMemberNameCk(conn, memberName);
			// 커밋
			conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 자원반납
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 비밀번호 변경시 중복 방지
	public Boolean updatePwCk(String memberId, String memberPw) {
		// dao 초기화&공간확보
		memberDao = new MemberDao();
		// 객체 초기화
		boolean result = false;
		// 드라이버 초기화
		Connection conn = null;
		
		try {
			// 드라이버 연결
			conn = DBUtil.getConnection();
			// 커밋끄기
			conn.setAutoCommit(result);
			// dao 호출
			result = memberDao.updatePwCk(conn, memberId, memberPw);
			// 커밋
			conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 자원반납
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
