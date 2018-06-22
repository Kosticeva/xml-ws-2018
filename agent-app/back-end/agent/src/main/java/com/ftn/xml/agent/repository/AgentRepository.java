package com.ftn.xml.agent.repository;

import com.ftn.xml.agent.domain.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository  extends JpaRepository<Agent, String> {
}
