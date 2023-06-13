package com.example.Bright.College.Portal.model;

public class SignUpForm {
	private int userId;
	private String name;
	private String email;
	private String password;
	
	public SignUpForm() {}
	
	public SignUpForm(int userId,String name,String email,String password) {
		this.setUserId(userId);
		this.setName(name);
		this.setEmail(email); 	
		this.setPassword(password);
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
