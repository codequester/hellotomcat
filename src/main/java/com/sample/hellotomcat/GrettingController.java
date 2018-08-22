package com.sample.hellotomcat;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrettingController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	String loadInitGreeting() {
		return "This is test Application (NEW) for Openshift-pipeline <br> "
				+ "1. Source change works <br> "
				+ "2. Pipeline setup done <br> "
				+ "3. Disable triggers for bc and dc <br>"
				+ "&nbsp;&nbsp;&nbsp;3.1 Build runs but changes are not deployed (Doubt) ??? <br>"
				+ "4. Pipeline configured!!!";
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	String sayHello(@RequestParam(defaultValue="Red Hat!!!") String name) {
		return String.format("{\"greeting\":\"Good Morning %s\"}", name);
	}

}
