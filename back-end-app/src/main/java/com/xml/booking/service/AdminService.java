package com.xml.booking.service;

import com.xml.booking.domain.Agent;
import com.xml.booking.domain.User;

public interface AdminService {


    Agent createAgent(Agent agent);
    User activateUser(User user, String activate);
    boolean deleteUser(User user);
}
