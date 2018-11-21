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

@WebServlet(urlPatterns = { "/showFlightsName" })
public class ShowFlightsNameServlet extends HttpServlet{

	private static final long serialVersionUID = -1043068971817785164L;
		
	public ShowFlightsNameServlet() {
		
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
	        Collections.sort(list, new Comparator<Flight>(){
				public int compare(Flight o1, Flight o2) {
					return o1.getName().compareTo(o2.getName());
				}
			});
	        // Store info in request attribute, before forward to views
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("flight", list);
	        
	        
	        
	        
	        // Forward to /WEB-INF/views/flights.jsp
	        RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/WEB-INF/views/flightsSortedByName.jsp");
	        dispatcher.forward(request, response);
	    }
	 
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }
}
