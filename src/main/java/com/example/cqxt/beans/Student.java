package com.example.cqxt.beans;

import java.util.Date;

import lombok.Data;
@Data
public class Student {
    private Integer studentId;

    private Integer userId;

    private String name;

    private String gender;

    private Date dateOfBirth;

    private String major;

    private Integer dormitoryId;

    private Integer initialScore;

    
}