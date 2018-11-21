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
import ua.nure.artemenko.SummaryTask4.db.entity.Worker;


@WebServlet(urlPatterns = { "/createCrewMember" })
public class CreateCrewMemberServlet extends HttpServlet{

	private static final long serialVersionUID = 5399697566594825423L;
	
	public CreateCrewMemberServlet() {
		
	}
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	 
	        RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/WEB-INF/views/admin/createCrewMember.jsp");
	        dispatcher.forward(request, response);
	    }
	 
	    // When the user enters the flight information, and click Submit.
	    // This method will be called.
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        Connection con = MyUtils.getStoredConnection(request);
	 
	       
	        String firstName = (String) request.getParameter("firstName");
	        String lastName = (String) request.getParameter("lastName");
	        int positionId = Integer.valueOf(request.getParameter("positionId"));
	      
	        Worker worker = new Worker(firstName, lastName, positionId);
	 
	        String errorString = null;
	 
	        // Position is the string literal [a-zA-Z_0-9]
	        // with at least 1 character
	        String regex = "[a-zA-Z0-9А-Яа-я]+";
	 
	        if (firstName == null || !firstName.matches(regex)) {
	            errorString = "First name is invalid!";
	        }
	 
	        if (errorString == null) {
	            try {
	                DBManager.getInstance().createWorker(con, worker);
	            } catch (Exception e) {
	                e.printStackTrace();
	                errorString = e.getMessage();
	            }
	        }
	 
	        // Store information to request attribute, before forward to views.
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("worker", worker);
	 
	        // If error, forward to Edit page.
	        if (errorString != null) {
	            RequestDispatcher dispatcher = request.getServletContext()
	                    .getRequestDispatcher("/WEB-INF/views/admin/createCrewMember.jsp");
	            dispatcher.forward(request, response);
	        }
	        // If everything nice.
	        // Redirect to the flights list page.
	        else {
	            response.sendRedirect(request.getContextPath() + "/crewMembers");
	        }
	    }

}
