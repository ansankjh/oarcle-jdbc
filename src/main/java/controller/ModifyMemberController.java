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
 * Servlet implementation class ModifyMemberController
 */
@WebServlet("/member/modifyMember")
public class ModifyMemberController extends HttpServlet {
	private MemberService memberService;
	
	// modifyMemberForm
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// -> modifyMember
		// 비로그인시 접근불가
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath()+"/member/login");
			return;
		}
		
		// view에 로그인정보 보내기
		request.setAttribute("loginMember", loginMember);
		request.getRequestDispatcher("/WEB-INF/view/member/modifyMember.jsp").forward(request, response);
	}

	// modifyMemberAction
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// -> 분기 성공 실패 memberOne(key값?) or modifyMember
		request.setCharacterEncoding("utf-8");
		String memberId = request.getParameter("memberId");
		String memberName = request.getParameter("memberName");
		String memberPw = request.getParameter("memberPw");
		// System.out.println(memberId);
		// System.out.println(memberName);
		// System.out.println(memberPw);
		
		// 메서드 호출 매개값
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberName(memberName);
		member.setMemberPw(memberPw);
		
		// 메서드 호출
		this.memberService = new MemberService();
		int row = memberService.updateMember(member);
		
		if(row == 1) {
			System.out.println("수정완료");
			response.sendRedirect(request.getContextPath()+"/member/memberOne");
		} else {
			System.out.println("수정실패");
			response.sendRedirect(request.getContextPath()+"/member/memberOne");
		}
	}

}
