package com.sample.hellotomcat;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
	
	@Async
	public Future<String> someLongRunningMethodWReturn() throws InterruptedException {
		System.out.println("The Thread - " + Thread.currentThread().getName() + " going to sleep for 5secs...");
		Thread.sleep(5000);
		System.out.println("The Thread - " + Thread.currentThread().getName() + " is awake and done");
		return new AsyncResult<String>("The Thread - " + Thread.currentThread().getName() + " is awake and done");
	}
	
	@Async
	public void someLongRunningMethod() throws InterruptedException {
		System.out.println("[NO RETURN] The Thread - " + Thread.currentThread().getName() + " going to sleep for 5secs...");
		Thread.sleep(5000);
		System.out.println("[NO RETURN] The Thread - " + Thread.currentThread().getName() + " is awake and done");
	}
}