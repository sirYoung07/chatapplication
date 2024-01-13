package com.markbay.messenger.controller;

import com.markbay.messenger.dto.ChatNotification;
import com.markbay.messenger.entities.ChatMessage;
import com.markbay.messenger.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate simpMessagingTemplate;
    private final ChatMessageService chatMessageService;

    @MessageMapping("/chat")
    public void processMessaages(@Payload ChatMessage chatMessage){
        ChatMessage savedMessage = chatMessageService.saveChatMessage(chatMessage);

        // John/queue/message
        simpMessagingTemplate.convertAndSendToUser(
            chatMessage.getRecipientId(), "/queue/message",
            ChatNotification.builder()
                .id(savedMessage.getId())
                .SenderId(savedMessage.getSenderId())
                .recipientId((savedMessage.getRecipientId()))
                .Content(savedMessage.getContent())

                .build()

        );

    }



    @GetMapping("/messages/{senderId}/{recipientId}")
    public ResponseEntity<List<ChatMessage>> findChatMessages(@PathVariable("senderId") String senderId, @PathVariable("recipientId") String recipientId){
        return ResponseEntity.ok(chatMessageService.findChatMessages(senderId, recipientId));
    }



    //@MessageMapping("/chat{to}")
//    @MessageMapping("/chat.sendMessage")
//    @SendTo("/topic/public")
//    public ChatMessageDTO sendMessage(@Payload ChatMessageDTO chatMessage){
//        return chatMessage;
//    }
//
//    @MessageMapping("/chat.addUser")
//    @SendTo("/topic/public")
//    public ChatMessageDTO addUser(@Payload ChatMessageDTO chatMessage, SimpMessageHeaderAccessor headerAccessor)
//    {
//        // Add username in web socket session
//        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
//        return chatMessage;
//    }





}
