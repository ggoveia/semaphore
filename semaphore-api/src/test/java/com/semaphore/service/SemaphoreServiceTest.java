package com.semaphore.service;

import static org.junit.Assert.assertSame;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.semaphore.client.SemaphoreClient;
import com.semaphore.model.Semaphore;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class SemaphoreServiceTest {
	
	@Mock
	private SemaphoreClient client;
	
	private Semaphore semaphore;
	
	private SemaphoreService serviceUnderTest;
	
	@Before
	public void setUp(){
		
		client = Mockito.mock(SemaphoreClient.class);
		semaphore = new Semaphore(1,"R");
		Mockito.when(client.byId(1)).thenReturn(semaphore);
		
		serviceUnderTest = new SemaphoreService(client);
		 
	}
	
	@Test
	public void testTurnOnSemaphore(){
		
		String result = serviceUnderTest.turnOnSemaphore(1);
        assertSame("Semaphore finalized", result);
		
	}
	
	@Test
	public void getStatus(){
		
		String color = serviceUnderTest.getActivedColor(1);		
		assertSame("R",color);
	}

}
