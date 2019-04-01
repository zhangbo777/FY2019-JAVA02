package com.Applogin;
import java.util.Scanner;
import javax.security.auth.login.LoginException;
import com.Applogin.Usereview.Impl.UserviewImpl;
import com.Applogin.Userview.Userview;

public class Applogin {
	static Userview view = new UserviewImpl();
	public static void main(String[] args) {
		welcome();
		try {
			choise();
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		operation2();
	}
	
	public static void oper() {
		//Userview view = new UserviewImpl();
		try {
			view.Login();
			
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			oper();
		}
		
	}
	public static void oper1() {
		try {
			view.addStudent();
			
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			oper1();
		}
		
	}
	public static void oper2() {
		try {
			view.deleStudent();
			
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			oper2();
		}
		
	}
	public static void oper3() {
		try {
			view.modiStudent();
			
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			oper3();
		}
		
	}
	public static void welcome(){
		System.out.println("========欢迎使用========");
		System.out.println("1.登录   2.退出");
		System.out.println("------------------------");
		
		}
	//登录或者退出
	public static void choise() throws LoginException {
		System.out.print("请选择：");
		Scanner s = new Scanner(System.in);
		int operation = s.nextInt();
		if(operation ==1){
			oper();
		}else if(operation==2){
			//退出
			System.exit(0);
		}else{
			System.out.print("输入有误，请重新输入");
			choise();
		}
		
	}
	
	public static void operation2() {
		System.out.println("*****请选择要操作的信息*****");
		System.out.print("1.查看学生信息"+"\t");
		System.out.print("2.添加学生信息"+"\t");
		System.out.print("3.删除学生信息"+"\t");
		System.out.println("4.修改学生信息"+"\t");
		System.out.println("5.退出"+"\t");
		Scanner s = new Scanner(System.in);
		System.out.print("请输入要操作的编号：");
		String num = s.nextLine();
		if(num.equals("1")){
			view.seeStudent();
			operation2();
		}else if(num.equals("2")){
			oper1();
			operation2();
		}else if(num.equals("3")){
			oper2();
			operation2();
		}else if(num.equals("4")){
			oper3();
			operation2();
		}else if(num.equals("5")){
			System.exit(0);
		}else{
			System.out.println("输入有误，请重新输入");
			operation2();
		}
	}
	
}

