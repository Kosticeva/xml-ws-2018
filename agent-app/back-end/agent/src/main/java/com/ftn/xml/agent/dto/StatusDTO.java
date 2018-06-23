package com.ftn.xml.agent.dto;

public class StatusDTO {

	private boolean status;
	private String username;

	public StatusDTO() {
		this.status = false;
		this.username = "";
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
