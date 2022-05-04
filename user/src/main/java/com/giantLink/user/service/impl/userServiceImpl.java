package com.giantLink.user.service.impl;

import com.giantLink.clients.fraud.FraudClient;
import com.giantLink.clients.fraud.FraudResponse;
import com.giantLink.clients.notifications.NotificationClient;
import com.giantLink.clients.notifications.NotificationRequest;
import com.giantLink.user.entity.User;
import com.giantLink.user.repository.UserRepository;
import com.giantLink.user.request.UserRequest;
import com.giantLink.user.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class userServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

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
//        restTemplate.getForObject(
//                "http://FRAUD/api/v1/fraud-check/{userId}",
//                FraudResponse.class,
//                user.getId()
//                );
        FraudResponse fraudResponse = fraudClient.isFraudster(user.getId());

        // send nofification
        notificationClient.sendNotification(
                new NotificationRequest(
                        user.getId(),
                        user.getEmail(),
                        String.format("Hello %s, welcome to te hell", user.getFirstName())
                )
        );
    }
}
