package com.bank.management.model.request;

public class UserRequest {
public Integer user_id;
public Integer getUser_id() {
	return user_id;
}
public void setUser_id(Integer user_id) {
	this.user_id = user_id;
}
public String user_name;
public String password;
public int status;

public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
}
