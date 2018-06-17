package com.xml.booking.service;

import com.xml.booking.domain.Agent;
import org.springframework.stereotype.Service;

@Service
public interface AgentService {
    public Agent get(String username);
}
