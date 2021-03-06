package com.sample.hellotomcat;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableAsync
public class Application { //extends SpringBootServletInitializer{

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(Application.class);
//	}

	
    @Bean
    public Executor getAsyncExecutor() {
    	int cpus = Runtime.getRuntime().availableProcessors();
    	System.out.println("The number of CPUs - " + cpus);
    	ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();	
        executor.setCorePoolSize(cpus * 2);
        executor.setMaxPoolSize(50);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("ValidationEngineAggregator-");
        executor.initialize();
        return executor;

    }
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
