package com.semaphore.infraestructure.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.semaphore.infraestructure.SemaphoreInfrastructureController;
import com.semaphore.model.Semaphore;
import com.semaphore.repository.SemaphoreReposistory;

public class SemaphoreInfrastructureControllerTest {
	
	private final String semaphoreJson = "{\"id\":1,\"activedLight\":\"R\"}";
	private Semaphore newSemaphore; 
	
	@Autowired
    private MockMvc mvc;
	
	@Mock
	private SemaphoreReposistory repository;
	
	
	@InjectMocks
	private SemaphoreInfrastructureController controllerUnderTest;
	
	@Before
	public void setUp() {
		
		MockitoAnnotations.initMocks(this);
    	this.mvc = MockMvcBuilders.standaloneSetup(controllerUnderTest).build(); 
    	 
		newSemaphore = new Semaphore(1,"R");
	
	    Mockito.when(repository.getById(1)).thenReturn(newSemaphore);
	 }
	
	@Test
	public void testUpdate() throws Exception {
		
		mvc.perform(post("/infrastructure").contentType(MediaType.APPLICATION_JSON).content(semaphoreJson))
    		.andExpect(status().is2xxSuccessful());
    	
		Mockito.verify(repository).update(any(Semaphore.class));
	
	}
	
	@Test 
	public void testGetById() throws Exception {
		mvc.perform(get("/infrastructure" ))
		.andExpect(status().is2xxSuccessful())
		.andExpect(content().string(semaphoreJson));   
		
	}
}
