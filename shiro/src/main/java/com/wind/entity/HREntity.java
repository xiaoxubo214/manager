package com.wind.entity;

import java.io.Serializable;

public class HREntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String contractDetailId;
    private String name;
    private String hmName;
    private String hmmName;
    private String subject;
    private String course;
    private String lessonSerial;
    private String date;
    private String lessonPrice;
    private String lessonCntCharged;
    private String lessonRange;
    private String statusId;
    private String studentRating;
    private String step;
    private String studentComment;
    private String lessonContentChecked;

    public String getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(String contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHmName() {
        return hmName;
    }

    public void setHmName(String hmName) {
        this.hmName = hmName;
    }

    public String getHmmName() {
        return hmmName;
    }

    public void setHmmName(String hmmName) {
        this.hmmName = hmmName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getLessonSerial() {
        return lessonSerial;
    }

    public void setLessonSerial(String lessonSerial) {
        this.lessonSerial = lessonSerial;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLessonPrice() {
        return lessonPrice;
    }

    public void setLessonPrice(String lessonPrice) {
        this.lessonPrice = lessonPrice;
    }

    public String getLessonCntCharged() {
        return lessonCntCharged;
    }

    public void setLessonCntCharged(String lessonCntCharged) {
        this.lessonCntCharged = lessonCntCharged;
    }

    public String getLessonRange() {
        return lessonRange;
    }

    public void setLessonRange(String lessonRange) {
        this.lessonRange = lessonRange;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getStudentRating() {
        return studentRating;
    }

    public void setStudentRating(String studentRating) {
        this.studentRating = studentRating;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getStudentComment() {
        return studentComment;
    }

    public void setStudentComment(String studentComment) {
        this.studentComment = studentComment;
    }

    public String getLessonContentChecked() {
        return lessonContentChecked;
    }

    public void setLessonContentChecked(String lessonContentChecked) {
        this.lessonContentChecked = lessonContentChecked;
    }
}
