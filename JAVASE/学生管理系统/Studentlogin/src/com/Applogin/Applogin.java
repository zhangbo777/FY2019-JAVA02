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
		System.out.println("========��ӭʹ��========");
		System.out.println("1.��¼   2.�˳�");
		System.out.println("------------------------");
		
		}
	//��¼�����˳�
	public static void choise() throws LoginException {
		System.out.print("��ѡ��");
		Scanner s = new Scanner(System.in);
		int operation = s.nextInt();
		if(operation ==1){
			oper();
		}else if(operation==2){
			//�˳�
			System.exit(0);
		}else{
			System.out.print("������������������");
			choise();
		}
		
	}
	
	public static void operation2() {
		System.out.println("*****��ѡ��Ҫ��������Ϣ*****");
		System.out.print("1.�鿴ѧ����Ϣ"+"\t");
		System.out.print("2.���ѧ����Ϣ"+"\t");
		System.out.print("3.ɾ��ѧ����Ϣ"+"\t");
		System.out.println("4.�޸�ѧ����Ϣ"+"\t");
		System.out.println("5.�˳�"+"\t");
		Scanner s = new Scanner(System.in);
		System.out.print("������Ҫ�����ı�ţ�");
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
			System.out.println("������������������");
			operation2();
		}
	}
	
}

