package com.sample.hellotomcat;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrettingController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	String loadInitGreeting() {
		return "This is test Application for Openshift-pipeline\n<br> 1. Source change works \n<br> 2. Pipeline setup done \n 3. Disable triggers for bc and dc";
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	String sayHello(@RequestParam(defaultValue="Red Hat!!!") String name) {
		return String.format("{\"greeting\":\"Hey %s\"}", name);
	}

}
