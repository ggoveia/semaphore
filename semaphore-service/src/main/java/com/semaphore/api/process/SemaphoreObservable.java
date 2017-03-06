package com.semaphore.api.process;

import java.util.Observable;

public class SemaphoreObservable extends Observable {

	private String status;
	
	public void setNewStatus(String status){
		
		this.status = status;
		
		setChanged();
		notifyObservers();
	}
	
	public String getStatus(){
		return this.status;
	}
}
