package controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member/logout")
public class LogoutController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// -> home
		String msg = URLEncoder.encode("๋ก๊ทธ์์", "utf-8");
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath()+"/home?msg="+msg);
	}
}
