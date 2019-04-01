package com.neuedu;

import java.util.Scanner;

public class StudentManagementSystem{
	
	public static void main(String[] args) {
		welcome();
		
		Admin[] admins=new Admin[5];
		createAdmin(admins);
		operation(admins);
		Student[] stduents = new Student[30];
		createStudent(stduents);
		operation2(stduents);
		
	}
	
	public static void createAdmin(Admin[] admins){
		Admin admin = new Admin("zhang","bo");
		admins[0]=admin;
		Admin admin1 = new Admin("admin","admin1");
		admins[1]=admin1;
	}
	public static void createStudent(Student[] students){
		/*Student s0 = new Student(1,"�Ų�","��",17,"��Ӣ����","���","123456","123456@163.com");
		Student s1 = new Student(2,"������","Ů",18,"��Ӣ����","���","654321","654321@163.com");
		students[0]=s0;
		students[1]=s1;*/
	}
	public static void welcome(){
		System.out.println("========��ӭʹ��========");
		System.out.println("1.��¼   2.�˳�");
		System.out.println("------------------------");
	}
	
	public static void operation(Admin[] admins){
		System.out.print("��ѡ��");
		Scanner s = new Scanner(System.in);
		int operation = s.nextInt();
		
		if(operation ==1){
			//��¼
			Login(admins);
		}else if(operation==2){
			//�˳�
			System.exit(0);
		}else{
			System.out.print("������������������");
			operation(admins);
		}
		
		
	}
	
	public static void Login(Admin[] admins){
		System.out.println("��ӭ��¼");
		
		
		System.out.print("�������û����� ");
		Scanner s = new Scanner(System.in);
		String username = s.nextLine();
		System.out.print("���������룺 ");
		String password = s.nextLine();
		for(int i =0; i<admins.length; i++){
			Admin admin = admins[i];
			if(admin == null){
				continue;
			}
			if(username.equals(admin.username)&&password.equals(admin.password)){
				System.out.println("��¼�ɹ�����ӭ�� "+admin.username);
				break;
			}else{
				System.out.println("�������������������������");
				Login(admins);
			}
		}
	}
	
	public static void operation2(Student[] students) {
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
			ViewStudentInformation(students);
			operation2(students);
		}else if(num.equals("2")){
			addStudent(students);
			operation2(students);
		}else if(num.equals("3")){
			deleStudent(students);
			operation2(students);
		}else if(num.equals("4")){
			modiStudent(students);
			operation2(students);
		}else if(num.equals("5")){
			System.exit(0);
		}else{
			System.out.println("������������������");
			operation2(students);
		}
	}
	//�鿴ѧ����Ϣ
	
	public static void ViewStudentInformation(Student[] students) {
		System.out.print("id"+"\t");
		System.out.print("name"+"\t");
		System.out.print("sex"+"\t");
		System.out.print("age"+"\t");
		System.out.print("class"+"\t");
		System.out.print("address"+"\t");
		System.out.print("phone"+"\t");
		System.out.println("emil"+"\t");
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
				System.out.print(students[i].phone+"\t");
				System.out.println(students[i].emil+"\t");
			}
			
		}
		
	}
	
	//���ѧ��
	
	public static void addStudent(Student[] students){
		Student a = new Student();
		System.out.print("������Ҫ���ѧ����ID��");
		Scanner i = new Scanner(System.in);
		int id= i.nextInt();
		a.id=id;
		for(int j =0;j<students.length;j++) {
			if(students[j]==null) {
				continue;
			}
			if(a.id==students[j].id) {
				System.out.println("*****ѧ���ظ�������������*****");
				addStudent(students);
				return;
			}
		}
		System.out.print("������Ҫ���ѧ����������");
		Scanner n = new Scanner(System.in);
		String name= n.nextLine();
		a.name=name;
		System.out.print("������Ҫ���ѧ�����Ա�");
		Scanner s = new Scanner(System.in);
		String sex= s.nextLine();
		a.sex=sex;
		System.out.print("������Ҫ���ѧ�������䣺");
		Scanner g = new Scanner(System.in);
		int age= g.nextInt();
		a.age=age;
		System.out.print("������Ҫ���ѧ���İ༶��");
		Scanner c = new Scanner(System.in);
		String _class= c.nextLine();
		a._class=_class;
		System.out.print("������Ҫ���ѧ����סַ��");
		Scanner d = new Scanner(System.in);
		String address= d.nextLine();
		a.address=address;
		System.out.print("������Ҫ���ѧ���ĵ绰��");
		Scanner p = new Scanner(System.in);
		String phone= p.nextLine();
		a.phone=phone;
		System.out.print("������Ҫ���ѧ�������䣺");
		Scanner e = new Scanner(System.in);
		String emil= e.nextLine();
		a.emil=emil;
		students[id-1]=a;
	}
	
	//ɾ��ѧ����Ϣ
	public static void deleStudent(Student[] students) {
		System.out.print("������Ҫɾ��ѧ����������");
		Scanner a =new Scanner(System.in);
		String name = a.nextLine();
		for(int j =0;j<students.length;j++) {
			if(students[j]==null) {
				continue;
			}
			if( name.equals(students[j].name)) {
				students[j]=null;
			}
		}
	}
	
	//�޸�ѧ����Ϣ
	public static void modiStudent(Student[] students) {
		System.out.println("--------------------------");
		System.out.print("1.����Id�޸�ѧ��ȫ����Ϣ"+"\t");
		System.out.print("2.����Id�޸�ѧ��������Ϣ"+"\t");
		System.out.print("3.�����ϼ�Ŀ¼"+"\t");
		System.out.println("4.ϵͳ�˳�"+"\t");
		System.out.println("--------------------------");
		System.out.print("��ѡ��");
		Scanner a = new Scanner(System.in);
		int num = a.nextInt();
		switch (num) {
		case 1:
		}
		
	}
	public static void idmodi(Student[] students) {
		Scanner s= new Scanner(System.in);
		System.out.print("������Ҫ�޸�ѧ����ID��");
		int num = s.nextInt();
		for(int i = 0;i<students.length;i++) {
			
		}
	}
	
}







class Admin{
	public String username;//�û���
	public String password;//����
	
	public Admin(String username,String password){
		this.username=username;
		this.password=password;
	}
	
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}
}






class Student{
	public int id; //ѧ��
	public String name;	//����
	public String sex; //�Ա�
	public int age; //����
	public String _class; //�����༶
	public String address; //��ͥסַ
	public String phone;	//��ϵ�绰
	public String emil;		//�����ʼ�
	public Student(){
		this.id=id;
		this.name=name;
		this.sex=sex;
		this.age=age;
		this._class=_class;
		this.address=address;
		this.phone=phone;
		this.emil=emil;
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id= id;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getSex(){
		return sex;
	}
	public void setSex(String sex){
		this.sex = sex;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
	public String get_Class(){
		return _class;
	}
	public void set_Class(String _class){
		this._class = _class;
	}
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public String getPhone(){
		return phone;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public String getEmil(){
		return emil;
	}
	public void setEmil(String emil){
		this.emil = emil;
	}
	
	
	
}