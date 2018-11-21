package ua.nure.artemenko.SummaryTask4.web;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.artemenko.SummaryTask4.MyUtils;
import ua.nure.artemenko.SummaryTask4.db.DBManager;
import ua.nure.artemenko.SummaryTask4.db.entity.Flight;

@WebServlet(urlPatterns = { "/flightsDisp" })
public class FlightsServlet extends HttpServlet{

	private static final long serialVersionUID = -7232124014266126181L;
	
	public FlightsServlet() {
		
	}
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        Connection con = MyUtils.getStoredConnection(request);
	 
	        String errorString = null;
	        List<Flight> list = null;
	        try {
         list = DBManager.getInstance().findFlights(con);
	        } catch (Exception e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	        // Store info in request attribute, before forward to views
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("flight", list);
	         
	        // Forward to /WEB-INF/views/flights.jsp
	        RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/WEB-INF/views/dispatcher/flightsDisp.jsp");
	        dispatcher.forward(request, response);
	    }
	 
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }


}
