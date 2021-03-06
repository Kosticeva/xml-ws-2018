//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.22 at 10:45:01 AM CEST 
//


package com.ftn.xml.agent.domain;

import javax.xml.bind.annotation.*;


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
 *         &lt;element name="grade" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element ref="{}accomodation"/>
 *         &lt;element ref="{}user"/>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="review-id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *       &lt;attribute name="allowed" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "grade",
    "accomodation",
    "user",
    "comment",
    "reviewId"
})
@XmlRootElement(name = "review")
public class Review {

    protected int grade;
    @XmlElement(required = true)
    protected Accomodation accomodation;
    @XmlElement(required = true)
    protected User user;
    @XmlElement(required = true)
    protected String comment;
    @XmlElement(name = "review-id")
    protected int reviewId;
    @XmlAttribute(name = "allowed")
    protected Boolean allowed;

    /**
     * Gets the value of the grade property.
     * 
     */
    public int getGrade() {
        return grade;
    }

    /**
     * Sets the value of the grade property.
     * 
     */
    public void setGrade(int value) {
        this.grade = value;
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
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * Gets the value of the reviewId property.
     * 
     */
    public int getReviewId() {
        return reviewId;
    }

    /**
     * Sets the value of the reviewId property.
     * 
     */
    public void setReviewId(int value) {
        this.reviewId = value;
    }

    /**
     * Gets the value of the allowed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowed() {
        return allowed;
    }

    /**
     * Sets the value of the allowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowed(Boolean value) {
        this.allowed = value;
    }

}
