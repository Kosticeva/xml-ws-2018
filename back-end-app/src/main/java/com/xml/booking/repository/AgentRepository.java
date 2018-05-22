package com.xml.booking.repository;

import com.xml.booking.domain.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository  extends JpaRepository<Agent, String> {
}
