package ua.nure.artemenko.SummaryTask4.db.entity;

import java.io.Serializable;

public class Worker implements Serializable{
	
	
	private static final long serialVersionUID = -5310401622272346563L;
	private Integer id;
	private String firstName;
	private String lastName;
	private int positionId;
	
		
	public Worker() {
		super();
	}
	
	
	
	public Worker(int id) {
		super();
		this.id = id;
	}



	public Worker(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public Worker(String firstName, String lastName, int positionId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.positionId = positionId;
	}


	public Worker(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public Worker(int id, String firstName, String lastName, int positionId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.positionId = positionId;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}


	@Override
	public String toString() {
		return "Worker [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", positionId=" + positionId
				+ "]";
	}

	
	
	
	
	
	
	

}
