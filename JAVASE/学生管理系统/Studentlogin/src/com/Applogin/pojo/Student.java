package com.Applogin.pojo;

public class Student {
	public int id; //ѧ��
	public String name;	//����
	public String sex; //�Ա�
	public int age; //����
	public String _class; //�����༶
	public String address; //��ͥסַ
	public String phone;	//��ϵ�绰
	public String emil;		//�����ʼ�
	public int score;
	public Student(){
//		this.id=id;
//		this.name=name;
//		this.sex=sex;
//		this.age=age;
//		this._class=_class;
//		this.address=address;
//		this.phone=phone;
//		this.emil=emil;
	}
	public Student(int id,String name,String sex,int age,String  _class,String address,String phone,String emil,int score) {
		this.id=id;
		this.name=name;
		this.sex=sex;
		this.age=age;
		this._class=_class;
		this.address=address;
		this.phone=phone;
		this.emil=emil;
		this.score=score;
	}

	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
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
