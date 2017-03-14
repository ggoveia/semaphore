package com.semaphore.infraestructure;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.semaphore.model.Semaphore;
import com.semaphore.repository.SemaphoreReposistory;

@RestController
@RequestMapping("infrastructure")
public class SemaphoreInfrastructureController
{
	private SemaphoreReposistory repository;
	
	//@Autowired
	public SemaphoreInfrastructureController(SemaphoreReposistory repository){
		this.repository = repository;
	}
	
	@RequestMapping(method = RequestMethod.POST )
	public void save(Semaphore semaphore){
		this.repository.save(semaphore);
	}
	
	 @RequestMapping(method = RequestMethod.POST,consumes="application/json" )
	 @ResponseStatus(value = HttpStatus.OK)
	public void update(@RequestBody Semaphore semaphore){
		this.repository.update(semaphore);
	}
	
	@RequestMapping(method = RequestMethod.GET,produces="application/json" )
	public Semaphore byId(@RequestParam(value="id", defaultValue="1") int id){
		return this.repository.getById(id);
	}
}