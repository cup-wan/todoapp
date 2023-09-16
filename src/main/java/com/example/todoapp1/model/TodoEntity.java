package com.example.todoapp1.model;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@Entity(name = "ToDo")
@Table(name = "todo")
@AllArgsConstructor
@NoArgsConstructor
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키를 db가 자동으로 생성
    private Long id;

    @Column(nullable = false) //null 허용하지 않음
    private String title; //제목

    @Column(name = "todoOrder", nullable = false) //order는 예약어이므로 todoOrder로 변경
    private Long order; //순서

    @Column(nullable = false)
    private Boolean completed; //완료여부

}
