package com.neuedu.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.neuedu.enumeration.Adminenum;
import com.neuedu.enumeration.constant;
import com.neuedu.pojo.Course;
import com.neuedu.pojo.ServiceResponse;
import com.neuedu.service.ICourse;

public class ICourseImpl implements ICourse {
	public static ICourseImpl instan;
	public static ICourseImpl getinstan() {
		if(instan==null) {
			instan=new ICourseImpl();
		}
		return instan;
		
	}
	
	private ICourseImpl() {
		
	};
	
	
	//增
	@Override
	public ServiceResponse addcourse(int cid, String cname) {
		// TODO Auto-generated method stub
		
		Course newcou= new Course(cid,cname);
		if(!Courses.containsKey(cid)) {
			Courses.put(newcou.getCid(), newcou);
			return ServiceResponse.createSrBySucess("添加成功", newcou);
		}
		return ServiceResponse.createSrByFail(constant.COURSE_SAME,"课程编号已存在");
	}
	
	//删
	@Override
	public ServiceResponse deletecourse(int cid) {
		// TODO Auto-generated method stub
		if(Courses.containsKey(cid)) {
			Courses.remove(cid);
			return ServiceResponse.ServiceResponsecreateSrBySucess();
		}
		return ServiceResponse.createSrByFail(constant.COURSE_NULL,"课程不存在");
	}
	
	//改
	@Override
	public ServiceResponse modicourse(int cid, String cname) {
		// TODO Auto-generated method stub
		
		if(Courses.containsKey(cid)) {
			Courses.get(cid).setCname(cname);
			return ServiceResponse.createSrBySucess("修改成功", Courses.get(cid));
		}
		return ServiceResponse.createSrByFail(constant.COURSE_NULL,"课程不存在");
	}
	
	//查
	@Override
	public ServiceResponse seecourse() {
		// TODO Auto-generated method stub
		
			return ServiceResponse.createSrBySucess("已找到", Courses.values());
		
		
	}

	//查找某个
	public ServiceResponse FindbyId(int cid) {
		if(Courses.containsKey(cid)) {
			return ServiceResponse.createSrBySucess("chadao", Courses.get(cid));
			
		}
		return ServiceResponse.createSrByFail(35, "该课程不存在或已下架");
	}
	public boolean isSucess() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	

}
