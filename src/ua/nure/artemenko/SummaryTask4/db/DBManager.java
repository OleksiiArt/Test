package ua.nure.artemenko.SummaryTask4.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ua.nure.artemenko.SummaryTask4.db.entity.Crew;
import ua.nure.artemenko.SummaryTask4.db.entity.Flight;
import ua.nure.artemenko.SummaryTask4.db.entity.User;
import ua.nure.artemenko.SummaryTask4.db.entity.Worker;

public class DBManager {

	private DataSource ds;
	private static DBManager instance;

	public static synchronized DBManager getInstance() throws Exception {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}

	private DBManager() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			System.out.println(" Initialising Datasource in DBManager");
			ds = (DataSource) envContext.lookup("jdbc/testDB");

		} catch (NamingException ex) {
			ex.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			System.out.println(" Initialising Datasource in getConnection");
			ds = (DataSource) envContext.lookup("jdbc/testDB");
			con = ds.getConnection();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (NamingException s) {
			s.printStackTrace();
		}
		return con;
	}

	// Flight managing

//	public Flight createCrewForFlight(Connection con, Flight flight, Worker worker) throws Exception {
//		int idF = 0;
//		int id = 0;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			System.out.println("In DB method");
//			con = getConnection();
//			pstmt = con.prepareStatement(Constants.SQL_FIND_FLIGHT_BY_ID);
//			pstmt.setInt(1, idF);
//			pstmt.setInt(2, id);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				flight = extractFlight(rs);
//			}
//			con.commit();
//		} catch (SQLException ex) {
//			rollback(con);
//		} finally {
//			close(con, pstmt, rs);
//		}
//		return flight;
//	}
	public List<Crew> findAllCrews(Connection con)  {
		List<Crew> crewsList = new ArrayList<Crew>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(Constants.SQL_SELECT_ALL_CREWS);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				crewsList.add(extractCrew(rs));
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
		} finally {
			close(con, pstmt, rs);
		}
		return crewsList;
	}


	public void createCrew(Connection con, Crew crew) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Constants.SQL_CREATE_CREW);
			int k = 1;
			pstmt.setInt(k++, crew.getFlight());
			pstmt.setInt(k++, crew.getPilot1());
			pstmt.setInt(k++, crew.getPilot2());
			pstmt.setInt(k++, crew.getNavigator());
			pstmt.setInt(k++, crew.getRadio_operator());
			pstmt.setInt(k++, crew.getStewardess1());
			pstmt.setInt(k++, crew.getStewardess2());
			pstmt.setInt(k++, crew.getStewardess3());
			pstmt.setInt(k++, crew.getStewardess4());
			pstmt.setInt(k++, crew.getStewardess5());
			pstmt.setString(k++,  crew.getStatus());
			pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
	}

	

//	public List<Orders> findCrew(Connection con, int idF, int id) throws Exception {
//		List<Orders> ordersList = new ArrayList<Orders>();
//		PreparedStatement pstmt = null;
//		PreparedStatement pstmt1 = null;
//		ResultSet rs = null;
//		try {
//			System.out.println("In DB method");
//			con = getConnection();
//			pstmt = con.prepareStatement(Constants.SQL_SELECT_CREW_MEMBER_FOR_FLIGHT);
////			pstmt.setInt(1, idF);
////			pstmt.setInt(2, id);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				ordersList.add(extractOrders(rs));
//			}
//			pstmt1 = con.prepareStatement(Constants.SQL_SET_CREW_MEMBER_FOR_FLIGHT);
//			for (Orders o: ordersList) {
//				pstmt.setInt(1, o.getIdF());
//				pstmt.setInt(2, o.getId());
//				pstmt.executeQuery();
//			}
//			con.commit();
//		} catch (SQLException ex) {
//			close(pstmt);
//			close(pstmt1);
//			rollback(con);
//		} finally {
//			close(con, pstmt, rs);
//		}
//		return ordersList;
//	}

//	public void createCrewForFlight(Connection con, Flight flight, Worker... worker) {
//		PreparedStatement pstmt = null;
//		try {
//			pstmt = con.prepareStatement(Constants.SQL_SET_CREW_MEMBER_FOR_FLIGHT);
//			for (Worker gc : worker) {
//				pstmt.setInt(1, flight.getIdF());
//				pstmt.setInt(2, gc.getId());
//				pstmt.execute();
//				con.commit();
//			}
//		} catch (SQLException e) {
//			rollback(con);
//		} finally {
//			close(pstmt);
//		}
//	}

