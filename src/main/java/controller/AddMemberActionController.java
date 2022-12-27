package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import vo.Member;

/**
 * Servlet implementation class AddMemberActionController
 */
@WebServlet("/AddMemberActionController")
public class AddMemberActionController extends HttpServlet {
	private MemberService memberService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		// System.out.println(memberId);
		// System.out.println(memberPw);
		// System.out.println(memberName);
		
		// 메서드 호출시 매개변수
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		member.setMemberName(memberName);
		
		// 메서드 호출
		this.memberService = new MemberService();
		int row = memberService.insertMember(member);
		
		response.sendRedirect(request.getContextPath()+"/LoginFormController");
	}

}
