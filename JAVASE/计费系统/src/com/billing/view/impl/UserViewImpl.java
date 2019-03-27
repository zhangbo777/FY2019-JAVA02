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
		System.out.print("�������û�����");
		String username = s.nextLine();
		boolean aa1 =userbiz.Testusername(username);
		if(aa1) {
			System.out.print("���������룺");
			String password = s.nextLine();
			userbiz.login(username, password);
		}
		
		
		
	}

	@Override
	public void register() throws RegisterException{
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.print("�û�����");
		String username = s.nextLine();
		boolean ss=userbiz.Testusername1(username);
		if(ss) {
			System.out.print("���룺");
			String password = s.nextLine();
			boolean aa=userbiz.Testpassword2(password);
			if(aa) {
				System.out.print("ȷ�����룺");
				String password2 = s.nextLine();
				boolean aaa=userbiz.Testpassword(password,password2);
				if(aaa) {
					System.out.print("��ʵ������");
					String name = s.nextLine();
					System.out.print("���䣺");
					String emil = s.nextLine();
					userbiz.register(username, password, password2, name, emil);
				
				}
			}
			
		}else {}
			
			
		}
		
	}


