package ua.nure.artemenko.SummaryTask4.web;

import java.io.IOException;
import java.sql.Connection;
import java.util.Collections;
import java.util.Comparator;
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

@WebServlet(urlPatterns = { "/showFlightsNumber" })
public class ShowFlightNumbersServlet extends HttpServlet{

	
	private static final long serialVersionUID = -8643085863619736004L;
		
	public ShowFlightNumbersServlet() {
		
	}
	

	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        Connection con = MyUtils.getStoredConnection(request);
	 
	        String errorString = null;
	        List<Flight> list1 = null;
	        try {
        list1 = DBManager.getInstance().findFlights(con);
	        } catch (Exception e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	        Collections.sort(list1, new Comparator<Flight>(){
				public int compare(Flight o1, Flight o2) {
					return o1.getNumber().compareTo(o2.getNumber());
				}
			});
	        // Store info in request attribute, before forward to views
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("flight1", list1);
	        
	        // Forward to /WEB-INF/views/flights.jsp
	        RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/WEB-INF/views/flightsSortedByNumber.jsp");
	        dispatcher.forward(request, response);
	    }
	 
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }

}
