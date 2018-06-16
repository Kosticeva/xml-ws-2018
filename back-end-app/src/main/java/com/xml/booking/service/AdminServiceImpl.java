package com.xml.booking.service;

import com.xml.booking.domain.Agent;
import com.xml.booking.domain.User;
import com.xml.booking.repository.AgentRepository;
import com.xml.booking.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private AgentRepository agentRepository;

    private UserRepository userRepository;

    public AdminServiceImpl(AgentRepository agentRepository, UserRepository userRepository) {
        this.agentRepository = agentRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Agent createAgent(Agent agent) {
        return this.agentRepository.save(agent);
    }

    @Override
    public User activateUser(User user, String activate) {
        Optional<User> optional = this.userRepository.findById(user.getUsername());
        if (!optional.isPresent()) return null;
        User u = optional.get();
        u.setActivated(activate);
        return this.userRepository.save(u);
    }

    @Override
    public boolean deleteUser(User user) {
        Optional<User> u = this.userRepository.findById(user.getUsername());
        if (!u.isPresent()) return false;
        this.userRepository.delete(u.get());
        return true;
    }
}
