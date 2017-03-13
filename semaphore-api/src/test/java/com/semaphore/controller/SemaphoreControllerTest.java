package com.semaphore.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.semaphore.service.SemaphoreService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration
public class SemaphoreControllerTest {

    @Autowired
    private MockMvc mvc;
   
    @Mock
    private SemaphoreService service;
    
    @InjectMocks
    private SemaphoreController controller;
        
    @Before
    public void setUp(){
    	
    	 MockitoAnnotations.initMocks(this);
    	 this.mvc = MockMvcBuilders.standaloneSetup(controller).build();    	
    }   
    
    @Test
    public void testTurningOnSemaphore() throws Exception {
      
    	when(this.service.turnOnSemaphore(1)).thenReturn("Semaphore finalized");
    	
        MvcResult mvcResult = mvc.perform(post("/semaphore" ))
        		.andExpect(request().asyncStarted())
                .andReturn();

    		mvc.perform(asyncDispatch(mvcResult))
    			.andExpect(status().isOk())
    			.andExpect(content().string("Semaphore finalized"));
    	
    }
    
    @Test
    public void getActivedColor() throws Exception{
    	Mockito.when(this.service.getActivedColor(1)).thenReturn("R");
    	
    	mvc.perform(get("/semaphore" ))
    		.andExpect(status().is2xxSuccessful())
    		.andExpect(content().string("R"));    	
    }
}