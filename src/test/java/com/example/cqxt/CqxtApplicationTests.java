package com.example.cqxt;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.cqxt.beans.DailyCheck;
import com.example.cqxt.beans.Student;
import com.example.cqxt.mapper.DailyCheckMapper;
import com.example.cqxt.mapper.StudentMapper;
import com.example.cqxt.mapper.UserMapper;

@SpringBootTest
class CqxtApplicationTests {
	@Autowired
	private UserMapper usermapper;
	@Autowired
	private DailyCheckMapper dailyCheckMapper;
	@Autowired
	private StudentMapper studentMapper;
	/* @Test
	void contextLoads() {
		User user = new User();
		user.setId(005);
		user.setUsername("1145");
		user.setEmail("3031609510@qq.com");
		user.setPhonenum("13662331413");
		user.setAvatar("sada");
		user.setSex(true);
		user.setPassword("114514");
		user.setName("asda");
		usermapper.insert(user);
	} */
/* 	@Test
	void selectTest(){
		Student student = new Student();
		student.setStudentId(123455);
		student.setUserId(2);
		student.setName("梨花");
		student.setGender("女");
		student.setMajor("2021");		
		student.setDormitoryId(233);
		student.setInitialScore(100);
		studentMapper.insert(student);

    } */
}

