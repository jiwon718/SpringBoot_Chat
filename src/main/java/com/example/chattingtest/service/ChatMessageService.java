package com.example.chattingtest.service;

import com.example.chattingtest.dto.ChatMessageRequestDto;

public interface ChatMessageService {

    void saveChatMessage(String chatRoomId, ChatMessageRequestDto chatMessageDto);
}
