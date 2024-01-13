package com.markbay.messenger.service;

import com.markbay.messenger.entities.ChatRoom;
import com.markbay.messenger.repositories.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Spliterator;

@RequiredArgsConstructor
@Service
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    public Optional<String> getChatRoomId(String senderId, String recipientId, boolean createNewRoomIfNotExist){
        return chatRoomRepository.findBySenderIdAndRecipientId(senderId, recipientId)
            .map(ChatRoom::getChatId)

            .or(() -> {
                if(createNewRoomIfNotExist){
                    var chatId = createChat(senderId, recipientId);
                    return Optional.of(chatId);
                }
                return Optional.empty();
            });

    }

    private String createChat(String senderId, String recipientId) {
        var chatId = String.format("%s_%s", senderId, recipientId);
        ChatRoom senderRecipient = ChatRoom.builder()
            .chatId(chatId)
            .senderId(senderId)
            .recipientId(recipientId)
            .build();

        ChatRoom recipientSender = ChatRoom.builder()
            .chatId(chatId)
            .senderId(recipientId)
            .recipientId(senderId)
            .build();

        chatRoomRepository.save(senderRecipient);
        chatRoomRepository.save(recipientSender);
        return chatId;
    }
}
