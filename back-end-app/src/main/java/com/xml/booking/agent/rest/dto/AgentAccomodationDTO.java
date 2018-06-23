package com.xml.booking.agent.rest.dto;

import java.util.List;

public class AgentAccomodationDTO {

	private String agentUsername;

	private String name;
	private String description;
	private int maxPersons;

	private int categoryId;
	private int typeId;

	private List<String> images;

	private List<Integer> services;

	// TLocation
	private String address;
	private String city;
	private String country;

	public AgentAccomodationDTO() {

	}

	public String getAgentUsername() {
		return agentUsername;
	}

	public void setAgentUsername(String agentUsername) {
		this.agentUsername = agentUsername;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxPersons() {
		return maxPersons;
	}

	public void setMaxPersons(int maxPersons) {
		this.maxPersons = maxPersons;
	}

	public int getCategory() {
		return categoryId;
	}

	public void setCategory(int category) {
		this.categoryId = category;
	}

	public int getType() {
		return typeId;
	}

	public void setType(int type) {
		this.typeId = type;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> image) {
		this.images = image;
	}

	public List<Integer> getServices() {
		return services;
	}

	public void setServices(List<Integer> services) {
		this.services = services;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
