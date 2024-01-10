package com.markbay.messenger.repositories;

import com.markbay.messenger.entities.Status;
import com.markbay.messenger.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);

    List<User> findAllByStatus(Status status);
}
