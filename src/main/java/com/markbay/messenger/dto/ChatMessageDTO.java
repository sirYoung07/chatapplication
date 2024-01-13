package com.markbay.messenger.dto;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessageDTO {

    private String content;
    private String sender;
    private MessageType type;

}
