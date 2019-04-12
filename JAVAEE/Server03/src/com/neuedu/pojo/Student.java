package com.neuedu.pojo;

import com.neuedu.pojo.Student;

public class Student implements Comparable {
	public int id; //ѧ��
	public String name;	//����
	public String sex; //�Ա�
	public int age; //����
	public String _class; //�����༶
	public String address; //��ͥסַ
	public String phone;	//��ϵ�绰
	public String emil;		//�����ʼ�
	public int score; 	//�ɼ�
	public String password; //����
	public Student(){

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
		this.password=phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/*public long getZhuce(){
		return zhuce;
	}*/
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
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(o==null) {
			return 1;
		}
		return ((Student) o).getScore()-this.score;
	}
}
