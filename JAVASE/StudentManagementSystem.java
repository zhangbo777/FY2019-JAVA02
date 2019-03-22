import java.util.Scanner;
public class StudentManagementSystem{
	
	public static void main(String[] args){
		welcome();
		
		Admin[] admins=new Admin[5];
		createAdmin(admins);
		operation(admins);
		operation2();
		Student[] stduents = new Student[2];
		createStudent(students);
	}
	
	public static void createAdmin(Admin[] admins){
		Admin admin = new Admin("zhang","bo");
		admins[0]=admin;
	}
	public static void createStudent(Student[] students){
		Student s0 = new Student(1,"张博","男",17,"精英二班","天津","123456","123456@163.com");
		Student s1 = new Student(2,"苏雅丽","女",18,"精英二班","天津","654321","654321@163.com");
		students[0]=s0;
		students[1]=s1;
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
		
		Scanner s = new Scanner(System.in);
		System.out.print("请输入用户名： ");
		String username = s.nextLine();
		System.out.print("请输入密码： ");
		String password = s.nextLine();
		for(int i =0; i<admins.length; i++){
			Admin admin = admins[i];
			if(admin == null){
				continue;
			}
			if(username.equals(admin.username)&&password.equals(admin.password)){
				System.out.println("登录成功，欢迎您 "+username);
				break;
			}
		}
	}
	
	public static void operation2(){
		System.out.println("*****请选择要操作的信息*****");
		System.out.print("1.查看学生信息"+"\t");
		System.out.print("2.添加学生信息"+"\t");
		System.out.print("3.删除学生信息"+"\t");
		System.out.println("4.修改学生信息"+"\t");
		Scanner s = new Scanner(System.in);
		System.out.print("请输入要操作的编号：");
		String num = s.nextLine();
		if(num.equals("1")){
			
		}else if(num.equals("2")){
			
		}else if(num.equals("3")){
			
		}else if(num.equals("4")){
			
		}else{
			System.out.print("输入有误，请重新输入");
			operation2();
		}
	}
	//查看学生信息
	
	
	
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
	public Student(int id,String name,String sex,int age,String _class,String address,String phone, String emil){
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