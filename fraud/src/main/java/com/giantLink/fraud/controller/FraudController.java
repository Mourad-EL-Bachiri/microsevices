package com.giantLink.fraud.controller;

import com.giantLink.fraud.response.FraudResponse;
import com.giantLink.fraud.services.IFraudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fraud-check")
@Slf4j
public class FraudController {
    @Autowired
    IFraudService fraudService;

    @GetMapping(path = "{userId}")
    public FraudResponse isFraudster(@PathVariable("userId") Integer userId){

        boolean isFraudulentUser = fraudService.isFraudulentUser(userId);

        log.info("fraud check from user {}", userId);
        return new FraudResponse(isFraudulentUser);
    }
}
