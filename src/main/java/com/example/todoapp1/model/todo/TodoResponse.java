package com.example.todoapp1.model.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoResponse {
    private Long id;
    private String title;
    private Long priority;
    private Boolean completed;
    private Boolean isNoti;
    private Boolean isImportant;
    private Boolean isDone;
    private String date;
    private String url;

    //이후에 코드작성 편리를 위해 todoEntity를 받는 생성자 추가
    public TodoResponse(TodoEntity todoEntity){
        this.id = todoEntity.getId();
        this.title = todoEntity.getTitle();
        this.priority = todoEntity.getPriority();
        this.isDone = todoEntity.getIsDone();
        this.isImportant = todoEntity.getIsImportant();
        this.isNoti = todoEntity.getIsNoti();
//        this.date = String.valueOf(todoEntity.getDate());

        this.url = "http://localhost:8080/" + this.id;
    }
}
