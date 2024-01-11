package com.markbay.messenger.service;


import com.markbay.messenger.dto.request.SignUpDtoRequest;
import com.markbay.messenger.dto.response.SignUpDtoResponse;
import com.markbay.messenger.entities.Status;
import com.markbay.messenger.entities.User;
import com.markbay.messenger.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    Logger logger = LoggerFactory.getLogger(Service.class);

    private final UserRepository userRepository;
    @Override
    public SignUpDtoResponse registerUser(SignUpDtoRequest request) {
        Optional<User> existingUser = userRepository.findByUserName(request.getUserName());

        if(existingUser.isPresent()){
            return new SignUpDtoResponse("This Username is not available", null);
        }

        User newUser = new User(
            request.getFullName(),
            request.getUserName(),
            LocalDateTime.now(),
            LocalDateTime.now()
        );

        newUser.setStatus(Status.ONLINE);

        userRepository.save(newUser);
        return new SignUpDtoResponse("User Registration Successful", newUser);

    }


//    public void DisconnetUser(String userName){
//
//        //TO DO
//    }

    public List<User> connectedUsers (){

        return userRepository.findAllByStatus(Status.ONLINE);

        //pagination:  TO DO
    }
}
