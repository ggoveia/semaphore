package com.semaphore.repository;

import java.util.List;

import com.semaphore.model.Semaphore;

public class SemaphoreStaticRepository implements SemaphoreReposistory {
	
	private List<Semaphore> semaphoreList;

	public SemaphoreStaticRepository(){
	
		semaphoreList.add(new Semaphore(1,"G"));
	}
	
	//@Override
	public void save(Semaphore semaphore) {
		
		semaphoreList.add(semaphore);
	}

	//@Override
	public void update(Semaphore semaphore) {
		
		Semaphore item = (Semaphore) semaphoreList.stream().filter( s -> s.byId().equals(1));
		item.setActivedLight(semaphore.getActivedLight());
	}

	//@Override
	public Semaphore getById(int id) {

		return (Semaphore) semaphoreList.stream().filter( s -> s.byId().equals(1));
	}
	
	
}
