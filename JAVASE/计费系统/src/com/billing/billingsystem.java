package com.billing;
import java.util.Scanner;

import com.billing.Exception.LoginException;
import com.billing.Exception.RegisterException;
import com.billing.pojo.User;
import com.billing.view.UserView;
import com.billing.view.impl.UserViewImpl;
public class billingsystem {

	public static void main(String[] args) {
		billingsystem app=new billingsystem();
		app.choise();
	
	}
	public void choise()  {
		System.out.println("------------------------------------------------");
		System.out.print("1.已有账号，马上登陆"+"\t\t");
		System.out.println("2.没有账号，马上注册");
		System.out.println("------------------------------------------------");
		System.out.print("请选择：");
		Scanner  s= new Scanner(System.in);
		UserView view = new UserViewImpl();
		int  num=s.nextInt();
		if(num==1) {//登陆
			try {
			view.login();	
			}catch(LoginException e) {
				String ex=e.getMessage();
				System.out.println(ex);
			}
		}else if(num==2){//注册
			try {
				view.register();
			}catch(RegisterException b) {
				String eb=b.getMessage();
				System.out.println(eb);
			};
			choise();
		}else {
			System.out.println("输入有误，请重新输入");
			choise();
		}
	}
	
}

