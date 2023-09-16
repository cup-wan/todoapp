package com.example.todoapp1.service;

import com.example.todoapp1.model.TodoRequest;
import com.example.todoapp1.repository.TodoRepository;
import com.example.todoapp1.model.TodoEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    //데이터 추가
    public TodoEntity add(TodoRequest request) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTitle(request.getTitle());
        todoEntity.setOrder(request.getOrder());
        todoEntity.setCompleted(request.getCompleted());

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
        this.todoRepository.deleteById(id);
    }

    //모든 데이터 삭제
    public void deleteAll() {
        this.todoRepository.deleteAll();
    }
}
