package com.example.chattingtest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ChatMessageResponseDto {
    private String username;
    private String message;
}
