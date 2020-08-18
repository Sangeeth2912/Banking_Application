package com.bank.management.fetchaccount.session;

import javax.annotation.Resource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.management.fetchaccount.model.request.FetchDetailsRequest;

@Service
@Component
@Resource
@FeignClient(name="internalaccount")
public interface InternalClient {
	@RequestMapping(value="/fetchIntDetails", method = RequestMethod.POST)
	public String fetchDetails(@RequestParam("token") String token,@RequestBody FetchDetailsRequest req);
}
