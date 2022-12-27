package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import vo.Member;

/**
 * Servlet implementation class MemberListController
 */
@WebServlet("/MemberListController")
public class MemberListController extends HttpServlet {
	private MemberService memberService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 페이징용 현재페이지
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			System.out.println(currentPage);
		}
		// 페이지에 표시할 글의 수
		int rowPerPage = 10;
		if(request.getParameter("rowPerPage") != null) {
			rowPerPage = Integer.parseInt(request.getParameter("rowPerPage"));
			System.out.println(rowPerPage);
		}
		
		
		// 서비스 호출
		MemberService memberService = new MemberService();
		ArrayList<Member> list = memberService.getMemberList(currentPage, rowPerPage);
		request.setAttribute("memberList", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("rowPerPage", rowPerPage);
		
		request.getRequestDispatcher("/WEB-INF/view/memberList.jsp").forward(request, response);
	}
}
