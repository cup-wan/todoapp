package com.example.todoapp1.model.todo.dto.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryReadRes {
    private List<CategoryReadDto> categories;
}
