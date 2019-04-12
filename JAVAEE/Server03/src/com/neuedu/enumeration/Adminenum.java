package com.neuedu.enumeration;

public enum Adminenum {
	ADMIN_LOGIN(1,"登录"),
	ADMIN_REGISTER(2,"注册"),
	ADMIN_EXIT(3,"退出"),
	ADMIN_STATI(4,"统计人数"),
	COURSE_ADD(5,"添加课程"),
	COURSE_DELETE(6,"删除课程"),
	COURSE_MODI(7,"修改课程"),
	COURSE_SEE(8,"查询课程"),
	
	
	;
	public int operation;
	public String state;
	Adminenum(int operation,String state){
		this.operation=operation;
		this.state=state;
	}
	public int getOperation() {
		return operation;
	}
	public void setOperation(int operation) {
		this.operation = operation;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