//	public List<CrewMember> findCrewMember(Connection con) throws Exception {
//		List<CrewMember> crewMemberList = new ArrayList<CrewMember>();
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			con = getConnection();
//			pstmt = con.prepareStatement(Constants.SQL_GET_CREW_FOR_FLIGHT);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				crewMemberList.add(extractCrewMember(rs));
//			}
//			con.commit();
//		} catch (SQLException ex) {
//			rollback(con);
//			throw new Exception();
//		} finally {
//			close(con, pstmt, rs);
//		}
//		return crewMemberList;
//	}

//	public List<Flight> findFlightsBy3Param(Connection con, String from, String to, String flightDate) throws Exception {
//		List<Flight> flightsList = new ArrayList<Flight>();
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			con = getConnection();
//			pstmt = con.prepareStatement(Constants.SQL_SELECT_ALL_FLIGHTS_BY_3_PARAM);
//			pstmt.setString(1, from);
//			pstmt.setString(2, to);
//			pstmt.setString(3, flightDate);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				flightsList.add(extractFlight(rs));
//			}
//			con.commit();
//		} catch (SQLException ex) {
//			rollback(con);
//			throw new Exception();
//		} finally {
//			close(con, pstmt, rs);
//		}
//		return flightsList;
//	}
//	
	public Flight findFlightBy3Param(Connection con, String from, String to, String flightDate) throws Exception {
		Flight flight = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			System.out.println("In DB method 3 param");
			con = getConnection();
			pstmt = con.prepareStatement(Constants.SQL_SELECT_ALL_FLIGHTS_BY_3_PARAM);
			pstmt.setString(1, from);
			pstmt.setString(2, to);
			pstmt.setString(3, flightDate);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flight = extractFlight(rs);
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
		} finally {
			close(con, pstmt, rs);
		}
		return flight;
	}

	public Flight findFlightByNumber(Connection con, String number) throws Exception {
		Flight flight = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			System.out.println("In DB method");
			con = getConnection();
			pstmt = con.prepareStatement(Constants.SQL_FIND_FLIGHT_BY_NUMBER);
			pstmt.setString(1, number);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flight = extractFlight(rs);
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
		} finally {
			close(con, pstmt, rs);
		}
		return flight;
	}

