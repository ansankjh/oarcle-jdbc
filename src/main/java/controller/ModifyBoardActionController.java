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
 * Servlet implementation class ModifyBoardActionController
 */
@WebServlet("/ModifyBoardActionController")
public class ModifyBoardActionController extends HttpServlet {
	private BoardService boardService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		// System.out.println(boardTitle);
		// System.out.println(boardContent);
		
		// 메서드 호출 매개값
		Board board = new Board();
		board.setBoardNo(boardNo);
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		
		// 메서드 호출
		this.boardService = new BoardService();
		int row = boardService.modify(board);
		
		response.sendRedirect(request.getContextPath()+"/BoardListController");
	}

}
