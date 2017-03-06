package com.semaphore.infraestructure.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.semaphore.domain.Semaphore;
import com.semaphore.repository.SemaphoreRepository;

@Path("/semaphore")
public class RestSemaphoreDBImple implements RestSemaphoreDB
{
	private SemaphoreRepository repository;
	
	public RestSemaphoreDBImple(SemaphoreRepository repository){
		this.repository = repository;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void save(Semaphore semaphore){
		this.repository.save(semaphore);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Semaphore semaphore){
		this.repository.update(semaphore);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Semaphore byId(int Id){
		return this.repository.getById(Id);
	}
}