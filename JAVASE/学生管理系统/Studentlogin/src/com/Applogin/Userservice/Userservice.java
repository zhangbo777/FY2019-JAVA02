package com.Applogin.Userservice;

import javax.security.auth.login.LoginException;

public interface Userservice {
    boolean Testusername(String username) throws LoginException ;
    void Testusername1(String username,String password) throws LoginException;
		// TODO Auto-generated method stub
	void seestudents();	
	boolean TestId(int id) throws LoginException;
	boolean Testid(int id) throws LoginException;
	void addstudent(int id,String name,String sex,int age,String  _class,String address,String phone,String emil,int score);
	void deleStudent(int id);
	void idAllmodi(int id) throws LoginException;
	void idmodi(int id) throws LoginException;
	void sortscore();
	void sortscore1();
	
}
