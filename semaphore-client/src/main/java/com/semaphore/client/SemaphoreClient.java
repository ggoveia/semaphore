package com.semaphore.client;

import com.semaphore.model.Semaphore;

import feign.Param;
import feign.RequestLine;

public interface SemaphoreClient {
	
	@RequestLine("GET /infrastructure/semaphore/{id}")
	Semaphore byId(@Param("id") int id);
	
	@RequestLine("POST /infrastructure/semaphore")
	void update(Semaphore semaphore);

}
