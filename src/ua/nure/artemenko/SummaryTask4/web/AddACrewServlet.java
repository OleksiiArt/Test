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
import ua.nure.artemenko.SummaryTask4.db.entity.Crew;


@WebServlet(urlPatterns = { "/addACrew" })
public class AddACrewServlet extends HttpServlet {

	private static final long serialVersionUID = -2795219772297070006L;

	public AddACrewServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/dispatcher/addACrew.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = MyUtils.getStoredConnection(request);

		int flight = Integer.valueOf(request.getParameter("flight"));
		int pilot1 = Integer.valueOf(request.getParameter("pilot1"));
		int pilot2 = Integer.valueOf(request.getParameter("pilot2"));
		int navigator = Integer.valueOf(request.getParameter("navigator"));
		int radio_operator = Integer.valueOf(request.getParameter("radio_operator"));
		int stewardess1 = Integer.valueOf(request.getParameter("stewardess1"));
		int stewardess2 = Integer.valueOf(request.getParameter("stewardess2"));
		int stewardess3 = Integer.valueOf(request.getParameter("stewardess3"));
		int stewardess4 = Integer.valueOf(request.getParameter("stewardess4"));
		int stewardess5 = Integer.valueOf(request.getParameter("stewardess5"));
		String status = (String) request.getParameter("status");
		
		Crew crew = new Crew(status);
//		Crew crew = null;
//		int idPilot = Integer.valueOf(request.getParameter("idPilot"));
//		request.getParameter("idPilot2");
//		request.getParameter("idStuardessa"); //...
//		
//		String pilotCheck = "SELECT id FROM pilots WHERE = pilotId = ?"; //idPilot 
//		String pilotId = null;
//		String pilotId2 = null;
//		String stuadressa = null;
//		
//		while (rs.next) {
//			String tmpId = rs.getString("Name");
//			if (tmpId != null ) {
//				pilotId = tmpId;
//			} else {
//				throw new Exception("Pilot not found");
//			}
//		}
		
		String errorString = null;
//	        Flight flight = new Flight(idF);
//	        Worker worker = new Worker(id);
		
		try {
			DBManager.getInstance().findFlightById(con, flight);
			DBManager.getInstance().checkPilot(con, pilot1);
			DBManager.getInstance().checkPilot(con, pilot2);
			DBManager.getInstance().checkNavigator(con, navigator);
			DBManager.getInstance().checkRadioOperator(con, radio_operator);
			DBManager.getInstance().checkStewardess(con, stewardess1);
			DBManager.getInstance().checkStewardess(con, stewardess2);
			DBManager.getInstance().checkStewardess(con, stewardess3);
			DBManager.getInstance().checkStewardess(con, stewardess4);
			DBManager.getInstance().checkStewardess(con, stewardess5);
			
			DBManager.getInstance().createCrew(con, crew);
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		// Store information to request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("crew", crew);

		// If error, forward to Edit page.
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/dispatcher/addACrew.jsp");
			dispatcher.forward(request, response);
		}
		// If everything nice.
		// Redirect to the flights list page.
		else {
			response.sendRedirect(request.getContextPath() + "/flightsDisp");
		}
	}

//	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
//	            throws ServletException, IOException {
//	 
//	//        RequestDispatcher dispatcher = request.getServletContext()
//	 //               .getRequestDispatcher("/WEB-INF/views/dispatcher/addACrew.jsp");
//	//        dispatcher.forward(request, response);
//		 Connection con = MyUtils.getStoredConnection(request);
//		    String errorString = null;
//		    Flight flight = null;
//		    Pilot pilot = null;
//		    Navigator navigator = null;
//		    RadioOperator radioOperator = null;
//		    Stewardess stewardess = null;
//	        List<CrewMember> list = null;
//	        try {
//	        	DBManager.getInstance().createCrewForFlight(con, flight, pilot, navigator, radioOperator, stewardess);
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            errorString = e.getMessage();
//	        }
//	        // Store info in request attribute, before forward to views
//	        request.setAttribute("errorString", errorString);
//	        request.setAttribute("crewMember", list);
//	         
//	        // Forward to /WEB-INF/views/flights.jsp
//	        RequestDispatcher dispatcher = request.getServletContext()
//	                .getRequestDispatcher("/WEB-INF/views/dispatcher/addACrew.jsp");
//	        dispatcher.forward(request, response);
//	    }
//	    
//	 
//	    // When the user enters the flight information, and click Submit.
//	    // This method will be called.
//	    @Override
//	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//	            throws ServletException, IOException {
//	        Connection con = MyUtils.getStoredConnection(request);
//	 
//	        
//	        String number = (String) request.getParameter("number");
//	        String id = (String) request.getParameter("id");
//	   //     int id = Integer.valueOf(request.getParameter("id"));
//	       
//	      
//	   //     FlightCrewMemberBean flightCrewMemberBean = new FlightCrewMemberBean(number, id);
//	        Flight flight = new Flight(number);
//	        CrewMember crewMember = new CrewMember(id);
//	 
//	        String errorString = null;
//	 
//	        // Position is the string literal [a-zA-Z_0-9]
//	        // with at least 1 character
//	        String regex = "\\w+";
//	 
//	        if (number == null || !number.matches(regex)) {
//	            errorString = "Number is invalid!";
//	        }
//	 
//	        if (errorString == null) {
//	            try {
//	                DBManager.getInstance().createFlightWithCrew(con, flight, crewMember);
//	            } catch (Exception e) {
//	                e.printStackTrace();
//	                errorString = e.getMessage();
//	            }
//	        }
//	 
//	        // Store information to request attribute, before forward to views.
//	        request.setAttribute("errorString", errorString);
//	        request.setAttribute("flight", flight);
//	        request.setAttribute("crewMember", crewMember);
//	 
//	        // If error, forward to Edit page.
//	        if (errorString != null) {
//	            RequestDispatcher dispatcher = request.getServletContext()
//	                    .getRequestDispatcher("/WEB-INF/views/dispatcher/addACrew.jsp");
//	            dispatcher.forward(request, response);
//	        }
//	        // If everything nice.
//	        // Redirect to the flights list page.
//	        else {
//	            response.sendRedirect(request.getContextPath() + "/flightsDisp");
//	        }
//	    }

}
