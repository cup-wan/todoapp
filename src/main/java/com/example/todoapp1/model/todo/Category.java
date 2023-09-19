package com.example.todoapp1.model.todo;
//
//import com.example.todoapp1.model.user.User;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Table(name = "category")
//public class Category {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false, unique = true)
//    private int priority;
//
//    @Column(nullable = false)
//    private String name;
//
//    @Column(nullable = false)
//    @ManyToOne(fetch = FetchType.LAZY)
//    private User user;
//
//}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Category {
    Map<String, Integer> priorities = new HashMap<>();
    Map<Long, String> names = new HashMap<>();

    public String getName(Long id) {
        return names.get(id);
    }

    public List<Object> keySet() {
        return new ArrayList<>(priorities.keySet());
    }
    public int getPriority(String name) {
        return priorities.get(name);
    }

    public int getPriority(int id) {
        String name = names.get(id);
        return priorities.get(name);
    }

    public Category() {
        priorities.put("study", 0);
        priorities.put("common", 1);
        priorities.put("buy", 2);

        names.put(0L, "study");
        names.put(1L, "common");
        names.put(2L, "buy");
    }
}
