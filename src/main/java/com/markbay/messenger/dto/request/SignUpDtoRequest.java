package com.markbay.messenger.dto.request;

import com.markbay.messenger.entities.Status;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Data
public class SignUpDtoRequest {
    private String fullName;
    private String userName;
}
