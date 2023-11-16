package com.example.cqxt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cqxt.common.sin;
import com.example.cqxt.request.UserRequest;
import com.example.cqxt.service.UserSrevice;
import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {
    
    @Autowired
    private UserSrevice userSrevice;
    //登入
    @PostMapping("/user/login/status")
    public sin loginstatus(@RequestBody UserRequest loginRequest, HttpSession session){
        /* System.out.println(loginRequest.getUsename()); */
        return userSrevice.loginStatus(loginRequest, session);
    }
}
