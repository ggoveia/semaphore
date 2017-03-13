package com.semaphore.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SemaphoreTest {
	
	private Semaphore NewSemaphore;
	
	@Before
	public void init(){
		NewSemaphore = new Semaphore(1,"R");
	}
	
	@Test
	public void testRedIsTurnedOn(){
		NewSemaphore.setActivedLight("R");
		assertEquals(NewSemaphore.getActivedLight(), "R");
	}
	
}