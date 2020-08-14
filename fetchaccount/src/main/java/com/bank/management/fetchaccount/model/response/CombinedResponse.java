package com.bank.management.fetchaccount.model.response;

public class CombinedResponse {

	public String account_number;
	public int account_balance;
	public String customer_name;
	public Integer customer_id;
	public String email_id;
	public Integer age;
	public String phone_number;
	public String Session_Status;
	
	public String ext_account_number;
	public int ext_account_balance;
	public String branch_name;
	
	public String getExt_account_number() {
		return ext_account_number;
	}
	public void setExt_account_number(String ext_account_number) {
		this.ext_account_number = ext_account_number;
	}
	public int getExt_account_balance() {
		return ext_account_balance;
	}
	public void setExt_account_balance(int ext_account_balance) {
		this.ext_account_balance = ext_account_balance;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getSession_Status() {
		return Session_Status;
	}
	public void setSession_Status(String session_Status) {
		Session_Status = session_Status;
	}
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public int getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(int account_balance) {
		this.account_balance = account_balance;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
}

