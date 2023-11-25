package com.example.cqxt.service.impi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cqxt.beans.DailyCheck;
import com.example.cqxt.beans.Student;
import com.example.cqxt.common.sin;
import com.example.cqxt.mapper.DailyCheckMapper;
import com.example.cqxt.mapper.StudentMapper;
import com.example.cqxt.request.StudentRequest;
import com.example.cqxt.service.DailyCheckSrevice;

import jakarta.servlet.http.HttpSession;
@Service
public class DailyCheckSreviceimpi implements DailyCheckSrevice{

    @Autowired
        private StudentMapper studentMapper;
    @Autowired
        private DailyCheckMapper dailyCheckMapper;
    @Override
    public sin dailyCheckById(StudentRequest dailyRequest, HttpSession session) {
        // TODO Auto-generated method stub
        Student student = new Student();
        List<DailyCheck> dailyCheck = new ArrayList<>();
        student = studentMapper.selectByUserId(dailyRequest.getUserId());
        dailyCheck = dailyCheckMapper.selectByStudentId(student.getStudentId());
        if (dailyCheck != null) {
            return sin.success("搜索成功", dailyCheck.get(dailyCheck.size() - 1));
        } else {
            return sin.error("搜索失败");
        }
    }
    
}
