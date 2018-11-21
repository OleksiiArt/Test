package ua.nure.artemenko.SummaryTask4.db.entity;

import java.io.Serializable;

public class Flight implements Serializable{

	private static final long serialVersionUID = 48527578994345712L;
	private int idF;
	private String number;
	private String name;
	private String from;
	private String to;
	private String flightDate;

	public Flight() {
	}
	

	public Flight(String number) {
		this.number = number;
	}


	public Flight(int idF) {
		super();
		this.idF = idF;
	}


	public Flight(String from, String to, String flightDate) {
		super();
		this.from = from;
		this.to = to;
		this.flightDate = flightDate;
	}


	public Flight(String number, String name, String from, String to, String flightDate) {
		super();
		this.number = number;
		this.name = name;
		this.from = from;
		this.to = to;
		this.flightDate = flightDate;
	}


	public Flight(int idF, String number, String name, String from, String to, String flightDate) {
		this.idF = idF;
		this.number = number;
		this.name = name;
		this.from = from;
		this.to = to;
		this.flightDate = flightDate;

	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}


	public int getIdF() {
		return idF;
	}


	public void setId(int idF) {
		this.idF = idF;
	}

}
