package com.example.demo;

import com.example.demo.entity.MyWebSocket;
import com.example.demo.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.Channel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.yeauty.annotation.OnMessage;
import org.yeauty.pojo.Session;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void contextLoads() {

//		redisTemplate.opsForValue().set("Test:set1", "testValue1");
//		redisTemplate.opsForSet().add("Test:set2", "asdf");
//		redisTemplate.opsForHash().put("hash1", "name1", "lms1");
//		redisTemplate.opsForHash().put("hash1", "name2", "lms2");
//		redisTemplate.opsForHash().put("hash1", "name3", "lms3");
		//对象
		/*List<User> list = new ArrayList<User>();
		User user = new User(1,"username");
		User user1 = new User(2,"username");
		User user2 = new User(3,"username");
		list.add(user);
		list.add(user1);
		list.add(user2);
		String[] strings =new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			strings[i]=list.get(i).toString();
		}
		ObjectMapper mapper = new ObjectMapper();

		redisTemplate.opsForValue().set("user",user);
		try {
			redisTemplate.opsForList().leftPushAll("list1",mapper.writeValueAsString(user),mapper.writeValueAsString(user1),mapper.writeValueAsString(user2));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}*/
		System.out.println(redisTemplate.hasKey("user"));
		System.out.println(redisTemplate.opsForHash().get("hash1", "name1"));

	}


}
