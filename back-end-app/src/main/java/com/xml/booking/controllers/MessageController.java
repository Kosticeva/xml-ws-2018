package com.xml.booking.controllers;

import com.xml.booking.domain.Agent;
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

import java.security.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    UserService userService;
    @Autowired
    AgentService agentService;
    @Autowired
    MessageService messageService;

    //salje poruku od user ka agentu (user koji salje poruku se dobija iz principal objekta)
    @RequestMapping(
            value = "/sendtoagent",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<MessageDTO> sendMessageFromUserToAgent(@RequestBody MessageDTO messageDTO, Principal user) {

        //TODO: dodati 'Pincipal user' kao param, pa proveriti if (sender == 'USER' && user.username == messageDTO.userUsername) ...

        Message message = new Message();
        message.setSender(messageDTO.getSender());
        message.setUser(userService.findUser(user.getName()));
        message.setAgent(agentService.get(messageDTO.getAgentUsername()));
        message.setContent(messageDTO.getContent());
        message.setReaded(false);
        message.setTime(new Timestamp(System.currentTimeMillis()));
        Message messageSent = messageService.sendMessage(message);
        return new ResponseEntity<MessageDTO>(new MessageDTO(messageSent), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/getconversation/{agent}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<MessageDTO>> getConversation(@PathVariable("agent") String agentUsername, Principal user) {
        List<Message> messages = messageService.getConversation(user.getName(), agentUsername);
        List<MessageDTO> messageDtos = new ArrayList<MessageDTO>();
        for (Message m : messages) {
            messageDtos.add(new MessageDTO(m));
        }
        return new ResponseEntity<List<MessageDTO>>(messageDtos, HttpStatus.OK);
    }

    //vraca sve agente kod kojih user ima rezervacije (to su agenti sa kojima moze da vodi konverzaciju)
    @RequestMapping(
            value = "/getagents",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Agent>> getAllAgents(Principal user) {
        List<Agent> agents = messageService.getAllAgentsForUserUsername(user.getName());
        return new ResponseEntity<List<Agent>>(agents, HttpStatus.OK);
    }
}
