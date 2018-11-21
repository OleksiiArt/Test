package ua.nure.artemenko.SummaryTask4.db;

import ua.nure.artemenko.SummaryTask4.db.entity.Worker;

public enum Position {
	PILOT, NAVIGATOR, RADIO_OPERATOR, STEWARDESS;
	
	public static Position getPosition(Worker worker) {
		int positionId = worker.getPositionId();
		return Position.values()[positionId];
	}
	
	public String getName() {
		return name().toLowerCase();
	}
	
}
