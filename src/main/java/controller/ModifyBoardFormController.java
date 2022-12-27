package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardService;
import vo.Board;
import vo.Member;

/**
 * Servlet implementation class ModifyBoardFormController
 */
@WebServlet("/ModifyBoardFormController")
public class ModifyBoardFormController extends HttpServlet {
	private BoardService boardService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 비로그인시 접근불가
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath()+"/LoginFormController");
			return;
		}
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		// System.out.println(boardNo);
		
		// 메서드 호출
		this.boardService = new BoardService();
		Board board = boardService.getBoardModify(boardNo);
		
		request.setAttribute("board", board);
		request.setAttribute("loginMember", loginMember);
		
		
		request.getRequestDispatcher("/WEB-INF/view/modifyBoardForm.jsp").forward(request, response);
	}
}
