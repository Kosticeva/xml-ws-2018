package com.xml.booking.service;


import com.xml.booking.domain.Agent;
import com.xml.booking.domain.Message;
import com.xml.booking.domain.Reservation;
import com.xml.booking.domain.User;
import com.xml.booking.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AgentRepository agentRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    AccomodationRepository accomodationRepository;

    @Override
    public Message sendMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getConversation(String userUsername, String agentUsername) {
        User user = userRepository.findById(userUsername).orElse(null);
        Agent agent = agentRepository.findById(agentUsername).orElse(null);
        List<Message> messages = messageRepository.findByUserAndAgent(user, agent);
        messages.sort(new Comparator<Message>() {
            @Override
            public int compare(Message m1, Message m2) {
                return m1.getTime().after(m1.getTime()) ? -1 : 1;
            }
        });
        return messages;
    }

    @Override
    public List<Agent> getAllAgentsForUserUsername(String userUsername) {
        List<Agent> ret = new ArrayList<Agent>();

        User user = userRepository.findById(userUsername).orElse(null);
        List<Reservation> reservations = reservationRepository.findByUser(user);
        boolean exists;
        for (Reservation r : reservations) {
            Agent agent = r.getAccomodation().getAgent();

            exists = false;
            for (Agent a : ret) {
                if (a.getUsername() == agent.getUsername()) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                ret.add(agent);
            }
        }
        return ret;
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message get(int id) {
        return messageRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        messageRepository.deleteById(id);
    }

}
