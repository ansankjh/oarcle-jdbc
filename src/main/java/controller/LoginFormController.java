package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Member;

/**
 * Servlet implementation class LoginFormController
 */
@WebServlet("/LoginFormController")
public class LoginFormController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인상태면 home으로
		HttpSession session =  request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember != null) {
			response.sendRedirect(request.getContextPath()+"/HomeController");
			return;
		}
		
		String msg = request.getParameter("msg");
		request.setAttribute("msg", msg);
		
		request.getRequestDispatcher("/WEB-INF/view/loginForm.jsp").forward(request, response);
	}
}
