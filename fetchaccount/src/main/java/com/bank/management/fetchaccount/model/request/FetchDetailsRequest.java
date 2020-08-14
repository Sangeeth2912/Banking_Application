package com.bank.management.fetchaccount.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FetchDetailsRequest {
	@Setter
	@Getter
	public String sessionStatus;
	@Setter
	@Getter
	public Integer customer_id;
	

}
