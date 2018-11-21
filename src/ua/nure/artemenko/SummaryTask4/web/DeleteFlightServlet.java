package ua.nure.artemenko.SummaryTask4.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.artemenko.SummaryTask4.MyUtils;
import ua.nure.artemenko.SummaryTask4.db.DBManager;

@WebServlet(urlPatterns = { "/deleteFlight" })
public class DeleteFlightServlet extends HttpServlet{

	private static final long serialVersionUID = 1464191723707501904L;
	
	public DeleteFlightServlet() {
		super();
	}
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        Connection con = MyUtils.getStoredConnection(request);
	 
	        String number = (String) request.getParameter("number");
	 
	        String errorString = null;
	 
	        try {
	            DBManager.getInstance().deleteFlight(con, number);
	        } catch (Exception e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        } 
	         
	        // If has an error, redirect to the error page.
	        if (errorString != null) {
	            // Store the information in the request attribute, before forward to views.
	            request.setAttribute("errorString", errorString);
	            // 
	            RequestDispatcher dispatcher = request.getServletContext()
	                    .getRequestDispatcher("/WEB-INF/views/admin/deleteFlight.jsp");
	            dispatcher.forward(request, response);
	        }
	        // If everything nice.
	        // Redirect to the flights page.        
	        else {
	            response.sendRedirect(request.getContextPath() + "/flights");
	        }
	 
	    }
	 
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }

}
