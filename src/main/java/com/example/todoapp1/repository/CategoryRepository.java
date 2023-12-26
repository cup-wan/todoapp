package com.example.todoapp1.repository;

import com.example.todoapp1.model.todo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    public Category findByName(String name);
    public Long countByUserId(Long userId);
}
