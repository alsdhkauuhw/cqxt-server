package com.example.cqxt.beans;

import java.util.Date;

public class DailyCheck {
    private Integer checkId;

    private Integer studentId;

    private Date checkDate;

    private Integer blanketFoldingScore;

    private Integer garbageDisposalScore;

    private Integer desktopOrganizationScore;

    private Integer hygieneScore;

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public Integer getBlanketFoldingScore() {
        return blanketFoldingScore;
    }

    public void setBlanketFoldingScore(Integer blanketFoldingScore) {
        this.blanketFoldingScore = blanketFoldingScore;
    }

    public Integer getGarbageDisposalScore() {
        return garbageDisposalScore;
    }

    public void setGarbageDisposalScore(Integer garbageDisposalScore) {
        this.garbageDisposalScore = garbageDisposalScore;
    }

    public Integer getDesktopOrganizationScore() {
        return desktopOrganizationScore;
    }

    public void setDesktopOrganizationScore(Integer desktopOrganizationScore) {
        this.desktopOrganizationScore = desktopOrganizationScore;
    }

    public Integer getHygieneScore() {
        return hygieneScore;
    }

    public void setHygieneScore(Integer hygieneScore) {
        this.hygieneScore = hygieneScore;
    }
}