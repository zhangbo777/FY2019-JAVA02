package com.neuedu.enumeration;

public class constant {
	//账号不可为空
	public static final int USERNAME_NO_NULL=11; 
	//用户名输入错误 - 用户名不存在
	public static final int USERNAME_ERROR=12; 
	//密码不能为空
	public static final int PASSWORD_NO_NULL=13; 
	//密码错误
	public static final int PASSWORD_ERROR=14;
	//课程已存在
	public static final int COURSE_SAME=15;
	//课程不存在
	public static final int COURSE_NULL=16;
	public static int getUsernameNoNull() {
		return USERNAME_NO_NULL;
	}
	public static int getUsernameError() {
		return USERNAME_ERROR;
	}
	public static int getPasswordNoNull() {
		return PASSWORD_NO_NULL;
	}
	public static int getPasswordError() {
		return PASSWORD_ERROR;
	}
	
	
}
