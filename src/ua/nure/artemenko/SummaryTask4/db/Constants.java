package ua.nure.artemenko.SummaryTask4.db;

public class Constants {

	public static final String SQL_FIND_USER_BY_LOGIN = "SELECT login, password, role_id FROM users";
	
	
	public static final String SQL_INSERT_FLIGHT = "INSERT INTO flights VALUES (default, ?, ?, ?, ?, ?)";
	public static final String SQL_FIND_FLIGHTS = "SELECT * FROM flights";
	public static final String SQL_UPDATE_FLIGHT = "UPDATE flights SET number=?, name=?, from_city=?, to_city=?, flight_date=? WHERE id=?";
	public static final String SQL_FIND_FLIGHT_BY_NUMBER = "SELECT * FROM flights WHERE number=?";
	public static final String SQL_FIND_FLIGHT_BY_ID = "SELECT * FROM flights WHERE id=?";
	public static final String SQL_DELETE_FLIGHT = "DELETE FROM flights WHERE number=?";
	public static final String SQL_SELECT_ALL_FLIGHTS_BY_3_PARAM = "SELECT * FROM flights WHERE from=? AND to=? AND flight_date=?";
	public static final String SQL_SELECT_ALL_FLIGHTS = "SELECT id, number, name, from_city, to_city, flight_date FROM flights";
	
	
	
	public static final String SQL_SELECT_ALL_WORKERS_BY_ID = "SELECT * FROM workers WHERE id=?";
	public static final String SQL_SELECT_ALL_WORKERS = "SELECT * FROM workers";
	public static final String SQL_CREATE_WORKER= "INSERT INTO workers VALUES (default, ?, ?, ?)";
	public static final String SQL_DELETE_WORKER = "DELETE FROM workers WHERE id=?";
	public static final String SQL_FIND_WORKER_BY_ID = "SELECT * FROM workers WHERE id=?";
	public static final String SQL_UPDATE_WORKER = "UPDATE workers SET first_name=?, last_name=?, positions_id=? WHERE id=?";
	
	
	
	public static final String SQL_SELECT_ALL_PILOTS = "SELECT * FROM workers WHERE positions_id=1";
	public static final String SQL_SELECT_ALL_NAVIGATORS = "SELECT * FROM workers WHERE positions_id=2";
	public static final String SQL_SELECT_ALL_RADIO_OPERATORS = "SELECT * FROM workers WHERE positions_id=3";
	public static final String SQL_SELECT_ALL_STEWARDESSES = "SELECT * FROM workers WHERE positions_id=4";
	
	
	public static final String SQL_CREATE_CREW = "INSERT INTO crew VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String SQL_SELECT_ALL_CREWS = "SELECT id, flight, pilot1, pilot2, navigator, radio_operator, stewardess1, stewardess2, stewardess3, stewardess4, stewardess5 FROM crew";
//	public static final String SQL_SELECT_ALL_CREWS = "SELECT * FROM crew";
	
	public static final String SQL_CHECK_PILOT = "SELECT id FROM workers WHERE positions_id=1 AND id=?";
	public static final String SQL_CHECK_NAVIGATOR = "SELECT * FROM workers WHERE positions_id=2 AND id=?";
	public static final String SQL_CHECK_RADIO_OPERATOR = "SELECT * FROM workers WHERE positions_id=3 AND id=?";
	public static final String SQL_CHECK_STEWARDESS = "SELECT * FROM workers WHERE positions_id=4 AND id=?";
	public static final String SQL_CKECK_FLIGHT = "SELECT id FROM flights WHERE id=?";
	
	
	public static final String SQL_SET_CREW_MEMBER_FOR_FLIGHT = "INSERT into flights_workers (flights_id, workers_id) values(?, ?)";
//	public static final String SQL_SET_CREW_MEMBER_FOR_FLIGHT = "INSERT into flights_workers values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//	public static final String SQL_SET_CREW_MEMBER_FOR_FLIGHT = "INSERT into flights_workers(flights_id, workers_id) SELECT f.id, w.id FROM flights AS f, workers AS w WHERE f.flights.id=? AND w.workers.id=?";
//	public static final String SQL_SET_CREW_MEMBER_FOR_FLIGHT = "SELECT f.id, w.id FROM flights AS f, workers AS w WHERE f.flights.id=flights_workers.flights_id AND w.workers.id=flights_workers.workers_id AND flights.id=? AND workers.id=?";
	public static final String SQL_SELECT_CREW_MEMBER_FOR_FLIGHT = "SELECT f.id, w.id FROM flights AS f, workers AS w WHERE f.flights.id=? AND w.workers.id=?";
	


	
	
//	public static final String SQL_FIND_USER_BY_LOGIN_AND_PASSWORD = "SELECT * FROM users WHERE login=? and password=?";
	
//	public static final String SQL_SELECT_ALL_USERS = "SELECT a.Login, a.Password * FROM user_Accounts WHERE a.login=? and a.password=?";

//	public static final String SQL_SELECT_ALL_FLIGHTS_BY_NAME = "SELECT * FROM flights WHERE name=?";
//	public static final String SQL_SELECT_ALL_FLIGHTS_BY_FROM_TO_DATE = "SELECT * FROM flights WHERE from_city=? and to_city=? and flight_date=?";

	public Constants() {
	}
}
