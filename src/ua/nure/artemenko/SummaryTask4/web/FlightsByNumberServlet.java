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

@WebServlet(urlPatterns = { "/flightByNumber" })
public class FlightsByNumberServlet extends HttpServlet {

	private static final long serialVersionUID = 8872100524298852992L;

	public FlightsByNumberServlet() {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = MyUtils.getStoredConnection(request);

		String number = (String) request.getParameter("number");

		Flight flight = null;

		String errorString = null;

		try {
			flight = DBManager.getInstance().findFlight(con, number);
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		// If no error.
		// The flight does not exist to edit.
		// Redirect to the flights page.
		if (errorString != null && flight == null) {
			errorString = "Please, try again.";
			response.sendRedirect(request.getServletPath() + "/showAllFlights");
			return;
		}

		// Store errorString in request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("flight", flight);

		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/showFlightsByNumber.jsp");
		dispatcher.forward(request, response);

	}

}
