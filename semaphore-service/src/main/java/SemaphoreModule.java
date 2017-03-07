package com.semaphore.api;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;


public class SemaphoreModule extends ServletModule{
	@Override
	protected void configureServlets() {
		bind(RestSemaphore.class).to(RestSemaphoreImpl.class);
		bind(SemaphoreService.class).to(SemaphoreServiceImpl.class);
	}	
}
