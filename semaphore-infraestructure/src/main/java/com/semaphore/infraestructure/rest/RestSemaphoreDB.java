package com.semaphore.infraestructure.rest;

import com.semaphore.domain.*;

public interface RestSemaphoreDB {
	Semaphore byId(int Id);
	void save(Semaphore semaphore);
	void update(Semaphore semaphore);
}