//	public void printFlight(Connection con, Flight flight) throws SQLException {
//		PreparedStatement pstmt = null;
//		try {
//			pstmt = con.prepareStatement(Constants.SQL_UPDATE_FLIGHT);
//			pstmt.setString(1, flight.getName());
//			pstmt.setString(2, flight.getFrom());
//			pstmt.setString(3, flight.getTo());
//			pstmt.setString(4, flight.getFlightDate());
//			pstmt.setString(5, flight.getNumber());
//			pstmt.execute();
//		} finally {
//			close(pstmt);
//		}
//	}

	public User findUserByLogin(Connection con, String login) throws Exception {
		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			if (con.isClosed()) {
				System.out.println("~~~~~~~~~~~~~~~~~~");
			}
			pstmt = con.prepareStatement(Constants.SQL_FIND_USER_BY_LOGIN);
			pstmt.setString(1, login);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = extractUser(rs);
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
		} finally {
			close(con, pstmt, rs);
		}
		return user;
	}

	// Methods for flights

	public Flight findFlightById(Connection con, Integer idF) throws Exception {
		Flight flight = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			System.out.println("Flight method");
			pstmt = con.prepareStatement(Constants.SQL_FIND_FLIGHT_BY_ID);
			pstmt.setInt(1, idF);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flight = extractFlight(rs);
//				idF = rs.getInt("id");
				if(flight == null) {
					throw new Exception("Flight wasn`t found");
				}
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
		} finally {
			close(con, pstmt, rs);
		}
		return flight;
	}

	public Flight findFlight(Connection con, String number) throws Exception {
		Flight flight = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			System.out.println("In method Find by number");
			pstmt = con.prepareStatement(Constants.SQL_FIND_FLIGHT_BY_NUMBER);
			pstmt.setString(1, number);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flight = extractFlight(rs);
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
		} finally {
			close(con, pstmt, rs);
		}
		return flight;
	}

	public List<Flight> findFlights(Connection con) throws Exception {
		List<Flight> flightsList = new ArrayList<Flight>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(Constants.SQL_SELECT_ALL_FLIGHTS);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				flightsList.add(extractFlight(rs));
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
			throw new Exception();
		} finally {
			close(con, pstmt, rs);
		}
		return flightsList;
	}

	public void createFlight(Connection con, Flight flight) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Constants.SQL_INSERT_FLIGHT);
			int k = 1;
			pstmt.setString(k++, flight.getNumber());
			pstmt.setString(k++, flight.getName());
			pstmt.setString(k++, flight.getFrom());
			pstmt.setString(k++, flight.getTo());
			pstmt.setString(k++, flight.getFlightDate());
			pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
	}

	public void updatetFlight(Connection con, Flight flight) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Constants.SQL_UPDATE_FLIGHT);
			pstmt.setString(1, flight.getNumber());
			pstmt.setString(2, flight.getName());
			pstmt.setString(3, flight.getFrom());
			pstmt.setString(4, flight.getTo());
			pstmt.setString(5, flight.getFlightDate());
			pstmt.setInt(6, flight.getIdF());
			pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
	}

	public void deleteFlight(Connection con, String number) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Constants.SQL_DELETE_FLIGHT);
			pstmt.setString(1, number);
			pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
	}

	// Methods for entity: Navigator

	public void createWorker(Connection con, Worker worker) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Constants.SQL_CREATE_WORKER);
			int k = 1;
			pstmt.setString(k++, worker.getFirstName());
			pstmt.setString(k++, worker.getLastName());
			pstmt.setInt(k++, worker.getPositionId());
			pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
	}

	public List<Worker> findWorker(Connection con) throws Exception {
		List<Worker> workerList = new ArrayList<Worker>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(Constants.SQL_SELECT_ALL_WORKERS);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				workerList.add(extractWorker(rs));
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
			throw new Exception();
		} finally {
			close(con, pstmt, rs);
		}
		return workerList;
	}

	public void updatetWorker(Connection con, Worker worker) throws SQLException {
		PreparedStatement pstmt = null;
		System.out.println("UpdateMethdod");
		try {
			pstmt = con.prepareStatement(Constants.SQL_UPDATE_WORKER);
			pstmt.setString(1, worker.getFirstName());
			pstmt.setString(2, worker.getLastName());
			pstmt.setInt(3, worker.getPositionId());
			pstmt.setInt(4, worker.getId());
			pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
	}

	public Worker findWorker(Connection con, int id) throws Exception {
		Worker worker = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(Constants.SQL_FIND_WORKER_BY_ID);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			System.out.println("FindMethdod");
			if (rs.next()) {
				worker = extractWorker(rs);
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
		} finally {
			close(con, pstmt, rs);
		}
		return worker;
	}

	public void deleteWorker(Connection con, int id) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Constants.SQL_DELETE_WORKER);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
	}

	public List<Worker> findPilot(Connection con) throws Exception {
		List<Worker> pilotList = new ArrayList<Worker>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(Constants.SQL_SELECT_ALL_PILOTS);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pilotList.add(extractWorker(rs));
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
			throw new Exception();
		} finally {
			close(con, pstmt, rs);
		}
		return pilotList;
	}

