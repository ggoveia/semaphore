package com.semaphore.service;

import java.util.Arrays;
import java.util.List;
import java.util.Observable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semaphore.client.SemaphoreClient;
import com.semaphore.model.Semaphore;

@Service
public class SemaphoreService extends Observable {

	private static final int TIME = 15000;
	private static final List<String> COLORS = Arrays.asList("G", "Y", "R");
	
	private SemaphoreClient client;
	
	@Autowired
	public SemaphoreService(SemaphoreClient client){
		this.client = client;
	}
	
	public String turnOnSemaphore(int id) {
		
		int i = 0;
		long t= System.currentTimeMillis();
		long end = t+ TIME;
		
		while(System.currentTimeMillis() < end) {
		 	try {		 		
		 		if(i == 2){
		 			i = 0;
		 		} 
		 		setNewActivedLight(id,COLORS.get(i));				  
				Thread.sleep(5000);
				i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return "Semaphore finalized";
	}

	public String getActivedColor(int id){
		return this.client.byId(id).getActivedLight();
	}
	
	public void setNewActivedLight(int id, String status){
		
		Semaphore semaphore = client.byId(id);
		semaphore.setActivedLight(status);
		
		this.client.update(semaphore);
			
		setChanged();
		notifyObservers();
	}
}
