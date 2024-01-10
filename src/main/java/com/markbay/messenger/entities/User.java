package com.markbay.messenger.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;
    private String fullName;
    @Column(unique = true)
    private String userName;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User(String fullName, String userName,  LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.fullName = fullName;
        this.userName = userName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
