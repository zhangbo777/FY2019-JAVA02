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
	
	
	//��
	@Override
	public ServiceResponse addcourse(int cid, String cname) {
		// TODO Auto-generated method stub
		
		Course newcou= new Course(cid,cname);
		if(!Courses.containsKey(cid)) {
			Courses.put(newcou.getCid(), newcou);
			return ServiceResponse.createSrBySucess("��ӳɹ�", newcou);
		}
		return ServiceResponse.createSrByFail(constant.COURSE_SAME,"�γ̱���Ѵ���");
	}
	
	//ɾ
	@Override
	public ServiceResponse deletecourse(int cid) {
		// TODO Auto-generated method stub
		if(Courses.containsKey(cid)) {
			Courses.remove(cid);
			return ServiceResponse.ServiceResponsecreateSrBySucess();
		}
		return ServiceResponse.createSrByFail(constant.COURSE_NULL,"�γ̲�����");
	}
	
	//��
	@Override
	public ServiceResponse modicourse(int cid, String cname) {
		// TODO Auto-generated method stub
		
		if(Courses.containsKey(cid)) {
			Courses.get(cid).setCname(cname);
			return ServiceResponse.createSrBySucess("�޸ĳɹ�", Courses.get(cid));
		}
		return ServiceResponse.createSrByFail(constant.COURSE_NULL,"�γ̲�����");
	}
	
	//��
	@Override
	public ServiceResponse seecourse() {
		// TODO Auto-generated method stub
		
			return ServiceResponse.createSrBySucess("���ҵ�", Courses.values());
		
		
	}

	//����ĳ��
	public ServiceResponse FindbyId(int cid) {
		if(Courses.containsKey(cid)) {
			return ServiceResponse.createSrBySucess("chadao", Courses.get(cid));
			
		}
		return ServiceResponse.createSrByFail(35, "�ÿγ̲����ڻ����¼�");
	}
	public boolean isSucess() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	

}
