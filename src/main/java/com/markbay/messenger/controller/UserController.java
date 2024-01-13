package com.markbay.messenger.controller;

import com.markbay.messenger.dto.request.SignUpDtoRequest;
import com.markbay.messenger.dto.response.SignUpDtoResponse;
import com.markbay.messenger.service.UserServiceImpl;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @MessageMapping("/user/registerUser")
    @SendTo("/user/public")
    public SignUpDtoResponse registerUser (SignUpDtoRequest request){
        return userService.registerUser(request);
    }
}
