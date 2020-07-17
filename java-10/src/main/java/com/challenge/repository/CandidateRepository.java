package com.challenge.repository;

import com.challenge.entity.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CandidateRepository extends CrudRepository<Candidate, Long> {

    List<Candidate> findByIdAcceleration(Acceleration acceleration);

    List<Candidate> findByIdCompany(Company company);

    Optional<Candidate> findByIdUserAndIdCompanyAndIdAcceleration(User user, Company company, Acceleration acceleration);

    Optional<Candidate> findById(CandidateId candidateId);
}
