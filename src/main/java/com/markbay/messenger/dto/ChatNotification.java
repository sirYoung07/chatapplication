package com.markbay.messenger.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatNotification {
    private Long id;
    private String SenderId;
    private String recipientId;
    private String Content;

}
