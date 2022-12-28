package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;

/**
 * Servlet implementation class RemoveBoardController
 */
@WebServlet("/board/removeBoard")
public class RemoveBoardController extends HttpServlet {
	private BoardService boardService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 바로 삭제 대신 alert로 삭제하시겠습니까? 경고창 띄우기
		// 로그인한 멤버랑 글쓴 멤버랑 같아야 삭제가능
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		// System.out.println(boardNo);
		
		this.boardService = new BoardService();
		int row = boardService.deleteBoard(boardNo);
		
		response.sendRedirect(request.getContextPath()+"/BoardListController");
	}
}
