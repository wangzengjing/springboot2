package com.example.demo;

import com.example.demo.activemq.JmsComponent;
import com.example.demo.activemq.Message;
import com.example.demo.sendmail.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	JmsComponent jmsComponent;
	@Test
	public void contextLoads() {
		Message msg = new Message();
		msg.setContent("hello jms!");
		msg.setDate(new Date());
		jmsComponent.send(msg);
	}

	@Autowired
	MailService mailService;
	@Test
	public void sendSimpleMail(){
		mailService.sendSimpleMail("15813489443@163.com",
				"1197181836@qq.com",
				"1505815413@qq.com",
				"测试邮件主题",
				"测试邮件内容");
	}

	@Test
	public void sendAttachFileMail(){
		mailService.sendAttachFileMail("15813489443@163.com",
				"1197181836@qq.com",
				"测试邮件主题",
				"测试邮件内容",
				new File("E:\\66.jpg"));
	}


	@Test
	public void sendMailWithImg() {
		mailService.sendMailWithImg("15813489443@163.com",
				"1197181836@qq.com",
				"测试邮件主题(图片)",
				"<div>hello,这是一封带图片资源的邮件：" +
						"这是图片1：<div><img src='cid:p01'/></div>" +
						"这是图片2：<div><img src='cid:p02'/></div>" +
						"</div>",
				new String[]{"E:\\66.jpg",
						"E:\\66.jpg"},
				new String[]{"p01", "p02"});
	}
}
