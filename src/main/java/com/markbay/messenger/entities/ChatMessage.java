package com.markbay.messenger.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
@Entity
public class ChatMessage {
    @Id
    private Long Id;
    private String chatId;
    private String senderId;
    private String recipientId;
    private String Content;
    private LocalDateTime timestamp;

}
