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
		System.out.print("1.�����˺ţ����ϵ�½"+"\t\t");
		System.out.println("2.û���˺ţ�����ע��");
		System.out.println("------------------------------------------------");
		System.out.print("��ѡ��");
		Scanner  s= new Scanner(System.in);
		UserView view = new UserViewImpl();
		int  num=s.nextInt();
		if(num==1) {//��½
			try {
			view.login();	
			}catch(LoginException e) {
				String ex=e.getMessage();
				System.out.println(ex);
			}
		}else if(num==2){//ע��
			try {
				view.register();
			}catch(RegisterException b) {
				String eb=b.getMessage();
				System.out.println(eb);
			};
			choise();
		}else {
			System.out.println("������������������");
			choise();
		}
	}
	
}

