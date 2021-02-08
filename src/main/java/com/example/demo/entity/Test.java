package com.example.demo.entity;

import org.springframework.stereotype.Component;
import org.yeauty.annotation.OnMessage;
import org.yeauty.annotation.ServerEndpoint;
import org.yeauty.pojo.Session;

public class Test {

    @OnMessage
    public void test(Session session, String message) {
        session.sendText("哈哈哈");
    }
}
