package com.semaphore.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.semaphore.model.Semaphore;

@Service
public class SemaphoreStaticRepository implements SemaphoreReposistory {
	
	private List<Semaphore> semaphoreList;

	public SemaphoreStaticRepository(){
	
		semaphoreList = new ArrayList<>();
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
