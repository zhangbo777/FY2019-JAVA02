package com.neuedu.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Admin {
	public String username;//用户名
	public String password;//密码
	public long zhuce; //注册日期
	
	public Admin() {};
	public Admin(String username,String password){
		this.username=username;
		this.password=password;
	}
	/*public Admin(String username,String password,long date){
		this.username=username;
		this.password=password;
		this.zhuce=date;
	}*/
	
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}
}