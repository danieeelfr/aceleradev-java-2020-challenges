package com.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(schema = "codenation")
public class Acceleration implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    public int id;

    @Column(name = "name")
    @Size(max = 100)
    @NotNull
    @NotBlank
    public String name;

    @Column(name = "slug")
    @Size(max = 50)
    @NotNull
    @NotBlank
    public String slug;

    @Column(name = "created_at")
    @CreatedDate
    @NotNull
    public Date createdAt;

    @OneToMany()
    private Set<Candidate> candidates;

    @ManyToOne
    @JoinColumn(name = "challenge_id")
    private Challenge challenge;

}