package com.giantLink.user.controller;

import com.giantLink.user.request.UserRequest;
import com.giantLink.user.response.UserResponse;
import com.giantLink.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping
    public void registerUser(@RequestBody UserRequest userRequest){
        log.info("new user registration {}", userRequest);
        userService.addUser(userRequest);
    }
}
