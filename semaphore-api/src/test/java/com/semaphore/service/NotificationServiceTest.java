package com.semaphore.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.semaphore.client.SemaphoreClient;
import com.semaphore.model.Semaphore;

public class NotificationServiceTest {
	
	private SemaphoreClient client;
	private Semaphore semaphore;
	
	private UpdateService updateServiceUnderTest;	
	private NotificationService notificationService;
	
	@Before
	public void setUp(){
		
		client = Mockito.mock(SemaphoreClient.class);
		semaphore = new Semaphore(1,"G");
		Mockito.when(client.byId(1)).thenReturn(semaphore);
		
		updateServiceUnderTest = new UpdateServiceImpl(client);	
		notificationService = new NotificationServiceImpl(updateServiceUnderTest);
	}
	
	@Test
	public void testUpdate(){
		
	
		
	}

}
