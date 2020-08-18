package com.bank.management.fetchaccount.session;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.management.fetchaccount.model.request.FetchDetailsRequest;
import com.bank.management.fetchaccount.model.response.ExternalDetailsResponse;

@Service
@Component
@FeignClient(name="externalaccount")
public interface ExternalClient {
	@RequestMapping(value="/fetchExtDetails", method = RequestMethod.POST)
public ExternalDetailsResponse fetchDetails(@RequestParam("token") String token,@RequestBody FetchDetailsRequest req);

}
