package com.example.chattingtest.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "chatmessage")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ChatMessage {

    @Id
    private String id;
    private String roomId;
    private String username;
    private String message;
    @CreatedDate
    private Instant createdTime;

}
