package com.neuedu.service;


import com.neuedu.pojo.Admin;
import com.neuedu.pojo.ServiceResponse;
import com.neuedu.pojo.Student;

public interface IAdminService {
	  boolean Testusername(String username);
	  boolean Testid(int username);
	  ServiceResponse<Admin> Testup(String username,String password) ;
	  ServiceResponse<Student> Modipas(int username,String password) ;
	  ServiceResponse<Student> Testup1(int username,String password) ;
	  ServiceResponse<Admin> Adduser(String username,String password) ;
	  ServiceResponse<Student> seeone(int id);
	  ServiceResponse<Student> seeall();
	  ServiceResponse<Student> addstudent(int id, String name, String sex, int age, String _class, String address, String phone, String emil,
				int score);
	  ServiceResponse<Student> delestudent(int id);
	  ServiceResponse<Student> Modistudent(int id,String name);
}
