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
 * Servlet implementation class BoardOneController
 */
@WebServlet("/board/boardOne")
public class BoardOneController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * -> board/boardOne
		 * 글수정,글삭제(로그인멤버 == 글쓴멤버) 본인의 글만 수정,삭제 가능
		 */
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		// 비로그인시 접근불가
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath()+"/member/login");
			return;
		}
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		// System.out.println(boardNo);
		
		// 서비스 호출
		BoardService boardService = new BoardService();
		Board board = boardService.getBoardOne(boardNo);
		
		// view에서 board 출력할때 쓸 키
		request.setAttribute("board", board);
		request.setAttribute("loginMember", loginMember);
		
		request.getRequestDispatcher("/WEB-INF/view/board/boardOne.jsp").forward(request, response);
	}

}
