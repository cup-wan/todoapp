package com.example.todoapp1.model.todo;


import com.example.todoapp1.model.todo.dto.schedule.ScheduleReadReq;
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

    @Column(name = "priority", nullable = false)
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

    @JoinColumn(name = "category_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    public Todo(String title, LocalDate date, LocalDateTime notiTime, Long priority, Boolean isNoti, Boolean isImportant, Boolean isDone, Category category) {
        this.title = title;
        this.date = date;
        this.notiTime = notiTime;
        this.priority = priority;
        this.isNoti = isNoti;
        this.isImportant = isImportant;
        this.isDone = isDone;
        this.category = category;
    }
}