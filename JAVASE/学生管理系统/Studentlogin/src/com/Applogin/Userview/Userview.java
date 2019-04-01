package com.Applogin.Userview;

import javax.security.auth.login.LoginException;

public interface Userview {
	public void Login() throws LoginException ;
	public void seeStudent();
	public void addStudent() throws LoginException;
	public void deleStudent() throws LoginException;
	public void modiStudent()throws LoginException;
}
