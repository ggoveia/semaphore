package com.semaphore.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

@Configuration
public class SemaphoreFeignConfiguration {

	@Bean
	public SemaphoreClient getMovieStoreService() {
		final String path = "http://localhost:8090";
		
		return Feign.builder()
				.encoder(new JacksonEncoder())
				.decoder(new JacksonDecoder())
				.target(SemaphoreClient.class, path);
	}
}
