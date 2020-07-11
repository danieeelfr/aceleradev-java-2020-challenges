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
public class Submission implements Serializable {

    @Column(name = "score")
    @NotNull
    public float score;
    @Column(name = "created_at")
    @CreatedDate
    @NotNull
    public Date createdAt;
    @EmbeddedId
    SubmissionIdentity submissionIdentity;

}
