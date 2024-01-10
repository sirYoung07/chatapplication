package com.markbay.messenger.dto.response;

import com.markbay.messenger.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data

public class SignUpDtoResponse {
    private String message;
    private User user;

    public SignUpDtoResponse(String message, User user) {
        this.message = message;
        this.user = user;
    }
}
