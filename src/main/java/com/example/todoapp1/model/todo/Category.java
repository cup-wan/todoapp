package com.example.todoapp1.model.todo;

import com.example.todoapp1.model.todo.dto.category.CategoryReadDto;
import com.example.todoapp1.model.todo.dto.schedule.ScheduleReadReq;
import com.example.todoapp1.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Long priority;

    @Column(nullable = false)
    private String name;

    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public Category(Long priority, String name, User user){
        this.priority = priority;
        this.name = name;
        this.user = user;
    }

    public void update(Category category) {
        this.name = category.getName();
    }
}
