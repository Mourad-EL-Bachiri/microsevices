package com.giantLink.fraud.services.Impl;

import com.giantLink.fraud.entities.Fraud;
import com.giantLink.fraud.repository.FraudRepository;
import com.giantLink.fraud.services.IFraudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class FraudServiceImpl implements IFraudService {

    @Autowired
    private FraudRepository fraudRepository;

    @Override
    public boolean isFraudulentUser(Integer userId) {
        fraudRepository.save(
                Fraud.builder()
                        .userId(userId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
