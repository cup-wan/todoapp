package com.example.todoapp1.model.todo.dto.category;

import com.example.todoapp1.model.todo.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryOrderDto {
    private Long id;
    private Long originalPriority;
    private Long changeTo;
}
