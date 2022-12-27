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
 * Servlet implementation class LoginActionController
 */
@WebServlet("/LoginActionController")
public class LoginActionController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			response.sendRedirect(request.getContextPath()+"/LoginFormController?msg="+msg);
			return;
		}
		
		session.setAttribute("loginMember", returnMember);
		response.sendRedirect(request.getContextPath()+"/HomeController");
	}

}
