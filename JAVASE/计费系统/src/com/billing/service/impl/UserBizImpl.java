package com.billing.service.impl;

import com.billing.Exception.LoginException;
import com.billing.Exception.RegisterException;
import com.billing.pojo.User;
import com.billing.service.UserBiz;

public class UserBizImpl implements UserBiz {
	private User[] users=new User[10];
	public UserBizImpl(){
		User s = new User("admin","admin","Administrator","admin@123.com");
		User s1 = new User("tom","cat","tomcat","tomcat@123.com");
		users[0]=s;
		users[1]=s1;
	}
	
	
	
	@Override
	public void register(String username, String password, String password2, String name, String email)
			throws RegisterException {
		// TODO Auto-generated method stub
		User user1 = new User();
		user1.username=username;
		user1.password=password;
		user1.name=name;
		user1.emil=email;
		for(int i = 0;i<users.length;i++) {
			User user = users[i];
			if(user == null) {
				user=user1;
				
			}
			System.out.println(user.name);
		}
		System.out.println("ע��ɹ���");
	}

	@Override
	public void login(String username, String password) throws LoginException {
		// TODO Auto-generated method stub
		boolean usernameText = false;
		for(int i = 0;i<users.length;i++) {
			User user=users[i];
			if(users[i]==null) {
				continue;
			}
			
			if(username.equals(users[i].username)) {
				usernameText=true;
				if(password.equals(users[i].password)) {
					System.out.print("��½�ɹ���");
				}else {
					throw new LoginException("����������벻��ȷ");
				}
			}
			
		}
		if(!usernameText) {
			throw new LoginException("�û�������");
		}
		
		
		
		
		
	}
	public boolean Testusername(String username) throws LoginException{
		for(int i =0;i<users.length;i++) {
			User user =users[i];
			
			if(user==null) {
				continue;
			}
			String _username=user.getUsername();
			if(_username.equals(username)) {
				return true;
				
			}
		}
		throw new LoginException("��������û���������");
		
	}
	public boolean Testusername1(String username) throws RegisterException{
		for(int i =0;i<users.length;i++) {
			User user =users[i];
			
			if(user==null) {
				continue;
			}
			String _username=user.getUsername();
			if(_username.equals(username)) {
				throw new RegisterException("��������û����Ѵ���");
				
			}
			
		}
		return true;	
	}


	@Override
	public boolean Testpassword2(String password) throws RegisterException {
		// TODO Auto-generated method stub
		if(password.length()==0) {
			throw new RegisterException("���벻��Ϊ��");
			
		}else {
			return true;
		}
		
	}
	
	



	@Override
	public boolean Testpassword(String passowrd1, String password2) throws RegisterException {
		// TODO Auto-generated method stub
		if(passowrd1.equals(password2)) {
			return true;
		}
		throw new RegisterException("���벻һ��");
	}



	
}
