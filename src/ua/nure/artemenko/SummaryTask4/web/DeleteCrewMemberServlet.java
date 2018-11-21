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


@WebServlet(urlPatterns = { "/deleteCrewMember" })
public class DeleteCrewMemberServlet extends HttpServlet{

	private static final long serialVersionUID = 6599533362119916760L;
	
	public DeleteCrewMemberServlet() {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection con = MyUtils.getStoredConnection(request);
 
//        String id = (String) request.getParameter("id");
        int id = Integer.valueOf(request.getParameter("id"));
 
        String errorString = null;
 
        try {
            DBManager.getInstance().deleteWorker(con, id);
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
                    .getRequestDispatcher("/WEB-INF/views/admin/deleteCrewMember.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the flights page.        
        else {
            response.sendRedirect(request.getContextPath() + "/crewMembers");
        }
 
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
