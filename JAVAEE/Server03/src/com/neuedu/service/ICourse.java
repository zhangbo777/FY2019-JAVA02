package com.neuedu.service;

import java.util.HashMap;
import java.util.Map;

import com.neuedu.pojo.Course;
import com.neuedu.pojo.ServiceResponse;

public interface ICourse {
	
	Map<Integer,Course> Courses=new HashMap();
	
	//��ӿγ�
	public ServiceResponse addcourse(int cid,String cname);
	
	//ɾ���γ�
	public ServiceResponse deletecourse(int cid);
	
	//�޸Ŀγ�
	public ServiceResponse modicourse(int cid,String cname);
	
	//��ѯ�γ�
	public ServiceResponse seecourse();

	
	
}
