package com.semaphore.api.rest;

import com.semaphore.api.service.SemaphoreService;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.internal.verification.AtLeast;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RestSemaphoreTest {

	@Mock
	private SemaphoreService service;
	
	private RestSemaphore semaphore;
	
	@Before
	public void init(){		
		semaphore = new RestSemaphore(service);
	}
	
	@Test
	public void TurnOnTheSwitch(){
		semaphore.updateStatus(1);		
		Mockito.verify(service, Mockito.times(1)).TurnOn(1);
		
	}
		
}
