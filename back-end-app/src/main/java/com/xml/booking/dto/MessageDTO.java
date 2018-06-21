package com.xml.booking.dto;

import com.xml.booking.domain.Message;

import java.sql.Timestamp;

public class MessageDTO {
    int messageId;
    String sender;
    String userUsername;
    String agentUsername;
    String content;
    boolean read;
    Timestamp time;

    public MessageDTO() {

    }

    public MessageDTO(Message message) {
        this.messageId = message.getMessageId();
        this.sender = message.getSender();
        this.userUsername = message.getUser().getUsername();
        this.agentUsername = message.getAgent().getUsername();
        this.content = message.getContent();
        this.read = message.isReaded();
        this.time = message.getTime();
    }


    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getAgentUsername() {
        return agentUsername;
    }

    public void setAgentUsername(String agentUsername) {
        this.agentUsername = agentUsername;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
