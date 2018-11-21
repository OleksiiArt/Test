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

@WebServlet(urlPatterns = { "/createFlight" })
public class CreateFlightServlet extends HttpServlet{

	private static final long serialVersionUID = 8840436426880408131L;
	
	public CreateFlightServlet() {
        super();
    }
 
    // Show product creation page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/admin/createFlight.jsp");
        dispatcher.forward(request, response);
    }
 
    // When the user enters the flight information, and click Submit.
    // This method will be called.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection con = MyUtils.getStoredConnection(request);
 
//        int id = Integer.valueOf(request.getParameter("id"));
        String number = (String) request.getParameter("number");
        String name = (String) request.getParameter("name");
        String from = (String) request.getParameter("from");
        String to = (String) request.getParameter("to");
        String flightDate = (String) request.getParameter("flightDate");
      
        Flight flight = new Flight(number, name, from, to, flightDate);
 
        String errorString = null;
 
        // Flight number is the string literal [a-zA-Z_0-9]
        // with at least 1 character
        String regex = "[a-zA-Z0-9А-Яа-я]+";
 
        if (number == null || !number.matches(regex)) {
            errorString = "Flight number is invalid!";
        }
 
        if (errorString == null) {
            try {
                DBManager.getInstance().createFlight(con, flight);
            } catch (Exception e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
 
        // Store information to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("flight", flight);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/admin/createFlight.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the flights list page.
        else {
            response.sendRedirect(request.getContextPath() + "/flights");
        }
    }

}
