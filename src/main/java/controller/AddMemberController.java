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

import java.net.*;
/**
 * Servlet implementation class AddMemberController
 */
@WebServlet("/member/addMember")
public class AddMemberController extends HttpServlet {
	private MemberService memberService;
	// 회원가입폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 *  VIEW -> addMember.jsp
		 */
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember != null) { // 로그인 되어있다면
			response.sendRedirect(request.getContextPath()+"/home");
			return;
		}
		
		String msg = request.getParameter("msg");
		
		session.setAttribute("msg", msg);
		
		request.getRequestDispatcher("/WEB-INF/view/member/addMember.jsp").forward(request, response);
	}

	// 회원가입 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// LoginController
		request.setCharacterEncoding("utf-8");
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberPwCk = request.getParameter("memberPwCk");
		String memberName = request.getParameter("memberName");
		// System.out.println(memberId);
		// System.out.println(memberPw);
		// System.out.println(memberPwCk);
		// System.out.println(memberName);
		
		if(!memberPw.equals(memberPwCk)) {
			String msg = URLEncoder.encode("비밀번호가 다릅니다.", "utf-8");
			response.sendRedirect(request.getContextPath()+"/member/addMember?msg="+msg);
		}
		
		// 메서드 호출시 매개변수
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		member.setMemberName(memberName);
		
		// 메서드 호출
		this.memberService = new MemberService();
		boolean result = memberService.memberCk(memberId);
		boolean result2 = memberService.memberNameCk(memberName);
		
		if(result == true) {
			String msg = URLEncoder.encode("아이디 중복", "utf-8");
			response.sendRedirect(request.getContextPath()+"/member/addMember?msg="+msg);
		} else if(result2 == true) {
			String msg = URLEncoder.encode("닉네임 중복", "utf-8");
			response.sendRedirect(request.getContextPath()+"/member/addMember?msg="+msg);
		} else {
			int row = memberService.insertMember(member);
			String msg = URLEncoder.encode("회원가입 완료", "utf-8");
			response.sendRedirect(request.getContextPath()+"/member/login?msg="+msg);
		}
		
	}

}
