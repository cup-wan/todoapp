package com.example.todoapp1.service;

import com.example.todoapp1.model.todo.Category;
import com.example.todoapp1.model.todo.dto.category.CategoryCreateReq;
import com.example.todoapp1.model.todo.dto.category.CategoryReadRes;
import com.example.todoapp1.model.user.User;
import com.example.todoapp1.repository.CategoryRepository;
import com.example.todoapp1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public Category addCategory(CategoryCreateReq category) {
        // 카테고리 추가 로직 구현
        Long priority = countCategory(category.getId()) + 1L;
        Long userId = 1L;
        User user = userRepository.findById(userId).orElseThrow();
        Category result = category.toEntity(priority, user);
        log.info("result : " + result);
        return categoryRepository.save(result);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    Long countCategory(Long userId) {
        // 카테고리 개수 조회 로직 구현
        return (Long) categoryRepository.countByUserId(userId);
    }

    public List<String> searchNames() {
        // 모든 카테고리 이름 조회 로직 구현
        List<Category> categoryList = categoryRepository.findAll();
        List<String> categoryNames = new ArrayList<>(categoryList.size());
        for(Category category : categoryList) {
            categoryNames.add(category.getName());
        }
        return categoryNames;
    }

    public Category searchById(Long id) {
        // 카테고리 개별 조회 로직 구현
        return categoryRepository.findById(id).orElseThrow();
    }
    public List<Category> readCategory(CategoryReadRes categoryReadRes) {
        // 모든 카테고리 조회 로직 구현
        return categoryRepository.findAll();
    }

    public Category updateCategory(Long id, Category category) {
        // 카테고리 수정 로직 구현
        Category udCategory = categoryRepository.findById(id).orElseThrow();
        udCategory.update(category);
        return categoryRepository.save(udCategory);
    }
}