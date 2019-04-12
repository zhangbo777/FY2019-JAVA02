package com.neuedu.service;

import java.util.List;
import com.neuedu.pojo.Course;
import com.neuedu.pojo.ServiceResponse;

public interface ChoiceCourse {
	public ServiceResponse choiseCourse(int cid,List<Course> courses);
}
