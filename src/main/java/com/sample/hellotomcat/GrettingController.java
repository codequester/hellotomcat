package com.sample.hellotomcat;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrettingController {
	
	private GreetingService greetingService;
	private Boolean isRunning = true;
	
	public GrettingController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	String loadInitGreeting() {
		for(long i=0; i <= 1000000; i++) {
			System.out.println("This is a sample");
		}
		return "This is test Application (NEW) for Openshift-pipeline <br> ";
//				+ "1. Source change works <br> "
//				+ "2. Pipeline setup done <br> "
//				+ "3. Disable triggers for bc and dc <br>"
//				+ "&nbsp;&nbsp;&nbsp;3.1 Build runs but changes are not deployed (Doubt) ??? <br>"
//				+ "4. Pipeline configured!!!";
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	String sayHello(@RequestParam(defaultValue="Red Hat!!!") String name) {
		return String.format("{\"greeting\":\"Good Morning %s\"}", name);
	}
	
	
	@RequestMapping(value="/callasync/return", method=RequestMethod.GET)
	String callAsyncWreturn() throws InterruptedException, ExecutionException  {
		Future<String> future = greetingService.someLongRunningMethodWReturn();
		if(future.isDone()) 
			return String.format("Result From Async Method -" + future.get());
		else
			return "Waiting";
	}
	
	@RequestMapping(value="/callasync", method=RequestMethod.GET)
	String callAsync() throws InterruptedException, ExecutionException  {
		greetingService.someLongRunningMethod();
		return "Api called and Done";
	}

	@RequestMapping(value="/grace", method=RequestMethod.GET)
	String testGraceness() throws InterruptedException {
		registerShutDownHook(Thread.currentThread());
		keepCurrentThreadBusy();
		return "Thread Running in the backggroun... Check the console";
	}

	private void registerShutDownHook(Thread controlThread) {
		Thread monitorThread = new Thread(() -> {
			System.out.println("Shutdown Sequence INITIATED -->");
			isRunning = false;
			controlThread.interrupt();
			System.out.println("Controll Thread Stopped before program exit. . .");
		});
		Runtime.getRuntime().addShutdownHook(monitorThread);
	}

	private void keepCurrentThreadBusy() throws InterruptedException {
		while(isRunning) {
			Thread.sleep(1000);
			System.out.println("Control Thread Running. . .");
		}
	}
}
