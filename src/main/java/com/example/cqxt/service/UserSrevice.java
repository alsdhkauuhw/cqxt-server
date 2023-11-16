package com.example.cqxt.service;

import org.springframework.stereotype.Service;

import com.example.cqxt.common.sin;
import com.example.cqxt.request.UserRequest;

import jakarta.servlet.http.HttpSession;

@Service
public interface UserSrevice {

    sin loginStatus(UserRequest loginRequest, HttpSession session);
    boolean verityPasswd(String username, String password);
}
