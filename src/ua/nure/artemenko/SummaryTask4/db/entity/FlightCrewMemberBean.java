package ua.nure.artemenko.SummaryTask4.db.entity;

public class FlightCrewMemberBean {
	
	private String flightNumber;
	private String crewMemberFirstName;
	private String crewMemberLastName;
	private int crewMemberId;
	
	
	public FlightCrewMemberBean(String flightNumber, int crewMemberId) {
		super();
		this.flightNumber = flightNumber;
		this.crewMemberId = crewMemberId;
	}
	public FlightCrewMemberBean(String flightNumber, String crewMemberFirstName, String crewMemberLastName,
			int crewMemberId) {
		super();
		this.flightNumber = flightNumber;
		this.crewMemberFirstName = crewMemberFirstName;
		this.crewMemberLastName = crewMemberLastName;
		this.crewMemberId = crewMemberId;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getCrewMemberFirstName() {
		return crewMemberFirstName;
	}
	public void setCrewMemberFirstName(String crewMemberFirstName) {
		this.crewMemberFirstName = crewMemberFirstName;
	}
	public String getCrewMemberLastName() {
		return crewMemberLastName;
	}
	public void setCrewMemberLastName(String crewMemberLastName) {
		this.crewMemberLastName = crewMemberLastName;
	}
	public int getCrewMemberId() {
		return crewMemberId;
	}
	public void setCrewMemberId(int crewMemberId) {
		this.crewMemberId = crewMemberId;
	}

}
