package com.semaphore.api.rest;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

public interface RestSemaphore {

	Response getStatus(@PathParam("id") int id);
	Response updateStatus(@PathParam("id") int id);
}
