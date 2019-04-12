package com.neuedu.service;

import java.util.HashMap;
import java.util.Map;

import com.neuedu.pojo.Course;
import com.neuedu.pojo.ServiceResponse;

public interface ICourse {
	
	Map<Integer,Course> Courses=new HashMap();
	
	//添加课程
	public ServiceResponse addcourse(int cid,String cname);
	
	//删除课程
	public ServiceResponse deletecourse(int cid);
	
	//修改课程
	public ServiceResponse modicourse(int cid,String cname);
	
	//查询课程
	public ServiceResponse seecourse();

	
	
}
