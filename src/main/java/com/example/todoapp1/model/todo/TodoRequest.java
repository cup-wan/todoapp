package com.example.todoapp1.model.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoRequest {
    private String title;
    private Long priority;
    private Boolean completed;
    private Boolean isNoti;
    private Boolean isImportant;
    private Boolean isDone;
    private String date;
    private String notiTime;
}
