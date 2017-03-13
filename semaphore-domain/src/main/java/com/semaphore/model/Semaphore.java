package com.semaphore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Semaphore{

	private int id;
	private String activedLight; //use G-Green, R- Red, Y - Yellow N- None
	
	public int getId() {
		return id;
	}
	
	public String getActivedLight() {
		return activedLight;
	}
	
	public Semaphore(){
		
	}
	
	public Semaphore(int id, String activedLight) {
		this.id = id;
		this.activedLight = activedLight;
	}
	
	public Semaphore byId() {
		return this;
	}
	
	public void setActivedLight(String activedLight){
		this.activedLight = activedLight;
	}
}
