package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.pojo.Course;
import com.neuedu.pojo.ServiceResponse;
import com.neuedu.service.ChoiceCourse;

public class ChoiseCourseImpl implements ChoiceCourse {

	@Override
	public ServiceResponse choiseCourse(int cid, List<Course> courses) {
		// TODO Auto-generated method stub
		ServiceResponse<Course> serviceResponse=ICourseImpl.getinstan().FindbyId(cid);
		
		if(serviceResponse.isSucess()) {
			//��ȡ��ѯ�Ŀγ�
			Course c=serviceResponse.getDate();
			//���γ���ӵ����ﳵ
			courses.add(c);
			return ServiceResponse.ServiceResponsecreateSrBySucess();
		}
		
		return ServiceResponse.createSrByFail(30, "ѡ��Ŀγ̲����ڻ����Ѿ��¼�");
	}

}
