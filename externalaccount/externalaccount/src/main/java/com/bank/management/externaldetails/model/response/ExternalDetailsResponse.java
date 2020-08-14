package com.bank.management.externaldetails.model.response;

public class ExternalDetailsResponse {
	public Integer customer_id;
	public String customer_name;
	public String password;
	public int status;
	public String session_token;
	public String ext_account_number;
	public int ext_account_balance;
	public String branch_name;
	public String status_code;
	public String getStatus_code() {
		return status_code;
	}
	public void setStatus_code(String status_code) {
		this.status_code = status_code;
	}
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
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
	public String getSession_token() {
		return session_token;
	}
	public void setSession_token(String session_token) {
		this.session_token = session_token;
	}
	
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
}
