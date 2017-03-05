

package org.semaphore.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class SemaphoreTest {
	
	private Semaphore NewSemaphore;
	
	@Before
	public void init(){
		NewSemaphore = new Semaphore(1);
	}
	
	@Test
	public void testRedIsTurnedOn(){
		NewSemaphore.SetActiveLight("R");;
		assertEquals(NewSemaphore.getLightOn(), "R");
	}
	
}