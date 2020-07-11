package com.challenge.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Embeddable
@Data
public class CandidateIdentity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    private User user;

    @ManyToOne
    @JoinColumn(name = "acceleration_id", nullable = false)
    @NotNull
    private Acceleration acceleration;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    @NotNull
    private Company company;
}
