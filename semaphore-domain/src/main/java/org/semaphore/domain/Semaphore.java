package org.semaphore.domain;

public class Semaphore {

	public String getLightOn() {
		return lightOn;
	}

	private int id;
	private String lightOn; //use G-Green, R- Red, Y - Yellow N- None
	
	public Semaphore(int id) {
		this.id = id;
		this.lightOn = "N";
	}
	
	public void SetActiveLight(String collorLight){
		this.lightOn = "R";
	}
}
