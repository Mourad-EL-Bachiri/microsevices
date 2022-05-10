package com.giantLink.user.controller;

import com.giantLink.user.request.UserRequest;
import com.giantLink.user.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    private final IUserService userService;

    @PostMapping
    public void registerUser(@RequestBody UserRequest userRequest){
        log.info("new user registration {}", userRequest);
        userService.addUser(userRequest);
    }
}
