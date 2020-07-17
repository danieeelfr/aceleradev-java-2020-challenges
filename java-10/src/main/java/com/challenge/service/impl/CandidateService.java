package com.challenge.service.impl;

import com.challenge.entity.*;
import com.challenge.repository.CandidateRepository;
import com.challenge.service.interfaces.CandidateServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService implements CandidateServiceInterface {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private  UserService userService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private AccelerationService accelerationService;

    @Override
    public Candidate save(Candidate object) {
        return this.candidateRepository.save(object);
    }

    @Override
    public Optional<Candidate> findById(CandidateId id) {
        return candidateRepository.findById(id);
    }

    @Override
    public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId) {
        User user = userService.findById(userId).orElse(null);
        Company company = companyService.findById(companyId).orElse(null);
        Acceleration acceleration = accelerationService.findById(accelerationId).orElse(null);
        return candidateRepository.findByIdUserAndIdCompanyAndIdAcceleration(user,company,acceleration);
    }

    @Override
    public List<Candidate> findByCompanyId(Long companyId) {
        Company company = companyService.findById(companyId).orElse(null);
        return candidateRepository.findByIdCompany(company);
    }
    @Override
    public List<Candidate> findByAccelerationId(Long accelerationId) {
        Acceleration acceleration = accelerationService.findById(accelerationId).orElse(null);
        return candidateRepository.findByIdAcceleration(acceleration);
    }
}
