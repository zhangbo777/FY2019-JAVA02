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
			//获取查询的课程
			Course c=serviceResponse.getDate();
			//将课程添加到购物车
			courses.add(c);
			return ServiceResponse.ServiceResponsecreateSrBySucess();
		}
		
		return ServiceResponse.createSrByFail(30, "选择的课程不存在或者已经下架");
	}

}
