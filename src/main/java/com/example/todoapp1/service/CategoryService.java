//package com.example.todoapp1.service;
//
//import com.example.todoapp1.model.todo.Category;
//import com.example.todoapp1.repository.CategoryRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@AllArgsConstructor
//public class CategoryService {
//
//    private final CategoryRepository categoryRepository;
//
//    public Category addCategory(Category category) {
//        // 카테고리 추가 로직 구현
//        return categoryRepository.save(category);
//    }
//
//    public List<Category> getAllCategories() {
//        // 모든 카테고리 조회 로직 구현
//        return categoryRepository.findAll();
//    }
//
//    // 다른 카테고리 관련 로직을 추가할 수 있음
//}