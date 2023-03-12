package entity;//= package model

public class User {

	private String fullName;
	private String username;

	public User() {
	}

	public User(String fullName, String username) {
		this.fullName = fullName;
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
