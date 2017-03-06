package com.semaphore.infraestructure.rest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.semaphore.domain.Semaphore;
import com.semaphore.domain.Switch;
import com.semaphore.repository.SemaphoreRepository;

public class RestSemaphoreDBTest {
	
	@Mock
	private Semaphore newSemaphore; 
	private SemaphoreRepository repository;
	
	private RestSemaphoreDB subject;
	
	@Before
	public void init(){		
		
		newSemaphore = new Semaphore(1,"Y");
		
		repository = Mockito.mock(SemaphoreRepository.class);
	    Mockito.when(repository.getById(1)).thenReturn(newSemaphore);
	    
	    subject = new RestSemaphoreDBImple(repository);
	}
	@Test
	public void testSave(){
		
		subject.save(newSemaphore);		
		Mockito.verify(repository).save(newSemaphore);
	
	}
	@Test
	public void testGetById(){

		Semaphore result = subject.byId(1);
		
		assertEquals(result.getId(),1);
		
	}
}
