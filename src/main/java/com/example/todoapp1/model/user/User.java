package com.example.todoapp1.model.user;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class User {

    @Id
    private String id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String socialDomain;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private LocalDate createdAt;

    @Column(nullable = false)
    private LocalDate withdrawAt;
}
