package com.billing.pojo;

public class User  {
	public User() {
		
	}
	public User(String username,String password,String name,String emil) {
		this.username=username;
		this.password=password;
		this.name=name;
		this.emil=emil;
	}
	public String username;
	public String password;
	public String name;
	public String emil;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username=username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getEmil() {
		return emil;
	}
	public void setEmil(String emil) {
		this.emil=emil;
	}
}
