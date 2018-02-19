package com.imolczek.liferayesb.sample.service.impl;

import org.osgi.service.component.annotations.Component;

import com.imolczek.liferayesb.sample.service.api.SampleService;

@Component (
		property = {
                "service.exported.interfaces=*",
                "aries.rsa.port=8201"
		},		
		service = SampleService.class
		)
public class SampleServiceImpl implements SampleService {

	public String sayHello(String name) {
		return "Hello " + name;
	}
	
}
