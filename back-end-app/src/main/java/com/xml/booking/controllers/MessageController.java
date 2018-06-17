package com.xml.booking.controllers;

import com.xml.booking.domain.Message;
import com.xml.booking.dto.MessageDTO;
import com.xml.booking.service.AgentService;
import com.xml.booking.service.MessageService;
import com.xml.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.sql.Timestamp;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/message")
public class MessageController {

    @Autowired
    UserService userService;
    @Autowired
    AgentService agentService;
    @Autowired
    MessageService messageService;

    @RequestMapping(
            value = "/send",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<MessageDTO> sendMessage(@RequestBody MessageDTO messageDTO) {

        //TODO: dodati 'Pincipal user' kao param, pa proveriti if (sender == 'USER' && user.username == messageDTO.userUsername) ...

        Message message = new Message();
        message.setSender(messageDTO.getSender());
        message.setUser(userService.findUser(messageDTO.getUserUsername()));
        message.setAgent(agentService.get(messageDTO.getAgentUsername()));
        message.setContent(messageDTO.getContent());
        message.setReaded(false);
        message.setTime(new Timestamp(System.currentTimeMillis()));
        Message messageSent = messageService.sendMessage(message);
        return new ResponseEntity<MessageDTO>(new MessageDTO(messageSent), HttpStatus.OK);
    }
}
