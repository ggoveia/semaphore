package com.semaphore.domain;

public class Semaphore {

	private int id;
	private String activedLight; //use G-Green, R- Red, Y - Yellow N- None
	
	public int getId() {
		return id;
	}
	
	public String getLightOn() {
		return activedLight;
	}
	
	public Semaphore(int id, String activedLight) {
		this.id = id;
		this.activedLight = activedLight;
	}
	
	public void SetActiveLight(String activedLight){
		this.activedLight = activedLight;
	}
}
