package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends CrudRepository<Company, Long> {

    List<Company> findDistinctNameByCandidatesIdAccelerationId(Long accelerationId);

    List<Company> findByCandidatesIdUserId(Long userId);
}