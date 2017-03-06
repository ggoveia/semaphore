package com.semaphore.api.rest;

import com.google.inject.Inject;
import com.semaphore.api.service.SemaphoreService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;

@Path("/semaphore/")
public class RestSemaphore{

	private final SemaphoreService service;
	
	@Inject
	public RestSemaphore(SemaphoreService service){
		this.service = service;
	}
	
	@GET
    @Path("/{id}")    
    public Response getStatus(@PathParam("id") int id) {
            return Response.status(404).build();
       
    }
	@POST
	public Response updateStatus(@PathParam("id") int id) {
		
		service.TurnOn(id);
		return Response.status(202).build();
	}
	
}
