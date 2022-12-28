package controller;

import java.io.IOException;

import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.Member;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/member/login")
public class LoginController extends HttpServlet {
	
	// 로그인 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인상태면 home으로
		HttpSession session =  request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember != null) {
			response.sendRedirect(request.getContextPath()+"/home");
			return;
		}
		
		String msg = request.getParameter("msg");
		request.setAttribute("msg", msg);
		
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}

	// 로그인 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 로그인 세션 정보  : session.setAttribute("loginMember", Member타입)
		 */
		// -> home
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("utf-8");
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		// System.out.println(memberId);
		// System.out.println(memberPw);
		
		// 메서드 호출시 매개변수
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		// 메서드 호출
		MemberService memberService = new MemberService();
		Member returnMember = memberService.login(member);
		
		// 로그인 실패시 문구 출력
		if(returnMember == null) {
			String msg = URLEncoder.encode("로그인 실패", "utf-8");
			response.sendRedirect(request.getContextPath()+"/member/login?msg="+msg);
			return;
		}
		
		// 로그인성공시 home으로
		session.setAttribute("loginMember", returnMember);
		response.sendRedirect(request.getContextPath()+"/home");
	}

}
