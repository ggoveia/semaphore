package com.semaphore.service;

import java.util.Observable;
import java.util.Observer;

import org.springframework.stereotype.Service;

@Service
public class NotificationService implements Observer {
	
	SemaphoreService semaphoreService;
	
	public NotificationService(SemaphoreService semaphoreService){
		this.semaphoreService = semaphoreService;
		((Observable) this.semaphoreService).addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
		System.out.println("color changed");		
	}	
}
