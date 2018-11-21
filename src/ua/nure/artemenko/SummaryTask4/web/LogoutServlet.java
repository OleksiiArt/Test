package ua.nure.artemenko.SummaryTask4.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet(urlPatterns={"/logout"})
public class LogoutServlet extends HttpServlet{

	private static final long serialVersionUID = 3146159380029732482L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		System.out.println("Logout from cabinet");
		request.getRequestDispatcher("/home").forward(request,response);
	}

}
