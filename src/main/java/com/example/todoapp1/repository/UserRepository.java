package com.example.todoapp1.repository;

import com.example.todoapp1.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
