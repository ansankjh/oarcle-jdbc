package controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardService;
import vo.Member;

/**
 * Servlet implementation class RemoveBoardController
 */
@WebServlet("/board/removeBoard")
public class RemoveBoardController extends HttpServlet {
	private BoardService boardService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		// 바로 삭제 대신 alert로 삭제하시겠습니까? 경고창 띄우기
		// 로그인한 멤버랑 글쓴 멤버랑 같아야 삭제가능
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		// System.out.println(boardNo);
		
		this.boardService = new BoardService();
		int row = boardService.deleteBoard(boardNo, loginMember.getMemberId());
		
		if(row == 1) {
			String msg = URLEncoder.encode("삭제완료", "utf-8");
			response.sendRedirect(request.getContextPath()+"/board/boardList?msg="+msg);
		} else {
			String msg = URLEncoder.encode("게시글의 주인이아닙니다.", "utf-8");
			response.sendRedirect(request.getContextPath()+"/board/boardList?msg="+msg);
		}
		
		
	}
}
