package com.xml.booking.service;

import com.xml.booking.domain.Message;
import org.springframework.stereotype.Service;

@Service
public interface MessageService {
    public Message sendMessage(Message message);
}
