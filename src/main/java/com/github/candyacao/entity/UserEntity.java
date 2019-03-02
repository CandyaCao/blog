package com.github.candyacao.entity;

import java.io.Serializable;

import com.github.candyacao.enums.UserSexEnum;

public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String userName;
	private String passWord;
	private UserSexEnum userSex;
	private String nickName;

	public UserEntity() {
		super();
	}

	public UserEntity(String id, String userName, String passWord, UserSexEnum userSex, String nickName) {
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.userSex = userSex;
		this.nickName = nickName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public UserSexEnum getUserSex() {
		return userSex;
	}

	public void setUserSex(UserSexEnum userSex) {
		this.userSex = userSex;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "UserEntity{" +
				"id='" + id + '\'' +
				", userName='" + userName + '\'' +
				", passWord='" + passWord + '\'' +
				", userSex=" + userSex +
				", nickName='" + nickName + '\'' +
				'}';
	}
}