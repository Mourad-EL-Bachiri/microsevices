package com.giantLink.user.service.impl;

import com.giantLink.user.entity.User;
import com.giantLink.user.repository.UserRepository;
import com.giantLink.user.request.UserRequest;
import com.giantLink.user.response.FraudResponse;
import com.giantLink.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class userServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addUser(UserRequest userRequest) {
        User user = User.builder()
                .firstName(userRequest.firstName())
                .lastName(userRequest.lastName())
                .email(userRequest.email())
                .build();
        userRepository.saveAndFlush(user);
        //todo:  check if email valid
        //todo: check if email not taken
        //todo: check isFraudster
        restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{userId}",
                FraudResponse.class,
                user.getId()
                );
        //todo: store user in db

        //todo: send nofification
    }
}
