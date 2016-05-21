package com.nextech.dscrm.pojo;

import java.util.List;

public class UserRequest {
	private int userid;
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
		return mobilenumber ;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int string) {
		this.userid = string;
	}
	public static List<UserRequest> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
