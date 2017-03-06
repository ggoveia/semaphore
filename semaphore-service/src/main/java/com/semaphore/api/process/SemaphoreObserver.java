package com.semaphore.api.process;

import java.util.Observable;
import java.util.Observer;

public class SemaphoreObserver implements Observer {

	Observable semaphoreObservable;
	
	public SemaphoreObserver(Observable semaphoreObservable){
		
		this.semaphoreObservable = semaphoreObservable;
		semaphoreObservable.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
		System.out.println("color changed");		
	}	
}
