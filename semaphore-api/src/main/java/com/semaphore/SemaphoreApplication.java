package com.semaphore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.semaphore.model.Semaphore;

@SpringBootApplication
@ComponentScan
public class SemaphoreApplication {
    
	public static void main(String[] args) {
        SpringApplication.run(SemaphoreApplication.class, args);
    }

}

