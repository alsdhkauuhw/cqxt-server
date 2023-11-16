package com.example.cqxt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.cqxt.beans.User;
import com.example.cqxt.mapper.UserMapper;

@SpringBootTest
class CqxtApplicationTests {
	@Autowired
	private UserMapper usermapper;
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
	@Test
	void selectTest(){
		System.out.println(1);
		User user = usermapper.selectByUsernamePassword("114514", "114514");
		if (user.getId() != 1) {
			System.out.println("错误");
		}
		System.out.println("1111");
		System.out.println(user.getId());
	}

}
