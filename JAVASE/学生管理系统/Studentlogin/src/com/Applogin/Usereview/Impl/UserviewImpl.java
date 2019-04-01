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
		System.out.println("��ӭ��¼");
		System.out.print("�������û����� ");
		Scanner s = new Scanner(System.in);
		String username = s.nextLine();
		boolean aa1 =uservice.Testusername(username);
		if(aa1) {
			System.out.print("���������룺");
			String password = s.nextLine();
			uservice.Testusername1(username, password);
		}
		
	}

	//�鿴ѧ����Ϣ
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
		System.out.print("1���ɼ��ӵ͵�������"+"\t");
		System.out.print("2���ɼ��Ӹߵ�������"+"\t");
		System.out.println("3��������һ��"+"\t");
		System.out.println("---------------------------------");
		System.out.print("��ѡ��");
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

	//���ѧ��
	@Override
	public void addStudent() throws LoginException {
		System.out.print("������Ҫ���ѧ����ID��");
		Scanner i = new Scanner(System.in);
		int id= i.nextInt();
		boolean testid=uservice.TestId(id);
		if(testid) {
			System.out.print("������Ҫ���ѧ����������");
			Scanner n = new Scanner(System.in);
			String name= n.nextLine();
			System.out.print("������Ҫ���ѧ�����Ա�");
			Scanner s = new Scanner(System.in);
			String sex= s.nextLine();
			System.out.print("������Ҫ���ѧ�������䣺");
			Scanner g = new Scanner(System.in);
			int age= g.nextInt();
			System.out.print("������Ҫ���ѧ���İ༶��");
			Scanner c = new Scanner(System.in);
			String _class= c.nextLine();
			System.out.print("������Ҫ���ѧ����סַ��");
			Scanner d = new Scanner(System.in);
			String address= d.nextLine();		
			System.out.print("������Ҫ���ѧ���ĵ绰��");
			Scanner p = new Scanner(System.in);
			String phone= p.nextLine();
			System.out.print("������Ҫ���ѧ�������䣺");
			Scanner e = new Scanner(System.in);
			String emil= e.nextLine();
			System.out.print("������Ҫ���ѧ���ĳɼ���");
			Scanner so = new Scanner(System.in);
			int score= so.nextInt();
			uservice.addstudent(id, name, sex, age, _class, address, phone, emil, score);
		}
		
		
	}
	//ɾ��ѧ��
	@Override
	public void deleStudent() throws LoginException {
		// TODO Auto-generated method stub
		System.out.print("������Ҫ���ѧ����ID��");
		Scanner i = new Scanner(System.in);
		int id= i.nextInt();
		uservice.deleStudent(id);
		
	}

	//�޸�ѧ����Ϣ
	@Override
	public void modiStudent() throws LoginException {
		// TODO Auto-generated method stub
		System.out.println("--------------------------");
		System.out.print("1.����Id�޸�ѧ��ȫ����Ϣ"+"\t");
		System.out.print("2.����Id�޸�ѧ��������Ϣ"+"\t");
		System.out.print("3.�����ϼ�Ŀ¼"+"\t");
		System.out.println("4.ϵͳ�˳�"+"\t");
		System.out.println("--------------------------");
		System.out.print("��ѡ��");
		Scanner a = new Scanner(System.in);
		int num = a.nextInt();
		if(num==1) {
			System.out.print("������ѧ�ţ�");
			Scanner b = new Scanner(System.in);
			int num2 = b.nextInt();
			boolean teid1=uservice.Testid(num2);
			if(teid1) {
				int id = num2;
				uservice.idAllmodi(id);
			}
			modiStudent();
			
			}else if(num==2) {
			System.out.print("������ѧ�ţ�");
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
			System.out.println("��Ϲ��");
			modiStudent();
		}
	}
	
	
		
	}
