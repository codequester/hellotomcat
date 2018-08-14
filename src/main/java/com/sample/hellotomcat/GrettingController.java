package com.sample.hellotomcat;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrettingController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	String loadInitGreeting() {
		return "This is test Application for Openshift";
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	String sayHello(@RequestParam(defaultValue="Stranger") String name) {
		return String.format("{\"greeting\":\"Hello %s\"}", name);
	}

}
