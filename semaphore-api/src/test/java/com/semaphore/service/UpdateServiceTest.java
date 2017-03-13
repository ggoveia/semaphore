package com.semaphore.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.semaphore.client.SemaphoreClient;
import com.semaphore.model.Semaphore;

public class UpdateServiceTest {
	
	private SemaphoreClient client;		
	private Semaphore semaphore;	
	private UpdateService serviceUnderTest;
	
	@Before
	public void setUp(){
	
		client = Mockito.mock(SemaphoreClient.class);
		semaphore = new Semaphore(1,"G");
		Mockito.when(client.byId(1)).thenReturn(semaphore);
		
		serviceUnderTest = new UpdateServiceImpl(client);
		
	}
	
	@Test
	public void testSetNewStatus(){
		
		serviceUnderTest.setNewActivedLight(1,"R");
		Mockito.verify(client).update(semaphore);
		
	}
}
