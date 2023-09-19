package com.example.todoapp1.model.todo;


import com.example.todoapp1.model.todo.dto.ScheduleReqDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키를 db가 자동으로 생성
    private Long id;

    @Column(nullable = false) //null 허용하지 않음
    private String title; //제목

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "todoDate")
    private LocalDate date; //날짜

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    private LocalDateTime notiTime; //알림시간

    @Column(name = "priority", nullable = false) //order는 예약어이므로 todoOrder로 변경
    private Long priority; //우선순위

    @Column(nullable = false)
    @ColumnDefault("false")
    private Boolean isNoti; //알림여부

    @Column
    @ColumnDefault("false")
    private Boolean isImportant; //중요여부

    @Column
    @ColumnDefault("false")
    private Boolean isDone; //완료여부

    @Column
    private String category;

    public Todo(ScheduleReqDTO scheduleReqDTO) {
        Category category = new Category();
        this.title = scheduleReqDTO.getTitle();
        this.date = scheduleReqDTO.getDate();
        this.notiTime = scheduleReqDTO.getNotiTime();
        this.priority = scheduleReqDTO.getPriority();
        this.isNoti = scheduleReqDTO.getIsNoti();
        this.isImportant = scheduleReqDTO.getIsImportant();
        this.isDone = scheduleReqDTO.getIsDone();
        this.category = category.getName(scheduleReqDTO.getCategoryId());
    }
}
