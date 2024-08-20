package com.example.chattingtest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration  // Spring 구성 클래스임을 나타냄
@EnableWebSocketMessageBroker  // 메시지 브로커의 지원을 받는 WebSocket 메시지 처리를 가능하게 함
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // 주어진 목적지 접두사를 가진 메시지들을 브로커가 처리하도록 설정
        // : 클라이언트가 구독할 수 있는 메시지 목적지의 접두사를 정의
        config.enableSimpleBroker("/sub");

        // 메시지 라우팅 경로 설정
        // : 클라이언트가 특정 경로로 메시지를 보낼 때, 해당 메시지를 애플리케이션 내의 특정 핸들러 메서드로 라우팅하기위한 접두사 설정
        //   = @MessageMapping 메서드 바인딩된 메시지의 접두사 지정
        config.setApplicationDestinationPrefixes("/pub");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 웹소켓 연결에 대한 endpoint 설정
        // : 해당 endpoint로 접속 시 웹소켓 연결
        // withSockJS(): SockJS를 사용하여 WebSocket이 지원되지 않는 환경에서도 폴백 메커니즘 제공
        registry.addEndpoint("/chat");
    }

}
