package com.Applogin.Userservice.Impl;

import java.util.Scanner;

import javax.security.auth.login.LoginException;

import com.Applogin.Userservice.Userservice;
import com.Applogin.pojo.Admin;
import com.Applogin.pojo.Student;

public class UserserviceImpl implements Userservice{
	private Admin[] admins =new Admin[10];
	private Student[] students = new Student[10];
	public UserserviceImpl() {
		Admin admin = new Admin("admin","admin");
		admins[0]=admin;
		Admin admin1 = new Admin("admin1","admin1");
		admins[1]=admin1;
		Student student1=new Student(1,"����","��",18,"�ͼ�","���","110","123@163.com",100);
		students[0]=student1;
		Student student2=new Student(2,"����","��",18,"�ͼ�","���","110","123@163.com",80);
		students[1]=student2;
		Student student3=new Student(3,"����","��",18,"�߼�","���","110","123@163.com",92);
		students[2]=student3;
		Student student4=new Student(4,"����","��",18,"�ͼ�","���","110","123@163.com",77);
		students[3]=student4;
	}
	//����˺��Ƿ����
	public boolean Testusername(String username) throws LoginException {
		// TODO Auto-generated method stub
		for(int i =0;i<admins.length;i++) {
			Admin admin =admins[i];
			
			if(admin==null) {
				continue;
			}
			String _username=admin.getUsername();
			if(_username.equals(username)) {
				return true;
			}
		}
		
		throw new LoginException("�û�������");
		
	}
	//����˺Ŵ��� �����Ƿ���ȷ
	@Override
	public void Testusername1(String username, String password) throws LoginException {
		boolean usernameText = false;
		for(int i = 0;i<admins.length;i++) {
			Admin user=admins[i];
			if(admins[i]==null) {
				continue;
			}
			
			if(username.equals(admins[i].username)) {
				usernameText=true;
				if(password.equals(admins[i].password)) {
					System.out.println("��½�ɹ���");
				}else {
					throw new LoginException("����������벻��ȷ");
				}
			}
			
		}
		if(!usernameText) {
			throw new LoginException("�û�������");
		}
	}
	//�鿴ѧ�� ȫ����Ϣ 
	@Override
	public void seestudents() {
		for(int i=0;i<students.length;i++){
			if(students[i]==null) {
				continue;
			}else {
				System.out.print(students[i].id+"\t");
				System.out.print(students[i].name+"\t");
				System.out.print(students[i].sex+"\t");
				System.out.print(students[i].age+"\t");
				System.out.print(students[i]._class+"\t");
				System.out.print(students[i].address+"\t");
				System.out.print(students[i].phone+"\t\t");
				System.out.print(students[i].emil+"\t");
				System.out.println(students[i].score+"\t");
			}
		
	}
}
	//����Id�Ƿ��ظ�
	@Override
	public boolean TestId(int id) throws LoginException {
		// TODO Auto-generated method stub
		for(int i=0;i<students.length;i++){
			if(students[i]==null) {
				continue;
			}
			int _id = students[i].getId();
			if(id==_id) {
				throw new LoginException("Id�Ѵ��� ����������");
			}
		}
		return true;
	}
	//���ѧ����Ϣ
	@Override
	public void addstudent(int id, String name, String sex, int age, String _class, String address, String phone,
			String emil, int score) {
		// TODO Auto-generated method stub
		Student newstudent=new Student(id,name,sex,age,_class,address,phone,emil,score);
		students[id-1]=newstudent;
	}
	//ɾ��ѧ����Ϣ
	@Override
	public void deleStudent(int id) {
		// TODO Auto-generated method stub
		for(int i=0;i<students.length;i++){
			if(students[i]==null) {
				continue;
			}
			int _id = students[i].getId();
			if(id==_id) {
				students[i]=null;
			}
		}
	}
	//����Id�޸�ȫ��
	@Override
	public void idAllmodi(int id) throws LoginException  {
		// TODO Auto-generated method stub
		//Scanner a = new Scanner(System.in);
		//int num = a.nextInt();
		for (int i = 0; i < students.length; i++) {
			if(students[i]==null) {
				continue;
			}
			if(id==students[i].id) {
				System.out.print(students[i].id+"\t");
				System.out.print(students[i].name+"\t");
				System.out.print(students[i].sex+"\t");
				System.out.print(students[i].age+"\t");
				System.out.print(students[i]._class+"\t");
				System.out.print(students[i].address+"\t");
				System.out.print(students[i].phone+"\t");
				System.out.print(students[i].emil+"\t");
				System.out.println(students[i].score+"\t");
				System.out.print("�������޸ĺ�ѧ����������");
				Scanner n = new Scanner(System.in);
				String name= n.nextLine();
				students[i].setName(name);
				System.out.print("�������޸ĺ�ѧ�����Ա�");
				Scanner s1 = new Scanner(System.in);
				String sex= s1.nextLine();
				students[i].setSex(sex);
				System.out.print("�������޸ĺ�ѧ�������䣺");
				Scanner g = new Scanner(System.in);
				int age= g.nextInt();
				students[i].setAge(age);
				System.out.print("�������޸ĺ�ѧ���İ༶��");
				Scanner c = new Scanner(System.in);
				String _class= c.nextLine();
				students[i].set_Class(_class);
				System.out.print("�������޸ĺ�ѧ����סַ��");
				Scanner d = new Scanner(System.in);
				String address= d.nextLine();
				students[i].setAddress(address);
				System.out.print("�������޸ĺ�ѧ���ĵ绰��");
				Scanner p = new Scanner(System.in);
				String phone= p.nextLine();
				students[i].setPhone(phone);
				System.out.print("�������޸ĺ�ѧ�������䣺");
				Scanner e = new Scanner(System.in);
				String emil= e.nextLine();
				students[i].setEmil(emil);
				System.out.print("�������޸ĺ�ѧ���ĳɼ���");
				Scanner so = new Scanner(System.in);
				int score= so.nextInt();
				students[i].setScore(score);
				System.out.print(students[i].id+"\t");
				System.out.print(students[i].name+"\t");
				System.out.print(students[i].sex+"\t");
				System.out.print(students[i].age+"\t");
				System.out.print(students[i]._class+"\t");
				System.out.print(students[i].address+"\t");
				System.out.print(students[i].phone+"\t");
				System.out.print(students[i].emil+"\t");
				System.out.println(students[i].score+"\t");
				System.out.println("�޸ĳɹ�������");
			}
		}
		
	}
	//����id�޸Ĳ���
	@Override
	public void idmodi(int id) throws LoginException {
		// TODO Auto-generated method stub
		for (int i = 0; i < students.length; i++) {
			if(students[i]==null) {
				continue;
			}
			if(id==students[i].id) {
				System.out.print("������Ҫ�޸�ѧ������Ϣ���ͣ�");
				Scanner s1= new Scanner(System.in);
				String a = s1.nextLine();
				System.out.print("�������޸ĺ�ѧ������Ϣ��");
				String  b= s1.nextLine();
					if(a.equals("name")) {
						students[i].setName(b);
					}else if(a.equals("sex")) {
						
						students[i].setSex(b);
					}else if(a.equals("age")) {
					
						int d=Integer.valueOf(b);
						students[i].setAge(d);
					}else if(a.equals("class")) {
						
						students[i].set_Class(b);
					}else if(a.equals("address")) {
						
						students[i].setAddress(b);
					}else if(a.equals("phone")) {
						
						students[i].setPhone(b);
					}else if(a.equals("email")) {
					
						students[i].setEmil(b);
					}else if(a.equals("score")) {
						int d=Integer.valueOf(b);
						students[i].setScore(d);
					}
					else {
						throw new LoginException("û�и�����");
					}
					}	
					}
		System.out.println("�޸ĳɹ������Զ�������һ��");
	}
	//����Id�Ƿ����
	@Override
	public boolean Testid(int id) throws LoginException {
		// TODO Auto-generated method stub
		for(int i=0;i<students.length;i++){
			if(students[i]==null) {
				continue;
			}
			int _id = students[i].getId();
			if(id==_id) {
				return true;
			}
		}
		throw new LoginException("���޴���");
		
	}
	//�ɼ� С���� ����
	@Override
	public void sortscore() {
		// TODO Auto-generated method stub
		Student temp = new Student();
		for (int i = 0; i < students.length-1; i++) {
			if(students[i]==null) {
				continue;
			}
			for (int j = i+1; j < students.length; j++) {
				if(students[j]==null) {
					//j++;
					continue;
				}
				if(students[i].score>students[j].score) {
					temp=students[i];
					students[i]=students[j];
					students[j]=temp;
				}
			}
		}
	}
	//�ɼ� ��С����
	@Override
	public void sortscore1() {
		// TODO Auto-generated method stub
		Student temp = new Student();
		for (int i = 0; i < students.length-1; i++) {
			if(students[i]==null) {
				continue;
			}
			for (int j = i+1; j < students.length; j++) {
				if(students[j]==null) {
					//j++;
					continue;
				}
				if(students[i].score<students[j].score) {
					temp=students[i];
					students[i]=students[j];
					students[j]=temp;
				}
			}
		}
	}
	
	
}
