package com.example.cqxt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cqxt.common.sin;
import com.example.cqxt.request.StudentRequest;
import com.example.cqxt.service.DailyCheckSrevice;
import jakarta.servlet.http.HttpSession;
@RestController
public class DailyCheckController {
    @Autowired
    private DailyCheckSrevice dailycheckSrevice;

    @PostMapping("/daily/myspace/dailycheck")
    public sin daliyCheckById(@RequestBody StudentRequest dailyRequest, HttpSession session){
        /* System.out.println(loginRequest.getUsename()); */
        return dailycheckSrevice.dailyCheckById(dailyRequest, session);
    }
}
