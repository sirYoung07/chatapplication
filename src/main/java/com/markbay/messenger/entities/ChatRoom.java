package com.markbay.messenger.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class ChatRoom {
    @Id
    private Long id;
    private String chatId;
    private String senderId;
    private String recipientId;

}
