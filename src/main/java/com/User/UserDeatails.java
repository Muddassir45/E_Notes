package com.User;

public class UserDeatails {
	private int id;
	private String name;
	private String email;
	private String passsword;

	public UserDeatails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDeatails(String name, String email, String passsword) {
		super();
		this.name = name;
		this.email = email;
		this.passsword = passsword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasssword() {
		return passsword;
	}

	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
