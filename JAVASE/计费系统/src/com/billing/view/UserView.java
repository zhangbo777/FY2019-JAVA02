package com.billing.view;

import com.billing.Exception.LoginException;
import com.billing.Exception.RegisterException;

public interface UserView {

	 public void  login() throws LoginException;
	 public void register()throws RegisterException;
	
}
