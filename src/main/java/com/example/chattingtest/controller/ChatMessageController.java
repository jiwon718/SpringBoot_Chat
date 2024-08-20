package com.example.chattingtest.controller;

import com.example.chattingtest.dto.ChatMessageRequestDto;
import com.example.chattingtest.dto.ChatMessageResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class ChatMessageController {

    @MessageMapping("/chat/rooms/{roomId}")  // pub/chat/rooms/{roomId}로 보낸 메시지 처리
    @SendTo("/sub/chat/rooms/{roomId}")  // sub/chat/rooms/{roomId}를 구독 중인 클라이언트에게 메시지 전송
    public ChatMessageResponseDto sendMessage(@DestinationVariable String roomId, @Payload ChatMessageRequestDto chatMessageRequestDto) throws Exception {
        log.info(roomId + "로부터 메시지가 도착했습니다.");
        return ChatMessageResponseDto.builder()
                .username(chatMessageRequestDto.getUsername())
                .message(chatMessageRequestDto.getMessage())
                .build();
    }

}
