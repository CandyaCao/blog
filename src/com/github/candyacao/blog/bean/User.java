package com.github.candyacao.blog.bean;

public class User {
	private Long id;
	private String name;
	private String password;
	private String password2;
	private String gender;
	
	public User() {}
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public User(Long id, String name, String password, String password2, String gender) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.password2 = password2;
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + name + ", password=" + password + ", password2=" + password2
				+ ", gender=" + gender + "]";
	}
		
}
