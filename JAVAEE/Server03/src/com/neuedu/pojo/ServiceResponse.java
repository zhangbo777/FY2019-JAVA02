package com.neuedu.pojo;

import com.google.gson.Gson;

public class ServiceResponse<T> {
	
	
	private int status;
	private String msg;
	private T date;
	
	private ServiceResponse(int status) {
		super();
		this.status = status;
	}

	private ServiceResponse(int status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}

	private ServiceResponse(int status, T date) {
		super();
		this.status = status;
		this.date = date;
	}

	private ServiceResponse(int status, String msg, T date) {
		super();
		this.status = status;
		this.msg = msg;
		this.date = date;
	}
	
	/**
	 * 
	 * 判断接口是否调用成功
	 * 
	 * */
	public  boolean isSucess() {
		return this.status==0;
	}
	
	public static  ServiceResponse ServiceResponsecreateSrBySucess(){
		
		
		return new ServiceResponse(0);
	}
	
	public static ServiceResponse createSrBySucess(String msg){
		
		
		return new ServiceResponse(0,msg);
	}
	
	public static <T> ServiceResponse<T> createSrBySucess(String msg,T date){
		
		
		return new ServiceResponse<T>(0,msg,date);
	}
	public static ServiceResponse createSrByFail(int status){
		
		
		return new ServiceResponse(status);
	}
	public static ServiceResponse createSrByFail(int status,String msg){
		
		
		return new ServiceResponse(status,msg);
	}
	
	
	
	public String objtostr() {
		Gson gson=new Gson();
		
		String responseText =gson.toJson(this);
		return responseText;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getDate() {
		return date;
	}

	public void setDate(T date) {
		this.date = date;
	}


	
}
