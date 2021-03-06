//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.22 at 10:45:00 AM CEST 
//


package com.xml.booking.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.sql.Timestamp;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}agent"/>
 *         &lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{}user"/>
 *         &lt;element name="message-id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *       &lt;attribute name="read" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "agent",
    "content",
    "user",
    "messageId"
})
@Entity
@XmlRootElement(name = "message")
public class Message {

    @ManyToOne
    @XmlElement(required = true)
    protected Agent agent;
    @XmlElement(required = true)
    protected String content;
    @ManyToOne
    @XmlElement(required = true)
    protected User user;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @XmlElement(name = "message-id")
    protected int messageId;
    @XmlAttribute(name = "read")
    protected Boolean readed; //mysql baca error za read field

    //naknadno dodati
    @XmlAttribute(name = "sender")
    protected String sender; //values : 'AGENT', 'USER', TODO: koristi enum ovde
    @XmlAttribute(name = "time")
    protected Timestamp time;
    public String getSender() {return  sender;}
    public void setSender(String sender) {this.sender = sender;}
    public Timestamp getTime() {return time;}
    public void setTime(Timestamp time) {this.time = time;}

    /**
     * Gets the value of the agent property.
     * 
     * @return
     *     possible object is
     *     {@link Agent }
     *     
     */
    public Agent getAgent() {
        return agent;
    }

    /**
     * Sets the value of the agent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Agent }
     *     
     */
    public void setAgent(Agent value) {
        this.agent = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setUser(User value) {
        this.user = value;
    }

    /**
     * Gets the value of the messageId property.
     * 
     */
    public int getMessageId() {
        return messageId;
    }

    /**
     * Sets the value of the messageId property.
     * 
     */
    public void setMessageId(int value) {
        this.messageId = value;
    }

    /**
     * Gets the value of the readed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isReaded() {
        if (readed == null) {
            return false;
        } else {
            return readed;
        }
    }

    /**
     * Sets the value of the readed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReaded(Boolean value) {
        this.readed = value;
    }

    @Override
    public String toString() {
        return "Message{" +
                "agent=" + agent +
                ", content='" + content + '\'' +
                ", user=" + user +
                ", messageId=" + messageId +
                ", readed=" + readed +
                ", sender='" + sender + '\'' +
                ", time=" + time +
                '}';
    }
}
