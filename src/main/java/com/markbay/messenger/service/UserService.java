package com.markbay.messenger.service;

import com.markbay.messenger.dto.request.SignUpDtoRequest;
import com.markbay.messenger.dto.response.SignUpDtoResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
        SignUpDtoResponse registerUser(SignUpDtoRequest request);
}
