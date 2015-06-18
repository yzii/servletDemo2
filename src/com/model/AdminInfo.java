package com.model;
/**
 * AdminInfo
 * @author zy
 * 2015.06.16
 */

public class AdminInfo {
	private int admin_Id;
	private String admin_name;
	private String admin_pwd;
	private String head_portrait;
	
	public int getAdmin_Id() {
		return admin_Id;
	}
	public void setAdmin_Id(int admin_Id) {
		this.admin_Id = admin_Id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_pwd() {
		return admin_pwd;
	}
	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}
	public void setAdmin_head_portrait(String head_portrait){
		this.head_portrait=head_portrait;
	}
	public String getAdmin_head_portrait(){
		return head_portrait;
	}

}
