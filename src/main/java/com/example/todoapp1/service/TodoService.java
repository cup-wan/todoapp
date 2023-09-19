package com.example.todoapp1.service;

import com.example.todoapp1.model.todo.TodoRequest;
import com.example.todoapp1.repository.TodoRepository;
import com.example.todoapp1.model.todo.TodoEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    //데이터 추가
    public TodoEntity add(TodoRequest request) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTitle(request.getTitle());
        todoEntity.setPriority(request.getPriority());
        todoEntity.setIsDone(request.getIsDone());
        todoEntity.setIsImportant(request.getIsImportant());
        todoEntity.setIsNoti(request.getIsNoti());
        todoEntity.setDate(LocalDate.parse(request.getDate()));
        todoEntity.setNotiTime(LocalDateTime.parse(request.getNotiTime()));
        try {
            todoEntity.setDate(LocalDate.parse(request.getDate()));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid date format. Use yyyy-MM-dd.");
        }

        // notiTime도 파싱을 예외 처리
        try {
            todoEntity.setNotiTime(LocalDateTime.parse(request.getNotiTime()));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid notiTime format. Use yyyy-MM-dd HH:mm:ss.");
        }

        return this.todoRepository.save(todoEntity); //컨트롤러에서 받은 request를 파라미터로 받아서 model 클래스인 TodoEntity에 저장
    }

    //데이터 검색
    public TodoEntity searchById(Long id) {
        return this.todoRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND)); //id로 찾은 값이 없으면 404에러
    }

    //모든 데이터 검색
    public List<TodoEntity> searchAll() {
        return this.todoRepository.findAll();
    }

    //데이터 삭제
    public void deleteById(Long id) {
        if (this.todoRepository.existsById(id)) {
            this.todoRepository.deleteById(id);
        } else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    //모든 데이터 삭제
    public void deleteAll() {
        this.todoRepository.deleteAll();
    }
}
