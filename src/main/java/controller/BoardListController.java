package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardService;
import vo.Board;
import vo.Member;

@WebServlet("/board/boardList")
public class BoardListController extends HttpServlet {
	private BoardService boardService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = request.getParameter("msg");
		String word = request.getParameter("word");
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		// 비로그인시 접근불가
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath()+"/member/login");
			return;
		}
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int rowPerPage = 10; // rowPerPage는 안넘어오면 10이다
		if(request.getParameter("rowPerPage") != null) {
			rowPerPage = Integer.parseInt(request.getParameter("rowPerPage"));
			// System.out.println(rowPerPage);
		}
		
		this.boardService = new BoardService();
		ArrayList<Board> list = boardService.getBoardListByPage(word, currentPage, rowPerPage);
		// 마지막 페이지
		int lastPage = boardService.selectCount(word) / rowPerPage;
		// System.out.println(lastPage + "<-- 마지막페이지");
		request.setAttribute("boardList", list);
		request.setAttribute("currentPage", currentPage); // view에서 필요
		request.setAttribute("rowPerPage", rowPerPage); // view에서 필요
		request.setAttribute("loginMember", loginMember);
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("msg", msg);
		request.setAttribute("word", word);
		
		/*
		 * VIEW 메뉴구성
		 * 글입력
		 * 상세보기(수정,삭제)
		 */
		request.getRequestDispatcher("/WEB-INF/view/board/boardList.jsp").forward(request, response);
	}
}