//
//	
	public List<Worker> findRadioOperator(Connection con) throws Exception {
		List<Worker> radioOperatorList = new ArrayList<Worker>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(Constants.SQL_SELECT_ALL_RADIO_OPERATORS);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				radioOperatorList.add(extractWorker(rs));
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
			throw new Exception();
		} finally {
			close(con, pstmt, rs);
		}
		return radioOperatorList;
	}

	public List<Worker> findStewardess(Connection con) throws Exception {
		List<Worker> stewardessList = new ArrayList<Worker>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(Constants.SQL_SELECT_ALL_STEWARDESSES);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				stewardessList.add(extractWorker(rs));
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
			throw new Exception();
		} finally {
			close(con, pstmt, rs);
		}
		return stewardessList;
	}

	public List<Worker> findNavigator(Connection con) throws Exception {
		List<Worker> navigatorsList = new ArrayList<Worker>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(Constants.SQL_SELECT_ALL_NAVIGATORS);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				navigatorsList.add(extractWorker(rs));
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
			throw new Exception();
		} finally {
			close(con, pstmt, rs);
		}
		return navigatorsList;
	}
	
	// Checking methods
	
	public Worker checkPilot(Connection con, Integer id) throws Exception {
		Worker worker = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			System.out.println("In DB method Pilot");
			con = getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(Constants.SQL_CHECK_PILOT);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				worker = extractWorker(rs);
//				Integer tmp = rs.getInt("id");
				System.out.println("In rs Pilot");
				if(worker.getId() == null) {
//					id = tmp;
					throw new Exception("Sorry. Pilot wasn`t found!");
					
				}
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
		} finally {
			close(con, pstmt, rs);
		}
		return worker;
	}
	
	public Worker checkNavigator(Connection con, int id) throws Exception {
		Worker worker = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			System.out.println("In DB method navigator");
			con = getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(Constants.SQL_CHECK_NAVIGATOR);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				worker = extractWorker(rs);
				if(worker == null) {
					throw new Exception("Sorry. Navigator wasn`t found!");
				}
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
		} finally {
			close(con, pstmt, rs);
		}
		return worker;
	}
	
	public Worker checkRadioOperator(Connection con, int id) throws Exception {
		Worker worker = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			System.out.println("In DB method radio operator");
			con = getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(Constants.SQL_CHECK_RADIO_OPERATOR);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				worker = extractWorker(rs);
				if(worker == null) {
					throw new Exception("Sorry. Radio operator wasn`t found!");
				}
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
		} finally {
			close(con, pstmt, rs);
		}
		return worker;
	}
	
	public Worker checkStewardess(Connection con, int id) throws Exception {
		Worker worker = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			System.out.println("In DB method stewardess");
			con = getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(Constants.SQL_CHECK_STEWARDESS);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				worker = extractWorker(rs);
				if(worker == null) {
					throw new Exception("Sorry. Stewardess wasn`t found!");
				}
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
		} finally {
			close(con, pstmt, rs);
		}
		return worker;
	}
	
	
	public Flight checkFlight(Connection con, Integer idF) throws Exception {
		Flight flight = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			System.out.println("Flight checkinggggggggggggggggg");
			pstmt = con.prepareStatement(Constants.SQL_FIND_FLIGHT_BY_ID);
			pstmt.setInt(1, idF);
			rs = pstmt.executeQuery();
			if (rs.next()) {
//				flight = extractFlight(rs);
				idF = rs.getInt("id");
				if(flight == null) {
					throw new Exception("Flight wasn`t found");
				}
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
		} finally {
			close(con, pstmt, rs);
		}
		return flight;
	}
	

	// Extract methods for each entity

	private User extractUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getLong(Fields.ENTITY_ID));
		user.setLogin(rs.getString(Fields.USER_LOGIN));
		user.setPassword(rs.getString(Fields.USER_PASSWORD));
		user.setFirstName(rs.getString(Fields.USER_FIRST_NAME));
		user.setLastName(rs.getString(Fields.USER_LAST_NAME));
		user.setRoleId(rs.getInt(Fields.USER_ROLE_ID));
		return user;
	}

	private Flight extractFlight(ResultSet rs) throws SQLException {
		Flight flight = new Flight();
		flight.setId(rs.getInt(Fields.FliGHT_ID));
		flight.setNumber(rs.getString(Fields.FliGHT_NUMBER));
		flight.setName(rs.getString(Fields.FliGHT_NAME));
		flight.setFrom(rs.getString(Fields.FliGHT_FROM));
		flight.setTo(rs.getString(Fields.FliGHT_TO));
		flight.setFlightDate(rs.getString(Fields.FliGHT_DATE));
		return flight;
	}

	private Worker extractWorker(ResultSet rs) throws SQLException {
		Worker worker = new Worker();
		worker.setId(rs.getInt(Fields.WORKER_ID));
		worker.setFirstName(rs.getString(Fields.WORKER_FIRST_NAME));
		worker.setLastName(rs.getString(Fields.WORKER_LAST_NAME));
		worker.setPositionId(rs.getInt(Fields.WORKER_POSITION));
		return worker;
	}

	private Crew extractCrew(ResultSet rs) throws SQLException {
		Crew crew = new Crew();
		crew.setId(rs.getInt(Fields.CREW_ID));
		crew.setId(rs.getInt(Fields.CREW_FLIGHTS_ID));
		crew.setId(rs.getInt(Fields.CREW_PILOT1));
		crew.setId(rs.getInt(Fields.CREW_PILOT2));
		crew.setId(rs.getInt(Fields.CREW_NAVIGATOR));
		crew.setId(rs.getInt(Fields.CREW_RADIO_OPERATOR));
		crew.setId(rs.getInt(Fields.CREW_STEWARDESS1));
		crew.setId(rs.getInt(Fields.CREW_STEWARDESS2));
		crew.setId(rs.getInt(Fields.CREW_STEWARDESS3));
		crew.setId(rs.getInt(Fields.CREW_STEWARDESS4));
		crew.setId(rs.getInt(Fields.CREW_STEWARDESS5));
		crew.setStatus(rs.getString(Fields.CREW_STATUS));

		return crew;
	}

	public void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException ex) {
			}
		}
	}

	private void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException ex) {
			}
		}
	}

	private void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {
			}
		}
	}

	private void close(Connection con, Statement stmt, ResultSet rs) {
		close(rs);
		close(stmt);
		close(con);
	}

	public void rollback(Connection con) {
		if (con != null) {
			try {
				con.rollback();
			} catch (SQLException ex) {
			}
		}
	}

}
