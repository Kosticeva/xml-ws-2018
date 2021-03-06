//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.22 at 10:45:01 AM CEST 
//


package com.ftn.xml.agent.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.*;
import java.util.Date;


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
 *         &lt;element ref="{}user"/>
 *         &lt;element ref="{}accomodation"/>
 *         &lt;element name="reservation-id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *       &lt;attribute name="confirmed" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="num-persons">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;minInclusive value="0"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="final-price" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="start-date" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="end-date" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "user",
    "accomodation",
    "reservationId"
})
@Entity
@XmlRootElement(name = "reservation")
public class Reservation {

    @ManyToOne
    @XmlElement(required = true)
    protected User user;
    @XmlElement(required = true)
    @ManyToOne
    protected Accomodation accomodation;
    @XmlElement(name = "reservation-id")
    @Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    protected int reservationId;
    @XmlAttribute(name = "realized")
    protected Boolean realized;
    @XmlAttribute(name = "active")
    @Column(columnDefinition="tinyint(1) default 1")
    protected Boolean active; //odnosno 'not canceled'
    @XmlAttribute(name = "num-persons")
    protected Integer numPersons;
    @XmlAttribute(name = "final-price")
    protected Float finalPrice;
    @XmlAttribute(name = "start-date")
    @XmlSchemaType(name = "date")
    protected Date startDate; //umesto XMLGregorianCalendar
    @XmlAttribute(name = "end-date")
    @XmlSchemaType(name = "date")
    protected Date endDate;

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
     * Gets the value of the accomodation property.
     * 
     * @return
     *     possible object is
     *     {@link Accomodation }
     *     
     */
    public Accomodation getAccomodation() {
        return accomodation;
    }

    /**
     * Sets the value of the accomodation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Accomodation }
     *     
     */
    public void setAccomodation(Accomodation value) {
        this.accomodation = value;
    }

    /**
     * Gets the value of the reservationId property.
     * 
     */
    public int getReservationId() {
        return reservationId;
    }

    /**
     * Sets the value of the reservationId property.
     * 
     */
    public void setReservationId(int value) {
        this.reservationId = value;
    }

    /**
     * Gets the value of the realized property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isRealized() {
        if (realized == null) {
            return false;
        } else {
            return realized;
        }
    }

    /**
     * Gets the value of the active property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public boolean isActive() {
        if (active == null) {
            return false;
        } else {
            return active;
        }
    }

    /**
     * Sets the value of the realized property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setRealized(Boolean value) {
        this.realized = value;
    }

    /**
     * Sets the value of the active property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setActive(Boolean value) {
        this.active = value;
    }

    /**
     * Gets the value of the numPersons property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumPersons() {
        return numPersons;
    }

    /**
     * Sets the value of the numPersons property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumPersons(Integer value) {
        this.numPersons = value;
    }

    /**
     * Gets the value of the finalPrice property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getFinalPrice() {
        return finalPrice;
    }

    /**
     * Sets the value of the finalPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setFinalPrice(Float value) {
        this.finalPrice = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setStartDate(Date value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setEndDate(Date value) {
        this.endDate = value;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "user=" + user +
                ", accomodation=" + accomodation +
                ", reservationId=" + reservationId +
                ", realized=" + realized +
                ", active=" + active +
                ", numPersons=" + numPersons +
                ", finalPrice=" + finalPrice +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
