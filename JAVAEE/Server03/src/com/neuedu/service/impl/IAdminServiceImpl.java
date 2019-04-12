package com.neuedu.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.Cookie;

import java.util.Iterator;

import com.neuedu.enumeration.constant;
import com.neuedu.pojo.Admin;
import com.neuedu.pojo.ServiceResponse;
import com.neuedu.pojo.Student;
import com.neuedu.pojo.Admin;
import com.neuedu.pojo.Student;
import com.neuedu.service.IAdminService;

public class IAdminServiceImpl implements IAdminService {
	private static IAdminServiceImpl uservice;
	public synchronized static IAdminServiceImpl getuservice() {
		if(uservice==null) {
			uservice=new IAdminServiceImpl();
		}
		return uservice; 
		
	}
	
	Map<String,Admin> admins=new HashMap();
	Map<Integer,Student> students=new HashMap();
	public IAdminServiceImpl() {
		final  long date=System.currentTimeMillis();
		Admin admin = new Admin("admin","admin");
		Admin admin1 = new Admin("admin1","admin1");
		Admin admin2 = new Admin("admin2","admin2");
		admins.put(admin.getUsername(), admin);
		admins.put(admin1.getUsername(), admin);
		admins.put(admin2.getUsername(), admin);
		Student student1=new Student(1,"����","��",18,"�ͼ�","���","110","123@163.com",100);
		Student student2=new Student(2,"����","��",18,"�ͼ�","���","110","123@163.com",80);
		Student student3=new Student(3,"����","��",18,"�߼�","���","110","123@163.com",100);
		Student student4=new Student(4,"����","��",18,"�ͼ�","���","110","123@163.com",77);
		Student student5=new Student(5,"��","��",18,"�ͼ�","���","110","123@163.com",79);
		students.put(student1.getId(),student1);
		students.put(student2.getId(),student2);
		students.put(student3.getId(),student3);
		students.put(student4.getId(),student4);
		students.put(student5.getId(),student5);
	}
	
	
	//����˻����Ƿ����
	@Override
	public boolean Testusername(String username){
		// TODO Auto-generated method stub
		
		return admins.containsKey(username);
		
	}
	//���ѧ��Id�Ƿ����
	public boolean Testid(int username){
		// TODO Auto-generated method stub
		
		return students.containsKey(username);
		
	}
	//���ѧ�������Ƿ���ȷ
	public ServiceResponse Testup1(int username, String password) {
		// TODO Auto-generated method stub
		
		if(username==0) {
			return ServiceResponse.createSrByFail(constant.USERNAME_NO_NULL,"�û�������Ϊ��");
		}
		if(password==null||password.equals("")) {
			return ServiceResponse.createSrByFail(constant.PASSWORD_NO_NULL, "���벻��Ϊ��");
			
		}
		boolean test=Testid(username);
		if(test) {
			Student user=students.get(username);
			if(username==user.getId()) {
				if(password.equals(user.getPassword())) {
					return ServiceResponse.createSrBySucess("��¼�ɹ�",user);
					
				
				}else {
					return ServiceResponse.createSrByFail(11, "�������");
				}
			}
		}
			return ServiceResponse.createSrByFail(constant.USERNAME_ERROR, "�û���������");
		
		
	}
	//������Ա�����Ƿ���ȷ
	@Override
	public ServiceResponse<Admin> Testup(String username, String password) {
		// TODO Auto-generated method stub
		
		if(username==null||username.equals("")) {
			return ServiceResponse.createSrByFail(constant.USERNAME_NO_NULL,"�û�������Ϊ��");
		}
		if(password==null||password.equals("")) {
			return ServiceResponse.createSrByFail(constant.PASSWORD_NO_NULL, "���벻��Ϊ��");
			
		}
		boolean test=Testusername(username);
		if(test) {
			Admin user=admins.get(username);
			//if(username.equals(user.getUsername())) {
				if(password.equals(user.getPassword())) {
					return ServiceResponse.createSrBySucess("��¼�ɹ�",user);
					
				
				}else {
					return ServiceResponse.createSrByFail(11, "�������");
				}
			//}
		}else {
			return ServiceResponse.createSrByFail(constant.USERNAME_ERROR, "�û���������");
		}
	}
	//����Աע��
		@Override
	public ServiceResponse<Admin> Adduser(String username, String password) {
			// TODO Auto-generated method stub
			Admin newuser=new Admin(username,password);
			if(newuser.getUsername()==null||newuser.getUsername().equals("")) {
				ServiceResponse service=ServiceResponse.createSrByFail(constant.USERNAME_NO_NULL,"�û�������Ϊ��");
				return service;
			}
			if(newuser.getPassword()==null||newuser.getPassword().equals("")) {
				ServiceResponse service=ServiceResponse.createSrByFail(constant.PASSWORD_NO_NULL, "���벻��Ϊ��");
				return service;
				
			}
			if(!admins.containsKey(username)) {
				admins.put(newuser.getUsername(),newuser);
				return ServiceResponse.createSrBySucess("ע��ɹ�", newuser);
			}
			return ServiceResponse.createSrByFail(1, "ע��ʧ�ܣ����û��Ѵ���");
		}
	//ѧ���޸�����
		@Override
	public ServiceResponse<Student> Modipas(int username, String password) {
		// TODO Auto-generated method stub
			
			if(students.containsKey(username)) {
				students.get(username).setPassword(password);
				return ServiceResponse.ServiceResponsecreateSrBySucess();
			}
			
		return  ServiceResponse.createSrByFail(constant.USERNAME_ERROR, "�û���������");
	}
	
	
	
	
	
	
	//�鿴ȫ��ѧ��
	@Override
	public ServiceResponse seeall() {
		// TODO Auto-generated method stub
		
		
		return ServiceResponse.createSrBySucess("ad", students.values());
	}

	//�鿴ĳ��ѧ��
	@Override
	public ServiceResponse<Student> seeone(int id) {
		// TODO Auto-generated method stub
		Student stu=new Student();
		for(Entry<Integer, Student> str : students.entrySet()){

		    if(id==str.getKey()) {
		    	stu=str.getValue();
		    	
		    	return ServiceResponse.createSrBySucess("�Ѳ鵽", stu);
		    }

		}
		return null;
	
	}

	//���ѧ��
	@Override
	public ServiceResponse<Student> addstudent(int id, String name, String sex, int age, String _class, String address, String phone,
			String emil, int score) {
		// TODO Auto-generated method stub
		Student newstu=new Student(id,name,sex,age,_class,address,phone,emil,score);
		
		if(students.containsKey(id)) {
			
			return ServiceResponse.createSrByFail(40,"id�Ѵ���");
		}
		students.put(newstu.getId(),newstu);
		return ServiceResponse.createSrBySucess("��ӳɹ�", newstu);
	
	}

	//ɾ��ѧ��
	@Override
	public  ServiceResponse<Student>  delestudent(int id) {
		// TODO Auto-generated method stub
		if(students.containsKey(id)) {
			students.remove(id);
			return ServiceResponse.createSrBySucess("ɾ���ɹ�", students.get(id));
		}
		return ServiceResponse.createSrByFail(11, "ɾ��ʧ��");
	}

	//�޸�ѧ��
	@Override
	public ServiceResponse<Student> Modistudent(int id,String name) {
		// TODO Auto-generated method stub
		if(students.containsKey(id)) {
			students.get(id).setName(name);
			return ServiceResponse.createSrBySucess("�޸ĳɹ�", students.get(id));
		}
		return ServiceResponse.createSrByFail(111, "���޴���");
	}


	




	
	
}
