package com.example.todoapp1.model.todo.dto.schedule;

import com.example.todoapp1.model.todo.Category;
import com.example.todoapp1.model.todo.Todo;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
// Todo 조회 Response DTO
public class ScheduleReadRes implements Serializable {
    private Long categoryId;
    private Long priority;
    private Long id;
    private LocalDate date;
    private String title;
    private Boolean isNoti;
    private LocalDateTime notiTime;
    private Boolean isImportant;
    private Boolean isDone;

    public ScheduleReadRes(Todo schedule) {
        Category category = new Category();
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.date = schedule.getDate();
        this.notiTime = schedule.getNotiTime();
        this.priority = schedule.getPriority();
        this.isNoti = schedule.getIsNoti();
        this.isImportant = schedule.getIsImportant();
        this.isDone = schedule.getIsDone();
        this.categoryId = category.getId();
    }
}