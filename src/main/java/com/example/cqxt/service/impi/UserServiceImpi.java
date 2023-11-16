package com.example.cqxt.service.impi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cqxt.beans.User;
import com.example.cqxt.common.sin;
import com.example.cqxt.mapper.UserMapper;
import com.example.cqxt.request.UserRequest;
import com.example.cqxt.service.UserSrevice;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpi implements UserSrevice{

    @Autowired
    private UserMapper usermapper;
    @Override
    public sin loginStatus(UserRequest loginRequest, HttpSession session) {
        String username = loginRequest.getUsename();
        String password = loginRequest.getPassword();
        if (this.verityPasswd(username, password)) {
            session.setAttribute("username", username);
            User user = new User();
            user.setUsername(username);
            return sin.success("登入成功");
        }else{
            return sin.error("用户名或密码错误");
        }
    }

    @Override
    public boolean verityPasswd(String username, String password) {
        if (usermapper.selectByUsernamePassword(username, password) != null) {
            return true;
        }else{
            return false;
        }
    }
    
}
