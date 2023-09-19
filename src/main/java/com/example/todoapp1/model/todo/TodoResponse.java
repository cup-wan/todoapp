//package com.example.todoapp1.model.todo;
//
//import com.example.todoapp1.model.todo.dto.CategoryDTO;
//import com.example.todoapp1.model.todo.dto.ScheduleReqDTO;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class TodoResponse {
//    private Long id;
//    private String title;
//    private Long priority;
//    private Boolean isNoti;
//    private Boolean isImportant;
//    private Boolean isDone;
//    private int categoryIndex;
//    private LocalDate date;
//    private LocalDateTime notiTime;
//    private List<ScheduleReqDTO> schedules;
//    private List<CategoryDTO> category;
//    //이후에 코드작성 편리를 위해 todoEntity를 받는 생성자 추가
//    public TodoResponse(Schedule todoEntity){
//        this.schedules =
//
////        this.category = todoEntity.getCategory();
//    }
//}
