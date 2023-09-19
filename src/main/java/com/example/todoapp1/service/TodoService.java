package com.example.todoapp1.service;

import com.example.todoapp1.model.todo.dto.ScheduleReqDTO;
import com.example.todoapp1.model.todo.dto.ScheduleResDTO;
import com.example.todoapp1.repository.TodoRepository;
import com.example.todoapp1.model.todo.Todo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    //데이터 추가
    public Todo add(ScheduleReqDTO request) {
        Todo schedule = new Todo(request);
        return this.todoRepository.save(schedule); //컨트롤러에서 받은 request를 파라미터로 받아서 model 클래스인 TodoEntity에 저장
    }

    //데이터 검색
    public Todo searchById(Long id) {
        return this.todoRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND)); //id로 찾은 값이 없으면 404에러
    }

    //모든 데이터 검색
    public List<ScheduleResDTO> searchAll() {
        List<Todo> schedules = this.todoRepository.findAll();
        List<ScheduleResDTO> scheduleResDTOs = schedules.stream().map(ScheduleResDTO::new).toList();
        return scheduleResDTOs;
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
