package com.example.todoapp1.model.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleReqDTO {
    private String title;
    private Long priority;
    private Boolean isNoti;
    private Boolean isImportant;
    private Boolean isDone;
    private LocalDate date;
    private LocalDateTime notiTime;
    private Long categoryId;
}
