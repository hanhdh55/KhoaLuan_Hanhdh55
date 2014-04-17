package com.model;

public class User {
	private int user_id;
	private String username;
	private String password;
	private String email;
	
	public User(int id, String name, String pass, String mail){
		user_id = id;
		username = name;
		password = pass;
		email = mail;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
