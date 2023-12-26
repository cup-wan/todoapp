package com.example.todoapp1.model.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private String nickName;

    @Column
//    @ColumnDefault("ROLE_USER")
    private String role;

    @CreationTimestamp
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate withdrawAt;
}
