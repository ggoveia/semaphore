package com.semaphore.api;

import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;

import com.semaphore.api.rest.RestSemaphore;
import com.semaphore.api.rest.RestSemaphoreImpl;
import com.semaphore.api.service.*;


public class SemaphoreModule extends ServletModule{
	@Override
	protected void configureServlets() {
		bind(RestSemaphore.class).to(RestSemaphoreImpl.class);
		bind(SemaphoreService.class).to(SemaphoreServiceImpl.class);
	}	
}
