package com.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
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
public class Challenge implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    public int id;

    @Column(name = "name")
    @Size(max = 100)
    @NotNull
    public String name;

    @Column(name = "slug")
    @Size(max = 50)
    @NotNull
    public String slug;

    @Column(name = "created_at")
    @CreatedDate
    @NotNull
    public Date createdAt;

    @OneToMany()
    @JoinColumn(name = "acceleration_id")
    private Set<Acceleration> accelerations;

    @OneToMany()
    private Set<Submission> submissions;
}