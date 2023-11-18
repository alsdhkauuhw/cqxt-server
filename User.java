[33mcommit d37e30d143e42fb7330b1686662e80fa9b965cbb[m[33m ([m[1;36mHEAD -> [m[1;32mmaster[m[33m)[m
Author: cc <Asuka@163.com>
Date:   Sat Nov 18 15:42:41 2023 +0800

    注册功能完成

[1mdiff --git a/src/main/java/com/example/cqxt/beans/User.java b/src/main/java/com/example/cqxt/beans/User.java[m
[1mindex a890aed..df12810 100644[m
[1m--- a/src/main/java/com/example/cqxt/beans/User.java[m
[1m+++ b/src/main/java/com/example/cqxt/beans/User.java[m
[36m@@ -1,5 +1,8 @@[m
 package com.example.cqxt.beans;[m
 [m
[32m+[m[32mimport lombok.Data;[m
[32m+[m
[32m+[m[32m@Data[m
 public class User {[m
     private Integer id;[m
 [m
[36m@@ -17,67 +20,4 @@[m [mpublic class User {[m
 [m
     private String name;[m
 [m
[31m-    public int getId() {[m
[31m-        return id;[m
[31m-    }[m
[31m-[m
[31m-    public void setId(Integer id) {[m
[31m-        this.id = id;[m
[31m-    }[m
[31m-[m
[31m-    public String getUsername() {[m
[31m-        return username;[m
[31m-    }[m
[31m-[m
[31m-    public void setUsername(String username) {[m
[31m-        this.username = username == null ? null : username.trim();[m
[31m-    }[m
[31m-[m
[31m-    public String getPassword() {[m
[31m-        return password;[m
[31m-    }[m
[31m-[m
[31m-    public void setPassword(String password) {[m
[31m-        this.password = password == null ? null : password.trim();[m
[31m-    }[m
[31m-[m
[31m-    public Boolean getSex() {[m
[31m-        return sex;[m
[31m-    }[m
[31m-[m
[31m-    public void setSex(Boolean sex) {[m
[31m-        this.sex = sex;[m
[31m-    }[m
[31m-[m
[31m-    public String getPhonenum() {[m
[31m-        return phonenum;[m
[31m-    }[m
[31m-[m
[31m-    public void setPhonenum(String phonenum) {[m
[31m-        this.phonenum = phonenum == null ? null : phonenum.trim();[m
[31m-    }[m
[31m-[m
[31m-    public String getEmail() {[m
[31m-        return email;[m
[31m-    }[m
[31m-[m
[31m-    public void setEmail(String email) {[m
[31m-        this.email = email == null ? null : email.trim();[m
[31m-    }[m
[31m-[m
[31m-    public String getAvatar() {[m
[31m-        return avatar;[m
[31m-    }[m
[31m-[m
[31m-    public void setAvatar(String avatar) {[m
[31m-        this.avatar = avatar == null ? null : avatar.trim();[m
[31m-    }[m
[31m-[m
[31m-    public String getName() {[m
[31m-        return name;[m
[31m-    }[m
[31m-[m
[31m-    public void setName(String name) {[m
[31m-        this.name = name == null ? null : name.trim();[m
[31m-    }[m
 }[m
\ No newline at end of file[m
[1mdiff --git a/src/main/java/com/example/cqxt/controller/UserController.java b/src/main/java/com/example/cqxt/controller/UserController.java[m
[1mindex ef0fd02..26060d5 100644[m
[1m--- a/src/main/java/com/example/cqxt/controller/UserController.java[m
[1m+++ b/src/main/java/com/example/cqxt/controller/UserController.java[m
[36m@@ -8,6 +8,7 @@[m [mimport org.springframework.web.bind.annotation.RestController;[m
 import com.example.cqxt.common.sin;[m
 import com.example.cqxt.request.UserRequest;[m
 import com.example.cqxt.service.UserSrevice;[m
[32m+[m
 import jakarta.servlet.http.HttpSession;[m
 [m
 @RestController[m
[36m@@ -21,4 +22,19 @@[m [mpublic class UserController {[m
         /* System.out.println(loginRequest.getUsename()); */[m
         return userSrevice.loginStatus(loginRequest, session);[m
     }[m
[32m+[m
[32m+[m[32m    @PostMapping("/user/signup/checkusername")[m
[32m+[m[32m    public sin checkUsername(@RequestBody UserRequest checkRequest, HttpSession session){[m
[32m+[m[32m        return userSrevice.checkUsername(checkRequest, session);[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    @PostMapping("/user/signup/checkemail")[m
[32m+[m[32m    public sin checkemail(@RequestBody UserRequest checkRequest, HttpSession session){[m
[32m+[m[32m        return userSrevice.checkEmail(checkRequest, session);[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    @PostMapping("/user/signup/insert")[m
[32m+[m[32m    public sin signup(@RequestBody UserRequest signupRequest, HttpSession session){[m
[32m+[m[32m        return userSrevice.signup(signupRequest, session);[m
[32m+[m[32m    }[m
 }[m
[1mdiff --git a/src/main/java/com/example/cqxt/mapper/UserMapper.java b/src/main/java/com/example/cqxt/mapper/UserMapper.java[m
[1mindex ff1bc94..eb4ad0a 100644[m
[1m--- a/src/main/java/com/example/cqxt/mapper/UserMapper.java[m
[1m+++ b/src/main/java/com/example/cqxt/mapper/UserMapper.java[m
[36m@@ -7,7 +7,7 @@[m [mpublic interface UserMapper {[m
 [m
     int insert(User record);[m
 [m
[31m-    int insertSelective(User record);[m
[32m+[m[32m    void insertSelective(User record);[m
 [m
     User selectByPrimaryKey(Integer id);[m
 [m
[36m@@ -17,5 +17,7 @@[m [mpublic interface UserMapper {[m
 [m
     User selectByUsernamePassword(String username, String password);[m
 [m
[31m-    //List<User> selectUserByName(String name);[m
[32m+[m[32m    User selectByUsername(String username);[m
[32m+[m
[32m+[m[32m    User selectByEmail(String email);[m
 }[m
\ No newline at end of file[m
[1mdiff --git a/src/main/java/com/example/cqxt/request/UserRequest.java b/src/main/java/com/example/cqxt/request/UserRequest.java[m
[1mindex 57e470c..b765954 100644[m
[1m--- a/src/main/java/com/example/cqxt/request/UserRequest.java[m
[1m+++ b/src/main/java/com/example/cqxt/request/UserRequest.java[m
[36m@@ -13,7 +13,9 @@[m [mpublic class UserRequest {[m
       private String password;[m
       private boolean sex;[m
       private String phonenum;[m
[32m+[m[32m      @JsonProperty("email")[m
       private String email;[m
       private String avatar;[m
[32m+[m[32m      @JsonProperty("name")[m
       private String name;[m
 }[m
[1mdiff --git a/src/main/java/com/example/cqxt/service/UserSrevice.java b/src/main/java/com/example/cqxt/service/UserSrevice.java[m
[1mindex 45a148e..99d1b33 100644[m
[1m--- a/src/main/java/com/example/cqxt/service/UserSrevice.java[m
[1m+++ b/src/main/java/com/example/cqxt/service/UserSrevice.java[m
[36m@@ -12,4 +12,7 @@[m [mpublic interface UserSrevice {[m
 [m
     sin loginStatus(UserRequest loginRequest, HttpSession session);[m
     boolean verityPasswd(String username, String password);[m
[32m+[m[32m    sin checkUsername(UserRequest checkRequest, HttpSession session);[m
[32m+[m[32m    sin checkEmail(UserRequest checkRequest, HttpSession session);[m
[32m+[m[32m    sin signup(UserRequest signupRequest, HttpSession session);[m
 }[m
[1mdiff --git a/src/main/java/com/example/cqxt/service/impi/UserServiceImpi.java b/src/main/java/com/example/cqxt/service/impi/UserServiceImpi.java[m
[1mindex ade0f4e..deb9657 100644[m
[1m--- a/src/main/java/com/example/cqxt/service/impi/UserServiceImpi.java[m
[1m+++ b/src/main/java/com/example/cqxt/service/impi/UserServiceImpi.java[m
[36m@@ -1,5 +1,6 @@[m
 package com.example.cqxt.service.impi;[m
 [m
[32m+[m[32mimport org.apache.ibatis.jdbc.Null;[m
 import org.springframework.beans.factory.annotation.Autowired;[m
 import org.springframework.stereotype.Service;[m
 [m
[36m@@ -38,5 +39,47 @@[m [mpublic class UserServiceImpi implements UserSrevice{[m
             return false;[m
         }[m
     }[m
[32m+[m
[32m+[m[32m    @Override[m
[32m+[m[32m    public sin checkUsername(UserRequest checkRequest, HttpSession session) {[m
[32m+[m[32m        // TODO Auto-generated method stub[m
[32m+[m[32m        String username = checkRequest.getUsename();[m
[32m+[m[32m        if(usermapper.selectByUsername(username) != null){[m
[32m+[m[32m            return sin.error("该账号已被使用");[m
[32m+[m[32m        }else {[m
[32m+[m[32m            return sin.success("该账号可以使用");[m
[32m+[m[32m        }[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    @Override[m
[32m+[m[32m    public sin checkEmail(UserRequest checkRequest, HttpSession session) {[m
[32m+[m[32m        // TODO Auto-generated method stub[m
[32m+[m[32m        String email = checkRequest.getEmail();[m
[32m+[m[32m        if(usermapper.selectByEmail(email) != null){[m
[32m+[m[32m            return sin.error("该邮箱已被使用");[m
[32m+[m[32m        }else {[m
[32m+[m[32m            return sin.success("该邮箱可以使用");[m
[32m+[m[32m        }[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    @Override[m
[32m+[m[32m    public sin signup(UserRequest signupRequest, HttpSession session) {[m
[32m+[m[32m        // TODO Auto-generated method stub[m
[32m+[m[32m        User user = new User();[m
[32m+[m[32m        //user.setId(signupRequest.getId());[m
[32m+[m[32m        user.setUsername(signupRequest.getUsename());[m
[32m+[m[32m        user.setPassword(signupRequest.getPassword());[m
[32m+[m[32m        //user.setSex(signupRequest.isSex());[m
[32m+[m[32m        //user.setPhonenum(signupRequest.getPhonenum());[m
[32m+[m[32m        user.setEmail(signupRequest.getEmail());[m
[32m+[m[32m        //user.setAvatar(signupRequest.getAvatar());[m
[32m+[m[32m        user.setName(signupRequest.getName());[m
[32m+[m[32m        usermapper.insertSelective(user);[m
[32m+[m[32m        if (usermapper.selectByUsername(user.getUsername()) != null) {[m
[32m+[m[32m            return sin.success("注册成功");[m
[32m+[m[32m        }else{[m
[32m+[m[32m            return sin.error("注册失败");[m
[32m+[m[32m        }[m
[32m+[m[32m    }[m
     [m
 }[m
[1mdiff --git a/src/main/resources/com/example/cqxt/mapper/UserMapper.xml b/src/main/resources/com/example/cqxt/mapper/UserMapper.xml[m
[1mindex 6c371b5..3596e5c 100644[m
[1m--- a/src/main/resources/com/example/cqxt/mapper/UserMapper.xml[m
[1m+++ b/src/main/resources/com/example/cqxt/mapper/UserMapper.xml[m
[36m@@ -20,6 +20,21 @@[m
     from user[m
     where id = #{id,jdbcType=INTEGER}[m
   </select>[m
[32m+[m
[32m+[m[32m  <select id="selectByUsername" parameterType="java.lang.String" resultMap="BaseResultMap">[m
[32m+[m[32m    select[m
[32m+[m[32m    <include refid="Base_Column_List" />[m
[32m+[m[32m    from User[m
[32m+[m[32m    where username = #{username, jdbcType=VARCHAR}[m[41m [m
[32m+[m[32m  </select>[m
[32m+[m
[32m+[m[32m  <select id="selectByEmail" parameterType="java.lang.String" resultMap="BaseResultMap">[m
[32m+[m[32m    select[m
[32m+[m[32m    <include refid="Base_Column_List" />[m
[32m+[m[32m    from User[m
[32m+[m[32m    where email = #{email, jdbcType=VARCHAR}[m
[32m+[m[32m  </select>[m
[32m+[m
   <select id="selectByUsernamePassword" parameterType="java.lang.String" resultMap="BaseResultMap">[m
     select[m
     <include refid="Base_Column_List" />[m
