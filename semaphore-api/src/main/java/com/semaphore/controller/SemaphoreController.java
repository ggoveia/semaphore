package com.semaphore.controller;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.semaphore.service.SemaphoreService;


@RestController
@RequestMapping("semaphore")
public class SemaphoreController {
	
	private SemaphoreService service;
	
	 @Autowired
	public SemaphoreController(SemaphoreService service){
		this.service = service;
	}
	 
	 @RequestMapping(method = RequestMethod.POST )
	 public Callable<ResponseEntity<String>> turnOnSemaphore(@RequestParam(value="id", defaultValue="1") int id){
		return () -> ResponseEntity.ok(this.service.turnOnSemaphore(id));
	 }
	 
	 @RequestMapping(method = RequestMethod.GET)
	 public String getStatus(@RequestParam(value="id", defaultValue="1") int id){
		 return this.service.getActivedColor(id);
	 }
	 
}
