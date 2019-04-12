package com.neuedu.pojo;

public class Course {
	public int cid;
	public String cname;
	public Course(int cid, String cname) {
		// TODO Auto-generated constructor stub
		this.cid=cid;
		this.cname=cname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
