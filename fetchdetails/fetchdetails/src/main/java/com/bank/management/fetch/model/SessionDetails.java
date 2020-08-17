package com.bank.management.fetch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SessionDetails {
	@Setter
	@Getter
	public String sessionStatus;
}
