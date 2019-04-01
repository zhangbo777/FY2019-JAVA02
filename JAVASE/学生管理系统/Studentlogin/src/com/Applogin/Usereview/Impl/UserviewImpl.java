package com.Applogin.Usereview.Impl;
import java.util.Scanner;
import javax.security.auth.login.LoginException;

import com.Applogin.Applogin;
import com.Applogin.Userservice.Userservice;
import com.Applogin.Userservice.Impl.UserserviceImpl;
import com.Applogin.Userview.Userview;
import com.Applogin.pojo.Student;

public class UserviewImpl implements Userview{
	static Userservice uservice=new UserserviceImpl();
	static Userview userview = new UserviewImpl();
	 Applogin app = new Applogin();
	@Override
	public void Login() throws LoginException {
		System.out.println("欢迎登录");
		System.out.print("请输入用户名： ");
		Scanner s = new Scanner(System.in);
		String username = s.nextLine();
		boolean aa1 =uservice.Testusername(username);
		if(aa1) {
			System.out.print("请输入密码：");
			String password = s.nextLine();
			uservice.Testusername1(username, password);
		}
		
	}

	//查看学生信息
	@Override
	public void seeStudent() {
		System.out.print("id"+"\t");
		System.out.print("name"+"\t");
		System.out.print("sex"+"\t");
		System.out.print("age"+"\t");
		System.out.print("class"+"\t");
		System.out.print("address"+"\t");
		System.out.print("phone"+"\t\t");
		System.out.print("emil"+"\t\t");
		System.out.println("score"+"\t");
		uservice.seestudents();
		System.out.println("---------------------------------");
		System.out.print("1、成绩从低到高排序"+"\t");
		System.out.print("2、成绩从高到低排序"+"\t");
		System.out.println("3、返回上一层"+"\t");
		System.out.println("---------------------------------");
		System.out.print("请选择：");
		Scanner a = new Scanner(System.in);
		int num = a.nextInt();
		if(num==1) {
			uservice.sortscore();
		}else if(num==2){
			uservice.sortscore1();
		}else if(num==3) {
			app.operation2();
		}else {
			System.out.println("0.0");
			uservice.seestudents();
			
		}
			
		}

	//添加学生
	@Override
	public void addStudent() throws LoginException {
		System.out.print("请输入要填加学生的ID：");
		Scanner i = new Scanner(System.in);
		int id= i.nextInt();
		boolean testid=uservice.TestId(id);
		if(testid) {
			System.out.print("请输入要填加学生的姓名：");
			Scanner n = new Scanner(System.in);
			String name= n.nextLine();
			System.out.print("请输入要填加学生的性别：");
			Scanner s = new Scanner(System.in);
			String sex= s.nextLine();
			System.out.print("请输入要填加学生的年龄：");
			Scanner g = new Scanner(System.in);
			int age= g.nextInt();
			System.out.print("请输入要填加学生的班级：");
			Scanner c = new Scanner(System.in);
			String _class= c.nextLine();
			System.out.print("请输入要填加学生的住址：");
			Scanner d = new Scanner(System.in);
			String address= d.nextLine();		
			System.out.print("请输入要填加学生的电话：");
			Scanner p = new Scanner(System.in);
			String phone= p.nextLine();
			System.out.print("请输入要填加学生的邮箱：");
			Scanner e = new Scanner(System.in);
			String emil= e.nextLine();
			System.out.print("请输入要填加学生的成绩：");
			Scanner so = new Scanner(System.in);
			int score= so.nextInt();
			uservice.addstudent(id, name, sex, age, _class, address, phone, emil, score);
		}
		
		
	}
	//删除学生
	@Override
	public void deleStudent() throws LoginException {
		// TODO Auto-generated method stub
		System.out.print("请输入要填加学生的ID：");
		Scanner i = new Scanner(System.in);
		int id= i.nextInt();
		uservice.deleStudent(id);
		
	}

	//修改学生信息
	@Override
	public void modiStudent() throws LoginException {
		// TODO Auto-generated method stub
		System.out.println("--------------------------");
		System.out.print("1.根据Id修改学生全部信息"+"\t");
		System.out.print("2.根据Id修改学生部分信息"+"\t");
		System.out.print("3.返回上级目录"+"\t");
		System.out.println("4.系统退出"+"\t");
		System.out.println("--------------------------");
		System.out.print("请选择：");
		Scanner a = new Scanner(System.in);
		int num = a.nextInt();
		if(num==1) {
			System.out.print("请输入学号：");
			Scanner b = new Scanner(System.in);
			int num2 = b.nextInt();
			boolean teid1=uservice.Testid(num2);
			if(teid1) {
				int id = num2;
				uservice.idAllmodi(id);
			}
			modiStudent();
			
			}else if(num==2) {
			System.out.print("请输入学号：");
			Scanner b = new Scanner(System.in);
			int num1 = b.nextInt();
			boolean teid=uservice.Testid(num1);
			if(teid) {
				int id = num1;
				uservice.idmodi(id);
			}
			modiStudent();
		}else if(num==3) {
			app.operation2();
		}else if(num==4) {
			System.exit(0);
		}else {
			System.out.println("别瞎按");
			modiStudent();
		}
	}
	
	
		
	}
