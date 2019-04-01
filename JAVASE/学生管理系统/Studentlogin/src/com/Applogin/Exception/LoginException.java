package com.Applogin.Exception;

public class LoginException extends Exception {
	public LoginException() {};
	
	public LoginException(LoginException ex) {
		super(ex);
	};

}
