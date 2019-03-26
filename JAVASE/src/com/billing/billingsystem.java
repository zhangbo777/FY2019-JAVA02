package com.billing;
import java.util.Scanner;
public class billingsystem {

	public static void main(String[] args) {
		User[] admins = new User[5];
		defaAdmin(admins);
		createAdmin s2 =new createAdmin();
		s2.register("admin","admin","admin","Administrator","admin@123.com");
		User n = new User();
		
		System.out.println("------------------------------------------------");
		System.out.print("1.已有账号，马上登陆"+"\t\t");
		System.out.println("2.没有账号，马上注册");
		System.out.println("------------------------------------------------");
	
	}
	public static void defaAdmin(User[] admins)  {
		User s=new User("admin","admin","Administrator","admin@123.com");
		admins[0]=s;
		User s1=new User("tom","cat","tomcat","tomcat@cat.com");
		admins[1]=s1;
		
	}
	
}
class  createAdmin implements UserBiz{
	User[] admins = new User[5];
	User s=new User("admin","admin","Administrator","admin@123.com");
	public void register(String username, String password, String password2,
		    String name, String email)throws RegisterException {
			for(int i =0;i<admins.length;i++) {
				if() {
					throw new RegisterException();
				}
			}
	};
	 public void login(String username, String password) throws LoginException{
		 
	 };
}
