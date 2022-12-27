package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import vo.Board;

/**
 * Servlet implementation class AddBoardActionController
 */
@WebServlet("/AddBoardActionController")
public class AddBoardActionController extends HttpServlet {
	private BoardService boardService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		String memberId = request.getParameter("memberId");
		// System.out.println(boardTitle);
		// System.out.println(boardContent);
		// System.out.println(memberId);
		
		// 메서드 호출시 사용할 매개변수
		Board board = new Board();
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		board.setMemberId(memberId);
		
		// 메서드 호출
		this.boardService = new BoardService();
		int row = boardService.insertBoard(board);
		
		response.sendRedirect(request.getContextPath()+"/BoardListController");
	}

}
