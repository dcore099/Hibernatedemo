package com.example.restcontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hibernatedemo.TestHibernate;

@RestController
public class RegularController {

	@GetMapping("/test")
	public String doSomething() {
		TestHibernate test = new TestHibernate();
		test.test();
		
		return "done!";
	}
	
	@GetMapping("/")
	public String sayHello() {
		return "hellooo";
	}
	
}
