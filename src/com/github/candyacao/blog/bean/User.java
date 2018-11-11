package com.github.candyacao.blog.bean;

public class User {
	private long id;
	private String name;
	private String password;
	private String gender;
	
	public User() {}
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public User(long id, String name, String password, String gender) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.gender = gender;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + name + ", password=" + password +  ", gender=" + gender + "]";
	}
		
}
