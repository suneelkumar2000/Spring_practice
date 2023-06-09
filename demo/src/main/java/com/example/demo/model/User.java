package com.example.demo.model;

public class User {
	private String name;
	private String email;
	private Long phone;
	private String password;
	
	public User(){}
	public User(String name,String email,Long phone,String password) {
		this.name = name;
		this.email = email; 
		this.phone = phone;
		this.password=password;
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
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", phone=" + phone + ", password=" + password + "]";
	}
	
}
