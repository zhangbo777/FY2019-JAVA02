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
		Student s0 = new Student(1,"�Ų�","��",17,"��Ӣ����","���","123456","123456@163.com");
		Student s1 = new Student(2,"������","Ů",18,"��Ӣ����","���","654321","654321@163.com");
		students[0]=s0;
		students[1]=s1;
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
		
		Scanner s = new Scanner(System.in);
		System.out.print("�������û����� ");
		String username = s.nextLine();
		System.out.print("���������룺 ");
		String password = s.nextLine();
		for(int i =0; i<admins.length; i++){
			Admin admin = admins[i];
			if(admin == null){
				continue;
			}
			if(username.equals(admin.username)&&password.equals(admin.password)){
				System.out.println("��¼�ɹ�����ӭ�� "+username);
				break;
			}
		}
	}
	
	public static void operation2(){
		System.out.println("*****��ѡ��Ҫ��������Ϣ*****");
		System.out.print("1.�鿴ѧ����Ϣ"+"\t");
		System.out.print("2.���ѧ����Ϣ"+"\t");
		System.out.print("3.ɾ��ѧ����Ϣ"+"\t");
		System.out.println("4.�޸�ѧ����Ϣ"+"\t");
		Scanner s = new Scanner(System.in);
		System.out.print("������Ҫ�����ı�ţ�");
		String num = s.nextLine();
		if(num.equals("1")){
			
		}else if(num.equals("2")){
			
		}else if(num.equals("3")){
			
		}else if(num.equals("4")){
			
		}else{
			System.out.print("������������������");
			operation2();
		}
	}
	//�鿴ѧ����Ϣ
	
	
	
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