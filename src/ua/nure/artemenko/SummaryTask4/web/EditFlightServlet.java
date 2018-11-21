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
import ua.nure.artemenko.SummaryTask4.db.entity.Flight;

@WebServlet(urlPatterns = { "/editFlight" })
public class EditFlightServlet extends HttpServlet{

	private static final long serialVersionUID = 263281421594271775L;
	
	public EditFlightServlet(){
		super();
	}
	
	 // Show flight edit page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection con = MyUtils.getStoredConnection(request);
 
//        String number = (String) request.getParameter("number");
        int idF = Integer.valueOf(request.getParameter("idF"));
        
        Flight flight = null;
 
        String errorString = null;
 
        try {
            flight = DBManager.getInstance().findFlightById(con, idF);
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        // If no error.
        // The flight does not exist to edit.
        // Redirect to the flights page.
        if (errorString != null && flight == null) {
            response.sendRedirect(request.getServletPath() + "/flights");
            return;
        }
 
        // Store errorString in request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("flight", flight);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/admin/editFlight.jsp");
        dispatcher.forward(request, response);
 
    }
 
    // After the user modifies the flight information, and click Submit.
    // This method will be executed.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection con = MyUtils.getStoredConnection(request);
        
        int idF = Integer.valueOf(request.getParameter("idF"));
        String number = (String) request.getParameter("number");
        String name = (String) request.getParameter("name");
        String from = (String) request.getParameter("from");
        String to = (String) request.getParameter("to");
        String flightDate = (String) request.getParameter("flightDate");
        Flight flight = new Flight(idF, number, name, from, to, flightDate);
 
        String errorString = null;
 
        try {
            DBManager.getInstance().updatetFlight(con, flight);
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // Store information to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("flight", flight);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/admin/editFlight.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the flights page.
        else {
            response.sendRedirect(request.getContextPath() + "/flights");
        }
    }

}
