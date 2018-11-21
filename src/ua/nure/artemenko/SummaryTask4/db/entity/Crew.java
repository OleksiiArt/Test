package ua.nure.artemenko.SummaryTask4.db.entity;

import java.io.Serializable;

public class Crew implements Serializable{
	
	private static final long serialVersionUID = -6298355888662804133L;
	
	
	private int id;
	private int flight;
	private int pilot1;
	private int pilot2;
	private int navigator;
	private int radio_operator;
	private int stewardess1;
	private int stewardess2;
	private int stewardess3;
	private int stewardess4;
	private int stewardess5;
	private String status;
	
	



	public Crew(String status) {
		super();
		this.status = status;
	}
	public Crew(int id, int flight, int pilot1, int pilot2, int navigator, int radio_operator, int stewardess1,
			int stewardess2, int stewardess3, int stewardess4, int stewardess5, String status) {
		super();
		this.id = id;
		this.flight = flight;
		this.pilot1 = pilot1;
		this.pilot2 = pilot2;
		this.navigator = navigator;
		this.radio_operator = radio_operator;
		this.stewardess1 = stewardess1;
		this.stewardess2 = stewardess2;
		this.stewardess3 = stewardess3;
		this.stewardess4 = stewardess4;
		this.stewardess5 = stewardess5;
		this.status = status;
	}
	public Crew() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFlight() {
		return flight;
	}
	public void setFlightId(int flight) {
		this.flight = flight;
	}
	public int getPilot1() {
		return pilot1;
	}
	public void setPilot1(int pilot1) {
		this.pilot1 = pilot1;
	}
	public int getPilot2() {
		return pilot2;
	}
	public void setPilot2(int pilot2) {
		this.pilot2 = pilot2;
	}
	public int getNavigator() {
		return navigator;
	}
	public void setNavigator(int navigator) {
		this.navigator = navigator;
	}
	public int getRadio_operator() {
		return radio_operator;
	}
	public void setRadio_operator(int radio_operator) {
		this.radio_operator = radio_operator;
	}
	public int getStewardess1() {
		return stewardess1;
	}
	public void setStewardess1(int stewardess1) {
		this.stewardess1 = stewardess1;
	}
	public int getStewardess2() {
		return stewardess2;
	}
	public void setStewardess2(int stewardess2) {
		this.stewardess2 = stewardess2;
	}
	public int getStewardess3() {
		return stewardess3;
	}
	public void setStewardess3(int stewardess3) {
		this.stewardess3 = stewardess3;
	}
	public int getStewardess4() {
		return stewardess4;
	}
	public void setStewardess4(int stewardess4) {
		this.stewardess4 = stewardess4;
	}
	public int getStewardess5() {
		return stewardess5;
	}
	public void setStewardess5(int stewardess5) {
		this.stewardess5 = stewardess5;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
