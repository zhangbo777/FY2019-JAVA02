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
		/*Student s0 = new Student(1,"张博","男",17,"精英二班","天津","123456","123456@163.com");
		Student s1 = new Student(2,"苏亚丽","女",18,"精英二班","天津","654321","654321@163.com");
		students[0]=s0;
		students[1]=s1;*/
	}
	public static void welcome(){
		System.out.println("========欢迎使用========");
		System.out.println("1.登录   2.退出");
		System.out.println("------------------------");
	}
	
	public static void operation(Admin[] admins){
		System.out.print("请选择：");
		Scanner s = new Scanner(System.in);
		int operation = s.nextInt();
		
		if(operation ==1){
			//登录
			Login(admins);
		}else if(operation==2){
			//退出
			System.exit(0);
		}else{
			System.out.print("输入有误，请重新输入");
			operation(admins);
		}
		
		
	}
	
	public static void Login(Admin[] admins){
		System.out.println("欢迎登录");
		
		
		System.out.print("请输入用户名： ");
		Scanner s = new Scanner(System.in);
		String username = s.nextLine();
		System.out.print("请输入密码： ");
		String password = s.nextLine();
		for(int i =0; i<admins.length; i++){
			Admin admin = admins[i];
			if(admin == null){
				continue;
			}
			if(username.equals(admin.username)&&password.equals(admin.password)){
				System.out.println("登录成功，欢迎您 "+admin.username);
				break;
			}else{
				System.out.println("您输入的密码有误请重新输入");
				Login(admins);
			}
		}
	}
	
	public static void operation2(Student[] students) {
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
			System.out.println("输入有误，请重新输入");
			operation2(students);
		}
	}
	//查看学生信息
	
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
	
	//添加学生
	
	public static void addStudent(Student[] students){
		Student a = new Student();
		System.out.print("请输入要填加学生的ID：");
		Scanner i = new Scanner(System.in);
		int id= i.nextInt();
		a.id=id;
		for(int j =0;j<students.length;j++) {
			if(students[j]==null) {
				continue;
			}
			if(a.id==students[j].id) {
				System.out.println("*****学号重复，请重新输入*****");
				addStudent(students);
				return;
			}
		}
		System.out.print("请输入要填加学生的姓名：");
		Scanner n = new Scanner(System.in);
		String name= n.nextLine();
		a.name=name;
		System.out.print("请输入要填加学生的性别：");
		Scanner s = new Scanner(System.in);
		String sex= s.nextLine();
		a.sex=sex;
		System.out.print("请输入要填加学生的年龄：");
		Scanner g = new Scanner(System.in);
		int age= g.nextInt();
		a.age=age;
		System.out.print("请输入要填加学生的班级：");
		Scanner c = new Scanner(System.in);
		String _class= c.nextLine();
		a._class=_class;
		System.out.print("请输入要填加学生的住址：");
		Scanner d = new Scanner(System.in);
		String address= d.nextLine();
		a.address=address;
		System.out.print("请输入要填加学生的电话：");
		Scanner p = new Scanner(System.in);
		String phone= p.nextLine();
		a.phone=phone;
		System.out.print("请输入要填加学生的邮箱：");
		Scanner e = new Scanner(System.in);
		String emil= e.nextLine();
		a.emil=emil;
		students[id-1]=a;
	}
	
	//删除学生信息
	public static void deleStudent(Student[] students) {
		System.out.print("请输入要删除学生的姓名：");
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
	
	//修改学生信息
	public static void modiStudent(Student[] students) {
		System.out.println("--------------------------");
		System.out.print("1.根据Id修改学生全部信息"+"\t");
		System.out.print("2.根据Id修改学生部分信息"+"\t");
		System.out.print("3.返回上级目录"+"\t");
		System.out.println("4.系统退出"+"\t");
		System.out.println("--------------------------");
		System.out.print("请选择：");
		Scanner a = new Scanner(System.in);
		int num = a.nextInt();
		switch (num) {
		case 1:
		}
		
	}
	public static void idmodi(Student[] students) {
		Scanner s= new Scanner(System.in);
		System.out.print("请输入要修改学生的ID：");
		int num = s.nextInt();
		for(int i = 0;i<students.length;i++) {
			
		}
	}
	
}







class Admin{
	public String username;//用户名
	public String password;//密码
	
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
	public int id; //学号
	public String name;	//姓名
	public String sex; //性别
	public int age; //年龄
	public String _class; //所属班级
	public String address; //家庭住址
	public String phone;	//联系电话
	public String emil;		//电子邮件
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