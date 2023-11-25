package com.example.cqxt.service;

import org.springframework.stereotype.Service;

import com.example.cqxt.beans.DailyCheck;
import com.example.cqxt.common.sin;
import com.example.cqxt.request.StudentRequest;

import jakarta.servlet.http.HttpSession;
@Service
public interface DailyCheckSrevice {

    sin dailyCheckById(StudentRequest dailyRequest, HttpSession session);

}
