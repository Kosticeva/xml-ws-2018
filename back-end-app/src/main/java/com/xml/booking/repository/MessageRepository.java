package com.xml.booking.repository;

import com.xml.booking.domain.Message;
import com.xml.booking.domain.User;
import com.xml.booking.domain.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findByUserAndAgent(User user, Agent agent);

    List<Message> findByUser(User user);
}
