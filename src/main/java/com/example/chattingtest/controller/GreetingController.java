package com.example.chattingtest.controller;

import com.example.chattingtest.dto.Greeting;
import com.example.chattingtest.dto.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")  // pub/chatting/hello로 보낸 메시지 처리
    @SendTo("/topic/greetings")  // sub/chatting/topic/greetings를 구독 중인 클라이언트에게 메시지 전송
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000);
        return new Greeting("Hello " + HtmlUtils.htmlEscape(message.getName()) + " !");
    }

}
