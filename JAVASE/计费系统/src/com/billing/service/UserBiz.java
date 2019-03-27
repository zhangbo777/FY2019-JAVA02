package com.billing.service;

import com.billing.Exception.LoginException;
import com.billing.Exception.RegisterException;

public interface  UserBiz {
	void register(String username, String password, String password2,
		    String name, String email) throws RegisterException;
	
	void login(String username, String password) throws LoginException;
	
	boolean Testusername(String username)throws LoginException;
	boolean Testpassword2(String password)throws RegisterException;
	boolean Testpassword(String passowrd1,String password2)throws RegisterException;
	boolean Testusername1(String username) throws RegisterException;
}
