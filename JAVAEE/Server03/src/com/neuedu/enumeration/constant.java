package com.neuedu.enumeration;

public class constant {
	//�˺Ų���Ϊ��
	public static final int USERNAME_NO_NULL=11; 
	//�û���������� - �û���������
	public static final int USERNAME_ERROR=12; 
	//���벻��Ϊ��
	public static final int PASSWORD_NO_NULL=13; 
	//�������
	public static final int PASSWORD_ERROR=14;
	//�γ��Ѵ���
	public static final int COURSE_SAME=15;
	//�γ̲�����
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
