package com.xml.booking.dto;

public class ReviewDTO {

    private Integer reviewId;
    private Integer accomodationId;
    private String user;
    private String comment;
    private Boolean allowed;
    private Integer grade;

    public ReviewDTO() {
    }

    public ReviewDTO(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public ReviewDTO(Integer reviewId, Integer accomodationId, String userId, String comment, Boolean allowed, Integer grade) {
        this.reviewId = reviewId;
        this.accomodationId = accomodationId;
        this.user = userId;
        this.comment = comment;
        this.allowed = allowed;
        this.grade = grade;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getAccomodationId() {
        return accomodationId;
    }

    public void setAccomodationId(Integer accomodationId) {
        this.accomodationId = accomodationId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String userId) {
        this.user = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean isAllowed() {
        return allowed;
    }

    public void setAllowed(Boolean allowed) {
        this.allowed = allowed;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
