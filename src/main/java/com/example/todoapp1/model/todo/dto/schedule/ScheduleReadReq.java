package com.example.todoapp1.model.todo.dto.schedule;

import com.example.todoapp1.model.todo.Category;
import com.example.todoapp1.model.todo.Todo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleReadReq {
    private String title;
    private Long priority;
    private Boolean isNoti;
    private Boolean isImportant;
    private Boolean isDone;
    private LocalDate date;
    private LocalDateTime notiTime;
    private Long categoryId;

    /**
     * ScheduleReadReq를 todo Entity로 변환
     * @param category Category 객체
     * @return Todo 객체
     */
    public Todo toEntity(Category category){
        return new Todo(this.title, this.date, this.notiTime, this.priority, this.isNoti, this.isImportant, this.isDone, category);
    }
}