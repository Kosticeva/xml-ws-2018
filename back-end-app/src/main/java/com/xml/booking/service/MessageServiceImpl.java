package com.xml.booking.service;


import com.xml.booking.domain.Message;
import com.xml.booking.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Override
    public Message sendMessage(Message message) {
        return messageRepository.save(message);
    }
}
