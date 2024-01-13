package com.markbay.messenger.repositories;

import com.markbay.messenger.entities.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
