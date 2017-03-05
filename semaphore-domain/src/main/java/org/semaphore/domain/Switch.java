package org.semaphore.domain;

public class Switch {

	private Boolean status;

	public Boolean getStatus() {
		return status;
	}

	public Switch(Boolean status) {
		this.status = status;
	}
	
	public void TurnOn(){
		this.status = true;
	}
	
	public void TurnOff(){
		this.status = false;
	}
}
