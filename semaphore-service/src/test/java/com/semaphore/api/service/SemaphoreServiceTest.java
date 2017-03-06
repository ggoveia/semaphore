package com.semaphore.api.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.semaphore.api.process.SemaphoreObservable;
import com.semaphore.api.process.SemaphoreObserver;
import com.semaphore.api.rest.RestSemaphore;

public class SemaphoreServiceTest {

	@Mock
	private SemaphoreObservable observable;
	private SemaphoreObserver observer;
	
	private SemaphoreService service;
	
	@Before
	public void init(){
		observable = Mockito.spy(new SemaphoreObservable());
		observer = Mockito.spy(new SemaphoreObserver(observable));
		service = new SemaphoreService(observable, observer);		
	}
	
	@Test
	public void testUpdatedMethodWillBeCalled3times(){
		service.TurnOn(1);
		Mockito.verify(observable, Mockito.times(3)).setNewStatus(Mockito.anyString());
		
	}
}
