package com.challenge.service.impl;

import com.challenge.entity.Challenge;
import com.challenge.repository.ChallengeRepository;
import com.challenge.service.interfaces.ChallengeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ChallengeService implements ChallengeServiceInterface {

    @Autowired
    private ChallengeRepository challengeRepository;


    @Override
    public Challenge save(Challenge object) {
        return this.challengeRepository.save(object);
    }

    @Override
    public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
        return challengeRepository.findByAccelerationsIdAndSubmissionsIdUserId(accelerationId, userId);
    }

}