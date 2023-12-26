package com.example.todoapp1.model.todo.dto.category;

import com.example.todoapp1.model.todo.Category;
import com.example.todoapp1.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryCreateReq {
    private Long id;
    private String name;


    public Category toEntity(Long priority, User user){
        return Category.builder().name(this.name).priority(priority).user(user).build();
    }
}
