package com.example.cqxt.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class StudentRequest {
    private Integer studentId;
    @JsonProperty("userId")
    private Integer userId;

    private String name;

    private String gender;

    private Date dateOfBirth;

    private String major;

    private Integer dormitoryId;

    private Integer initialScore;

    
}
