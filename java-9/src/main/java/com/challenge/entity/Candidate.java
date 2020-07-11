package com.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(schema = "codenation")
public class Candidate implements Serializable {
    @EmbeddedId
    private CandidateIdentity id;

    @Column(name = "status")
    @NotNull
    private int status;

    @Column(name = "created_at", updatable = false)
    @CreatedDate
    @NotNull
    private Date createdAt;
}
