package com.bank.management.fetch.fetchdetails;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.bank.management.fetch.client.SessionInterface;
import com.bank.management.fetch.model.SessionDetails;
@Component
@RestController
@Service
@Resource
@ComponentScan({"com.bank.management.fetch"})
public class FetchAccDetailsController 
{
	@Autowired SessionInterface sessionInfo;
	@PostMapping(value = "/fetchExtDetails", consumes = "application/json", produces = "application/json")
	public ResponseEntity<SessionDetails> fetchAccountDetails(@RequestHeader(value="Authorization") String token,@RequestBody String user_id) 
	{
		SessionDetails response=sessionInfo.getSessionInfo(token);
		return ResponseEntity.ok(response);
	}

}
