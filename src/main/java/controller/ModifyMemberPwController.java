package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.Member;

/**
 * Servlet implementation class ModifyMemberPwController
 */
@WebServlet("/member/modifyMemberPw")
public class ModifyMemberPwController extends HttpServlet {
	private MemberService memberService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 비로그인시 접근불가
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath()+"/member/login");
			return;
		}
		// 로그인정보 보내기
		request.setAttribute("loginMember", loginMember);
		request.getRequestDispatcher("/WEB-INF/view/member/modifyMemberPw.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memberId = request.getParameter("memberId");
		String updatePw = request.getParameter("updatePw");
		String memberPw = request.getParameter("memberPw");
		// System.out.println(memberId);
		// System.out.println(updatePw);
		// System.out.println(memberPw);
		
		// 메서드 호출할 매개변수
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		// 메서드 호출
		this.memberService = new MemberService();
		int row = memberService.updateMemberPw(updatePw, member);
		
		if(row == 1) {
			System.out.println("비밀번호수정완료");
			response.sendRedirect(request.getContextPath()+"/member/memberOne");
		} else {
			System.out.println("비밀번호수정실패");
			response.sendRedirect(request.getContextPath()+"/member/modifyMemberPw");
		}
	}

}
