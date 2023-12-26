package com.example.todoapp1.controller;

import com.example.todoapp1.model.todo.Category;
import com.example.todoapp1.model.todo.dto.category.CategoryCreateReq;
import com.example.todoapp1.model.todo.dto.category.CategoryOrderReq;
import com.example.todoapp1.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@CrossOrigin
@Log
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody CategoryCreateReq request){
        log.info("CREATE CATEGORY");
        Category result = categoryService.addCategory(request);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping
    public ResponseEntity<List<String>> getCategories(){
        log.info("GET CATEGORIES");
        List<String> result = categoryService.searchNames();
        return ResponseEntity.ok().body(result);
    }
    //카테고리 개별 조회
    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getCategory(@PathVariable Long categoryId){
        log.info("GET CATEGORY BY ID");
        Category result = categoryService.searchById(categoryId);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long categoryId){
        log.info("DELETE CATEGORY");
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long categoryId, @RequestBody Category request) {

        log.info("UPDATE CATEGORY");
        Category result = categoryService.updateCategory(categoryId, request);
        return ResponseEntity.ok().body(result);
    }

//    @PutMapping("/order")
//    public ResponseEntity<?> updateCategoryOrder(@RequestBody CategoryOrderReq request){
//        log.info("UPDATE CATEGORY ORDER");
//        // TODO: 2023-10-28 카테고리 순서 변경 로직 구현
//        categoryService.updateCategoryOrder(request);
//        return ResponseEntity.ok().build();
//    }
}
