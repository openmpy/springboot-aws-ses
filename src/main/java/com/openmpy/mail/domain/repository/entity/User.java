package com.openmpy.mail.domain.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tId;

    @Column
    private String email;

    @Column(nullable = false)
    private Boolean isValid;
}
