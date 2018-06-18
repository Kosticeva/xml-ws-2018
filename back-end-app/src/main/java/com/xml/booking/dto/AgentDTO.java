package com.xml.booking.dto;

import com.xml.booking.domain.Agent;

public class AgentDTO {
    String username;
    String password;
    String firstName;
    String lastName;
    String businessID;

    public AgentDTO() {

    }
    public AgentDTO(Agent agent) {
        this.username = agent.getUsername();
        this.password = agent.getPassword();
        this.businessID = agent.getBusinessID();
        this.firstName = agent.getFirstName();
        this.lastName = agent.getLastName();
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBusinessID() {
        return businessID;
    }

    public void setBusinessID(String businessID) {
        this.businessID = businessID;
    }
}
