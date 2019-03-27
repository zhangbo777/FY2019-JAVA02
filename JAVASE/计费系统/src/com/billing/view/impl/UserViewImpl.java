package com.billing.view.impl;

import java.util.Scanner;

import com.billing.billingsystem;
import com.billing.Exception.LoginException;
import com.billing.Exception.RegisterException;
import com.billing.pojo.User;
import com.billing.service.UserBiz;
import com.billing.service.impl.UserBizImpl;
import com.billing.view.UserView;

public class UserViewImpl implements UserView {
	UserBiz userbiz = new UserBizImpl();
	billingsystem app1=new billingsystem();
	@Override
	public void login() throws LoginException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.print("请输入用户名：");
		String username = s.nextLine();
		boolean aa1 =userbiz.Testusername(username);
		if(aa1) {
			System.out.print("请输入密码：");
			String password = s.nextLine();
			userbiz.login(username, password);
		}
		
		
		
	}

	@Override
	public void register() throws RegisterException{
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.print("用户名：");
		String username = s.nextLine();
		boolean ss=userbiz.Testusername1(username);
		if(ss) {
			System.out.print("密码：");
			String password = s.nextLine();
			boolean aa=userbiz.Testpassword2(password);
			if(aa) {
				System.out.print("确认密码：");
				String password2 = s.nextLine();
				boolean aaa=userbiz.Testpassword(password,password2);
				if(aaa) {
					System.out.print("真实姓名：");
					String name = s.nextLine();
					System.out.print("邮箱：");
					String emil = s.nextLine();
					userbiz.register(username, password, password2, name, emil);
				
				}
			}
			
		}else {}
			
			
		}
		
	}


