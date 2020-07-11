package com.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
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
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "full_name")
    @Size(max = 100)
    @NotNull
    @NotBlank
    private String fullName;

    @Size(max = 100)
    @Column(name = "email")
    @Email
    @NotNull
    @NotBlank
    private String email;

    @Size(max = 50)
    @Column(name = "nickname")
    @NotNull
    @NotBlank
    private String nickname;

    @Size(max = 255)
    @NotNull
    @NotBlank
    @Column(name = "password")
    private String password;

    @Column(name = "created_at")
    @CreatedDate
    @NotNull
    private Date createdAt;

    @OneToMany()
    private Set<Candidate> candidates;

    @OneToMany()
    private Set<Submission> submissions;

}
