package com.giantLink.user.service.impl;

import com.giantLink.clients.fraud.FraudClient;
import com.giantLink.clients.fraud.FraudResponse;
import com.giantLink.user.entity.User;
import com.giantLink.user.repository.UserRepository;
import com.giantLink.user.request.UserRequest;
import com.giantLink.user.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class userServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;

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
//        restTemplate.getForObject(
//                "http://FRAUD/api/v1/fraud-check/{userId}",
//                FraudResponse.class,
//                user.getId()
//                );
        FraudResponse fraudResponse = fraudClient.isFraudster(user.getId());
        //todo: store user in db

        //todo: send nofification
    }
}
