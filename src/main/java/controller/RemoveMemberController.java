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
 * Servlet implementation class RemoveMemberController
 */
@WebServlet("/member/removeMember")
public class RemoveMemberController extends HttpServlet {
	private MemberService memberService;
	
	// RemoveMemberForm
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// -> RemoveMember
		// 비로그인시 접근불가
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath()+"/member/login");
			return;
		}
		
		String msg= request.getParameter("msg");
		
		session.setAttribute("msg", msg);
		
		// 로그인정보 보내주기
		request.setAttribute("loginMember", loginMember);
		
		request.getRequestDispatcher("/WEB-INF/view/member/removeMember.jsp").forward(request, response);
	}

	// RemoveMemberAction
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 성공or실패 성공->로그아웃(session.invalidate하지말고 logoutController로 보내서 세션삭제 시키기) or 실패->RemoveMember 
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		// System.out.println(memberId);
		// System.out.println(memberPw);
		
		// 메서드 호출시 매개변수
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		// 메서드 호출
		this.memberService = new MemberService();
		int row = memberService.deleteMember(member);
		
		if(row == 1) {
			System.out.println("회원탈퇴완료");
			response.sendRedirect(request.getContextPath()+"/member/logout");
		} else if(row != 1) {
			String msg = URLEncoder.encode("비밀번호를 확인하세요", "utf-8");
			response.sendRedirect(request.getContextPath()+"/member/removeMember?msg="+msg);
		}
	}

}
