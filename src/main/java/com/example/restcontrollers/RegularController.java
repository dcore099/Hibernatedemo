package com.example.restcontrollers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.services.TestService;

@RestController
public class RegularController {
	final static Logger logger = Logger.getLogger(RegularController.class);

	@Autowired
	TestService test;
	
	@GetMapping("/test")
	public String doSomething() {
		logger.info("Dentro del controlador");
		test.test();
		
		return "done!";
	}

	
}
