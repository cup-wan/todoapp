package com.example.todoapp1.model.todo.dto.category;

import com.example.todoapp1.model.todo.Category;
import com.example.todoapp1.model.todo.Todo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryReadDto {
    private Long id;
    private String name;
    private Long priority;
}
