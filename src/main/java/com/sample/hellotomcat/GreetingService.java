package com.sample.hellotomcat;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
	
	@Async
	public void someLongRunningMethod() throws InterruptedException {
		System.out.println("The Thread - " + Thread.currentThread().getName() + " going to sleep for 5secs...");
		Thread.sleep(5000);
		System.out.println("The Thread - " + Thread.currentThread().getName() + " is awake and done");
	}
}