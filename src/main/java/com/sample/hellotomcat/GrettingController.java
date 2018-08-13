package com.sample.hellotomcat;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrettingController {
	
	@RequestMapping("/hello")
	String sayHello() {
		return "{\"greeting\":\"Hello Tomcat\"}";
	}

}
