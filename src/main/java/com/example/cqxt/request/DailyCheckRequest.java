package com.example.cqxt.request;

import java.util.Date;

import lombok.Data;

@Data
public class DailyCheckRequest {
    private Integer checkId;

    private Integer studentId;

    private Date checkDate;

    private Integer blanketFoldingScore;

    private Integer garbageDisposalScore;

    private Integer desktopOrganizationScore;

    private Integer hygieneScore;

}
