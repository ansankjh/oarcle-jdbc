package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;

/**
 * Servlet implementation class ModifyMemberActionController
 */
@WebServlet("/ModifyMemberActionController")
public class ModifyMemberActionController extends HttpServlet {
	private MemberService memberService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memberId = request.getParameter("memberId");
		String memberName = request.getParameter("memberName");
		String memberPw = request.getParameter("memberPw");
		System.out.println(memberId);
		System.out.println(memberName);
		System.out.println(memberPw);
	}

}
