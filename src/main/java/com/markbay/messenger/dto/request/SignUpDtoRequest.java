package com.markbay.messenger.dto.request;

import com.markbay.messenger.entities.Status;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Data
@AllArgsConstructor
public class SignUpDtoRequest {
    private String fullName;
    private String userName;
}
