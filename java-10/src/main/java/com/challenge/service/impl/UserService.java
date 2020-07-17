package com.challenge.service.impl;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import com.challenge.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Optional<User> findById(Long userId) {

        return this.userRepository.findById(userId);
    }

    @Override
    public User save(User user) {

        return userRepository.save(user);
    }

    @Override
    public List<User> findByAccelerationName(String name) {
        return userRepository.findByCandidatesIdAccelerationName(name);
    }

    @Override
    public List<User> findByCompanyId(Long companyId) {
        return userRepository.findByCandidatesIdCompanyId(companyId);
    }

}