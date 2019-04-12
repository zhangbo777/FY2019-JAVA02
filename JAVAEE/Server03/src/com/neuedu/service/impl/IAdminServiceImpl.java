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
		Student student1=new Student(1,"张三","男",18,"低级","天津","110","123@163.com",100);
		Student student2=new Student(2,"李四","男",18,"低级","天津","110","123@163.com",80);
		Student student3=new Student(3,"王五","男",18,"高级","天津","110","123@163.com",100);
		Student student4=new Student(4,"刘六","男",18,"低级","天津","110","123@163.com",77);
		Student student5=new Student(5,"刘","男",18,"低级","天津","110","123@163.com",79);
		students.put(student1.getId(),student1);
		students.put(student2.getId(),student2);
		students.put(student3.getId(),student3);
		students.put(student4.getId(),student4);
		students.put(student5.getId(),student5);
	}
	
	
	//检测账户名是否存在
	@Override
	public boolean Testusername(String username){
		// TODO Auto-generated method stub
		
		return admins.containsKey(username);
		
	}
	//检测学生Id是否存在
	public boolean Testid(int username){
		// TODO Auto-generated method stub
		
		return students.containsKey(username);
		
	}
	//检测学生密码是否正确
	public ServiceResponse Testup1(int username, String password) {
		// TODO Auto-generated method stub
		
		if(username==0) {
			return ServiceResponse.createSrByFail(constant.USERNAME_NO_NULL,"用户名不可为空");
		}
		if(password==null||password.equals("")) {
			return ServiceResponse.createSrByFail(constant.PASSWORD_NO_NULL, "密码不可为空");
			
		}
		boolean test=Testid(username);
		if(test) {
			Student user=students.get(username);
			if(username==user.getId()) {
				if(password.equals(user.getPassword())) {
					return ServiceResponse.createSrBySucess("登录成功",user);
					
				
				}else {
					return ServiceResponse.createSrByFail(11, "密码错误");
				}
			}
		}
			return ServiceResponse.createSrByFail(constant.USERNAME_ERROR, "用户名不存在");
		
		
	}
	//检测管理员密码是否正确
	@Override
	public ServiceResponse<Admin> Testup(String username, String password) {
		// TODO Auto-generated method stub
		
		if(username==null||username.equals("")) {
			return ServiceResponse.createSrByFail(constant.USERNAME_NO_NULL,"用户名不可为空");
		}
		if(password==null||password.equals("")) {
			return ServiceResponse.createSrByFail(constant.PASSWORD_NO_NULL, "密码不可为空");
			
		}
		boolean test=Testusername(username);
		if(test) {
			Admin user=admins.get(username);
			//if(username.equals(user.getUsername())) {
				if(password.equals(user.getPassword())) {
					return ServiceResponse.createSrBySucess("登录成功",user);
					
				
				}else {
					return ServiceResponse.createSrByFail(11, "密码错误");
				}
			//}
		}else {
			return ServiceResponse.createSrByFail(constant.USERNAME_ERROR, "用户名不存在");
		}
	}
	//管理员注册
		@Override
	public ServiceResponse<Admin> Adduser(String username, String password) {
			// TODO Auto-generated method stub
			Admin newuser=new Admin(username,password);
			if(newuser.getUsername()==null||newuser.getUsername().equals("")) {
				ServiceResponse service=ServiceResponse.createSrByFail(constant.USERNAME_NO_NULL,"用户名不可为空");
				return service;
			}
			if(newuser.getPassword()==null||newuser.getPassword().equals("")) {
				ServiceResponse service=ServiceResponse.createSrByFail(constant.PASSWORD_NO_NULL, "密码不可为空");
				return service;
				
			}
			if(!admins.containsKey(username)) {
				admins.put(newuser.getUsername(),newuser);
				return ServiceResponse.createSrBySucess("注册成功", newuser);
			}
			return ServiceResponse.createSrByFail(1, "注册失败，该用户已存在");
		}
	//学生修改密码
		@Override
	public ServiceResponse<Student> Modipas(int username, String password) {
		// TODO Auto-generated method stub
			
			if(students.containsKey(username)) {
				students.get(username).setPassword(password);
				return ServiceResponse.ServiceResponsecreateSrBySucess();
			}
			
		return  ServiceResponse.createSrByFail(constant.USERNAME_ERROR, "用户名不存在");
	}
	
	
	
	
	
	
	//查看全部学生
	@Override
	public ServiceResponse seeall() {
		// TODO Auto-generated method stub
		
		
		return ServiceResponse.createSrBySucess("ad", students.values());
	}

	//查看某个学生
	@Override
	public ServiceResponse<Student> seeone(int id) {
		// TODO Auto-generated method stub
		Student stu=new Student();
		for(Entry<Integer, Student> str : students.entrySet()){

		    if(id==str.getKey()) {
		    	stu=str.getValue();
		    	
		    	return ServiceResponse.createSrBySucess("已查到", stu);
		    }

		}
		return null;
	
	}

	//添加学生
	@Override
	public ServiceResponse<Student> addstudent(int id, String name, String sex, int age, String _class, String address, String phone,
			String emil, int score) {
		// TODO Auto-generated method stub
		Student newstu=new Student(id,name,sex,age,_class,address,phone,emil,score);
		
		if(students.containsKey(id)) {
			
			return ServiceResponse.createSrByFail(40,"id已存在");
		}
		students.put(newstu.getId(),newstu);
		return ServiceResponse.createSrBySucess("添加成功", newstu);
	
	}

	//删除学生
	@Override
	public  ServiceResponse<Student>  delestudent(int id) {
		// TODO Auto-generated method stub
		if(students.containsKey(id)) {
			students.remove(id);
			return ServiceResponse.createSrBySucess("删除成功", students.get(id));
		}
		return ServiceResponse.createSrByFail(11, "删除失败");
	}

	//修改学生
	@Override
	public ServiceResponse<Student> Modistudent(int id,String name) {
		// TODO Auto-generated method stub
		if(students.containsKey(id)) {
			students.get(id).setName(name);
			return ServiceResponse.createSrBySucess("修改成功", students.get(id));
		}
		return ServiceResponse.createSrByFail(111, "查无此人");
	}


	




	
	
}
