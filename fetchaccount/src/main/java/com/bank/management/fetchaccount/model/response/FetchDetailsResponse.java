package com.bank.management.fetchaccount.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FetchDetailsResponse {
	@Setter
	@Getter
	public String sessionStatus;
	@Setter
	@Getter
	public String customer_name;
	@Setter
	@Getter
	public Integer customer_id;
	@Setter
	@Getter
	public String email_id;
	@Setter
	@Getter
	public Integer age;
	@Setter
	@Getter
	public String phone_number;
	@Setter
	@Getter
	public int status;
	@Setter
	@Getter
	public String Status_code;
	
	
}
