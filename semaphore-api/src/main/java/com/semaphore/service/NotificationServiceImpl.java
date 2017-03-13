package com.semaphore.service;

import java.util.Observable;
import java.util.Observer;

import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements Observer, NotificationService {

	UpdateService updater;
	
	public NotificationServiceImpl(UpdateService updater){
		this.updater = updater;
		((Observable) this.updater).addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
		System.out.println("color changed");		
	}	
}
