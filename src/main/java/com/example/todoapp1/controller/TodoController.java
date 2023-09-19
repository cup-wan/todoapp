package com.example.todoapp1.controller;

import com.example.todoapp1.model.todo.Category;
import com.example.todoapp1.model.todo.Todo;
import com.example.todoapp1.model.todo.dto.ScheduleReqDTO;
//import com.example.todoapp1.model.todo.TodoResponse;
import com.example.todoapp1.service.TodoService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController //해당 클래스는 REST API를 처리하는 Controller
@CrossOrigin //다른 도메인에서 요청을 허용하겠다 = cors 이슈 방지
@AllArgsConstructor
@Log
@RequestMapping("/") //base url 설정, url 컨트롤러의 메서드와 매핑할 때 사용
public class TodoController {
    private final TodoService todoService;

    @PostMapping
    //ResponseEntity는 HttpEntity 클래스를 상속받아 구현한 클래스이며 HttpStatus, HttpHeaders, HttpBody를 포함
    //list에 todoitem을 추가하는 api
    public ResponseEntity<?> create(@RequestBody ScheduleReqDTO request){


        log.info("CREATE TODO");

        if(ObjectUtils.isEmpty(request.getTitle()))
            return ResponseEntity.badRequest().build();

        if(ObjectUtils.isEmpty(request.getPriority()))
            request.setPriority(0L);

        if(ObjectUtils.isEmpty(request.getIsDone()))
            request.setIsDone(false);

        if(ObjectUtils.isEmpty(request.getIsImportant()))
            request.setIsImportant(false);

        if(ObjectUtils.isEmpty(request.getIsNoti()))
            request.setIsNoti(false);

        if(ObjectUtils.isEmpty(request.getDate()))
            request.setDate(LocalDate.now());

        if(ObjectUtils.isEmpty(request.getCategoryId()))
            request.setCategoryId(1L);

        if(ObjectUtils.isEmpty(request.getNotiTime()))
            request.setNotiTime(LocalDate.now().atStartOfDay());




        Todo result = this.todoService.add(request);
        return ResponseEntity.ok(result);
    }
//
//    @GetMapping("{id}") //id로 특정 todoitem을 조회하는 api
//    //todolist 하나씩 조회 하는 api
//    //GetMapping에 경로로받은 id값을 쓰기위해서 @PathVariable
//    public ResponseEntity<TodoResponse> readOne(@PathVariable Long id){
//        log.info("READ ONE");
//
//        TodoEntity result = this.todoService.searchById(id);
//        return ResponseEntity.ok(new TodoResponse(result));
//    }

    @GetMapping("/all") //모든 todoitem을 조회하는 api
    //todolist 전체 조회 하는 api
    public ResponseEntity<?> readAll(){
        log.info("READ ALL");
        Map<String,Object> result = new HashMap<>();
        result.put("categoryies", new Category().keySet());
        result.put("schedules", this.todoService.searchAll());
        return ResponseEntity.ok(result);
    }

}
