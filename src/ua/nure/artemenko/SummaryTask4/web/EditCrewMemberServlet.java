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


@WebServlet(urlPatterns = { "/editCrewMember" })
public class EditCrewMemberServlet extends HttpServlet{

	private static final long serialVersionUID = 6421309039039325028L;
	
	public EditCrewMemberServlet() {
		
	}
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        Connection con = MyUtils.getStoredConnection(request);
	 
	        int id = Integer.valueOf(request.getParameter("id"));
	 
	        Worker worker = null;
	 
	        String errorString = null;
	 
	        try {
	        	worker = DBManager.getInstance().findWorker(con, id);
	        } catch (Exception e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	 
	        // If no error.
	        // The flight does not exist to edit.
	        // Redirect to the flights page.
	        if (errorString != null && worker == null) {
	            response.sendRedirect(request.getServletPath() + "/crewMembers");
	            return;
	        }
	 
	        // Store errorString in request attribute, before forward to views.
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("worker", worker);
	 System.out.println("Before send");
	        RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/WEB-INF/views/admin/editCrewMember.jsp");
	        dispatcher.forward(request, response);
	        System.out.println("after send");

	    }
	 
	    // After the user modifies the flight information, and click Submit.
	    // This method will be executed.
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        Connection con = MyUtils.getStoredConnection(request);
	        System.out.println("Before start edit");

	        
	        int id = Integer.valueOf(request.getParameter("id"));
	        String firstName = (String) request.getParameter("firstName");
	        String lastName = (String) request.getParameter("lastName");
	        int positionId = Integer.valueOf(request.getParameter("positionId"));
	        Worker worker = new Worker(id, firstName, lastName, positionId);
	 
	        String errorString = null;
	 
	        try {
	            DBManager.getInstance().updatetWorker(con, worker);
	        } catch (Exception e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	        // Store information to request attribute, before forward to views.
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("worker", worker);
	 
	        // If error, forward to Edit page.
	        if (errorString != null) {
	            RequestDispatcher dispatcher = request.getServletContext()
	                    .getRequestDispatcher("/WEB-INF/views/admin/editCrewMember.jsp");
	            dispatcher.forward(request, response);
	        }
	        // If everything nice.
	        // Redirect to the flights page.
	        else {
	            response.sendRedirect(request.getContextPath() + "/crewMembers");
	        }
	    }



}
