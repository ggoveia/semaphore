package com.semaphore.repository;

import com.semaphore.model.Semaphore;

public interface SemaphoreReposistory {

	void save(Semaphore semaphore);

	void update(Semaphore semaphore);

	Semaphore getById(int id);

}