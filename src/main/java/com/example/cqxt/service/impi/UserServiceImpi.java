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

    @Override
    public sin checkUsername(UserRequest checkRequest, HttpSession session) {
        // TODO Auto-generated method stub
        String username = checkRequest.getUsename();
        if(usermapper.selectByUsername(username) != null){
            return sin.error("该账号已被使用");
        }else {
            return sin.success("该账号可以使用");
        }
    }

    @Override
    public sin checkEmail(UserRequest checkRequest, HttpSession session) {
        // TODO Auto-generated method stub
        String email = checkRequest.getEmail();
        if(usermapper.selectByEmail(email) != null){
            return sin.error("该邮箱已被使用");
        }else {
            return sin.success("该邮箱可以使用");
        }
    }

    @Override
    public sin signup(UserRequest signupRequest, HttpSession session) {
        // TODO Auto-generated method stub
        User user = new User();
        //user.setId(signupRequest.getId());
        user.setUsername(signupRequest.getUsename());
        user.setPassword(signupRequest.getPassword());
        //user.setSex(signupRequest.isSex());
        //user.setPhonenum(signupRequest.getPhonenum());
        user.setEmail(signupRequest.getEmail());
        //user.setAvatar(signupRequest.getAvatar());
        user.setName(signupRequest.getName());
        usermapper.insertSelective(user);
        if (usermapper.selectByUsername(user.getUsername()) != null) {
            return sin.success("注册成功");
        }else{
            return sin.error("注册失败");
        }
    } 
    
}
