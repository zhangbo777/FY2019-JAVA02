package com.neuedu.enumeration;

public enum Adminenum {
	ADMIN_LOGIN(1,"��¼"),
	ADMIN_REGISTER(2,"ע��"),
	ADMIN_EXIT(3,"�˳�"),
	ADMIN_STATI(4,"ͳ������"),
	COURSE_ADD(5,"��ӿγ�"),
	COURSE_DELETE(6,"ɾ���γ�"),
	COURSE_MODI(7,"�޸Ŀγ�"),
	COURSE_SEE(8,"��ѯ�γ�"),
	
	
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
