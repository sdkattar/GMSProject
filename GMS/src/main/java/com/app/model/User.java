package com.app.model;

public class User {
private int userid;
private String name;
private String email;
private String phone;
private String password;
private int deptid;

public User() {
	super();
	// TODO Auto-generated constructor stub
}




public User(int userid, String name, String email, String phone, String password, int deptid) {
	super();
	this.userid = userid;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.password = password;
	this.deptid = deptid;
}





public User(String name, String email, String phone, String password) {
	super();
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.password = password;
}




public int getUserid() {
	return userid;
}




public void setUserid(int userid) {
	this.userid = userid;
}




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




public String getPhone() {
	return phone;
}




public void setPhone(String phone) {
	this.phone = phone;
}




public String getPassword() {
	return password;
}




public void setPassword(String password) {
	this.password = password;
}




public int getDeptid() {
	return deptid;
}




public void setDeptid(int deptid) {
	this.deptid = deptid;
}




@Override
public String toString() {
	return "User [userid=" + userid + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password="
			+ password + ", deptid=" + deptid + "]";
}







}
