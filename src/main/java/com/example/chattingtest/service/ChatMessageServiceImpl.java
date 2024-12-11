package com.example.chattingtest.service;

import com.example.chattingtest.dto.ChatMessageRequestDto;
import com.example.chattingtest.entity.ChatMessage;
import com.example.chattingtest.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatMessageServiceImpl implements ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;

    @Autowired
    public ChatMessageServiceImpl(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    @Override
    public void saveChatMessage(String chatRoomId, ChatMessageRequestDto chatMessageDto) {
        ChatMessage chatMessage = ChatMessage.builder()
                .roomId(chatRoomId)
                .username(chatMessageDto.getUsername())
                .message(chatMessageDto.getMessage())
                .build();

        chatMessageRepository.save(chatMessage);
    }
}
