package com.nextech.dscrm.pojo;

public class UserRequest {
	private String userid;
	private String name;
	private String email;
	private String  requerment;
	private String  mobilenumber;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRequerment() {
		return requerment;
	}
	public void setRequerment(String requerment) {
		this.requerment = requerment;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

}
