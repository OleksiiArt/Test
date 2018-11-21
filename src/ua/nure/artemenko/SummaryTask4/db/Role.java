package ua.nure.artemenko.SummaryTask4.db;

import ua.nure.artemenko.SummaryTask4.db.entity.User;

public enum Role {
	
ADMINISTRATOR, DISPATCHER;
	
	public static Role getRole(User user) {
		int roleId = user.getRoleId();
		return Role.values()[roleId];
	}
	
	public String getName() {
		return name().toLowerCase();
	}
	

}
