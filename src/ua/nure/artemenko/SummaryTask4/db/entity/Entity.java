package ua.nure.artemenko.SummaryTask4.db.entity;

import java.io.Serializable;

public abstract class Entity implements Serializable{

	private static final long serialVersionUID = -3869667740011434232L;
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
