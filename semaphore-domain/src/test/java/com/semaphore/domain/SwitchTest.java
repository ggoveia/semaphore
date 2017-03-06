package com.semaphore.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.semaphore.domain.Switch;

public class SwitchTest {
	
	private Switch NewsSwitch;
	
	@Before
	public void init(){
		NewsSwitch = new Switch(false);
	}
	
	@Test
	public void testSwitchIsTurnedOn(){
		NewsSwitch.TurnOn();
		assertEquals(NewsSwitch.getStatus(), true);
	}
	
	@Test
	public void testSwitchIsTurnedOff(){
		NewsSwitch.TurnOff();
		assertEquals(NewsSwitch.getStatus(), false);
	}
	
}