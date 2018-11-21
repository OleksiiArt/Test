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

@WebServlet(urlPatterns = { "/flightBy3Param" })
public class FLightBy3ParamServlet extends HttpServlet {

	private static final long serialVersionUID = 7454477474045169691L;

	public FLightBy3ParamServlet() {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = MyUtils.getStoredConnection(request);

		String from = (String) request.getParameter("from");
		String to = (String) request.getParameter("to");
		String flightDate = (String) request.getParameter("flightDate");

		String errorString = null;
		Flight flight = null;

		try {
			flight = DBManager.getInstance().findFlightBy3Param(con, from, to, flightDate);
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		// If no error.
		// The flight does not exist to edit.
		// Redirect to the flights page.
		if (errorString != null) {
			response.sendRedirect(request.getServletPath() + "/showAllFlights");
			return;
		}

		// Store errorString in request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("flight", flight);

		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/showFlightBy3Param.jsp");
		dispatcher.forward(request, response);

	}

}
