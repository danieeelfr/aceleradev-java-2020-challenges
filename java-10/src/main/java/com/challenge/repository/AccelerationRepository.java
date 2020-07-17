package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AccelerationRepository extends CrudRepository<Acceleration,Long> {

    List<Acceleration> findByCandidatesIdCompanyId(Long companyId);

    Optional<Acceleration> findByName(String name);

}
