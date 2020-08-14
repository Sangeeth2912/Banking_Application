package com.bank.management.fetchaccount.session;

import javax.annotation.Resource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bank.management.fetchaccount.model.request.FetchDetailsRequest;

@Service
@Component
@Resource
@FeignClient(name="internalaccount",url="http://localhost:8080")
public interface InternalClient {
	@RequestMapping(value="/fetchIntDetails", method = RequestMethod.POST)
	public String fetchDetails(@RequestHeader(value="Authorization") String token,@RequestBody FetchDetailsRequest req);
}
