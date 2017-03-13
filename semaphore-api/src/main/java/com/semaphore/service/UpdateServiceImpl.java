package com.semaphore.service;

import java.util.Observable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semaphore.client.SemaphoreClient;
import com.semaphore.model.Semaphore;

@Service
public class UpdateServiceImpl extends Observable implements UpdateService {
	
	private SemaphoreClient client;
	
	@Autowired
	public UpdateServiceImpl(SemaphoreClient client){
		this.client = client;		
	}
	
	public void setNewActivedLight(int id, String status){
		
		Semaphore semaphore = client.byId(id);
		semaphore.setActivedLight(status);
		
		this.client.update(semaphore);
			
		setChanged();
		notifyObservers();
	}
}