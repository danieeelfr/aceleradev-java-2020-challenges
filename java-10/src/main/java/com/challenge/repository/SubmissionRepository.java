package com.challenge.repository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface SubmissionRepository extends CrudRepository<Submission, Long> {

    List<Submission> findByIdChallengeId(Long challengeId);

    Submission findTopByOrderByScoreDesc();


    @Query(value = "select * from submission s " +
            "inner join challenge c " +
            "on s.challenge_id = c.id " +
            "inner join acceleration a " +
            "on a.challenge_id = c.id " +
            "where a.challenge_id = :challengeId " +
            "and a.id = :acellerationId ", nativeQuery = true)
    List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId, @Param("acellerationId") Long acellerationId);





}