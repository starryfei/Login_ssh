package com.entity;

public class User {
	private Integer id;
	private String username;
	private String pwd;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public User(String username,String pwd) {
		this.username = username;
		this.pwd = pwd;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
}
