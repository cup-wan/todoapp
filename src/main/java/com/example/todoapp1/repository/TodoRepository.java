package com.example.todoapp1.repository;

import com.example.todoapp1.model.todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// JpaRepository를 상속받는 interface를 만들어야함, JpaRepository<엔티티, 해당 엔티티의 기본키 타입>
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
