package com.giantLink.user.service.impl;

import com.giantLink.user.entity.User;
import com.giantLink.user.repository.UserRepository;
import com.giantLink.user.request.UserRequest;
import com.giantLink.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(UserRequest userRequest) {
        User user = User.builder()
                .firstName(userRequest.firstName())
                .lastName(userRequest.lastName())
                .email(userRequest.email())
                .build();
        //todo:  check if email valid
        //todo: check if email not taken
        //todo: store user in db
        userRepository.save(user);
    }
}
