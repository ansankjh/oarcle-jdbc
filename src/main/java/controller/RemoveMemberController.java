package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveMemberController
 */
@WebServlet("/member/removeMember")
public class RemoveMemberController extends HttpServlet {
	
	// RemoveMemberForm
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// -> RemoveMember
	}

	// RemoveMemberAction
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 성공or실패 성공->로그아웃(session.invalidate하지말고 logoutController로 보내서 세션삭제 시키기) or 실패->RemoveMember 
	}

}
