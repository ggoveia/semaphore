package com.semaphore.api.service;

import java.util.ArrayList;

import com.google.inject.Inject;
import com.semaphore.api.process.SemaphoreObservable;
import com.semaphore.api.process.SemaphoreObserver;

public class SemaphoreService {

	private int time = 15000;
	
	SemaphoreObservable semaphoreObservable;
	SemaphoreObserver semaphoreObserver;
	
	@Inject
	public SemaphoreService(SemaphoreObservable semaphoreObservable,SemaphoreObserver semaphoreObserver){
		this.semaphoreObservable = semaphoreObservable;
		this.semaphoreObserver = semaphoreObserver;
	}
	
	public void TurnOn(int id){
		
		ArrayList<String> colors = new ArrayList<String> ();
		colors.add("G");
		colors.add("Y");
		colors.add("R");
		
		int i = 0;
		long t= System.currentTimeMillis();
		long end = t+this.time;
		
		while(System.currentTimeMillis() < end) {
		 	try {
		 		if(i == 2) i = 0;
		 		semaphoreObservable.setNewStatus(colors.get(i));				  
				Thread.sleep(5000);
				i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}				
	}
}
