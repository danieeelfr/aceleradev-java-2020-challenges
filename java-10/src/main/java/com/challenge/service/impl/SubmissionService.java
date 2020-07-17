package com.challenge.service.impl;

import com.challenge.entity.Submission;
import com.challenge.repository.ChallengeRepository;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Service
public class SubmissionService implements SubmissionServiceInterface {

    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private ChallengeRepository challengeRepository;

    @Autowired
    private CandidateService candidateService;

    @Override
    public Submission save(Submission object) {
        return this.submissionRepository.save(object);
    }

    @Override

    public BigDecimal findHigherScoreByChallengeId(Long challengeId) {

        BigDecimal result;
        List<Submission> submission = submissionRepository.findByIdChallengeId(challengeId);

        if (submission.size() != 0) {
            float higherScore = submissionRepository.findTopByOrderByScoreDesc().getScore();
            result = new BigDecimal(Float.toString(higherScore));


        } else {
            result = new BigDecimal(BigInteger.ZERO);
        }

        return result;

    }

    @Override
    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        return submissionRepository.findByChallengeIdAndAccelerationId(challengeId,accelerationId);
    }

}
