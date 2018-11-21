package ua.nure.artemenko.SummaryTask4.db.entity;

public class LoginBean extends Entity {

	private static final long serialVersionUID = 5046223927609864409L;
	private String login;
	private String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
