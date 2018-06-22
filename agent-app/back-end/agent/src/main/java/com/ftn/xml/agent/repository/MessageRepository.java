package com.ftn.xml.agent.repository;

import com.ftn.xml.agent.domain.Agent;
import com.ftn.xml.agent.domain.Message;
import com.ftn.xml.agent.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findByUserAndAgent(User user, Agent agent);

    List<Message> findByUser(User user);

}
