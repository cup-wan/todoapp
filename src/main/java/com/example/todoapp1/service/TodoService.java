package com.example.todoapp1.service;

import com.example.todoapp1.model.todo.Category;
import com.example.todoapp1.model.todo.dto.schedule.ScheduleCreateReq;
import com.example.todoapp1.model.todo.dto.schedule.ScheduleReadReq;
import com.example.todoapp1.model.todo.dto.schedule.ScheduleReadRes;
import com.example.todoapp1.repository.CategoryRepository;
import com.example.todoapp1.repository.TodoRepository;
import com.example.todoapp1.model.todo.Todo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final CategoryRepository categoryRepository;

    //데이터 추가
    public Todo add(ScheduleCreateReq scheduleCreateReq) {
        Category category = categoryRepository.findById(scheduleCreateReq.getCategoryId())
                .orElseThrow(() -> new NoSuchElementException("해당 ID에 해당하는 Category를 찾을 수 없습니다."));
        Todo schedule = scheduleCreateReq.toEntity(category);
        return todoRepository.save(schedule); //컨트롤러에서 받은 request를 파라미터로 받아서 model 클래스인 TodoEntity에 저장
    }

    //데이터 검색
    public Todo searchById(Long id) {
        return todoRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND)); //id로 찾은 값이 없으면 404에러
    }

    //모든 데이터 검색
    public List<ScheduleReadRes> searchAll() {
        List<Todo> schedules = todoRepository.findAll();
        List<ScheduleReadRes> scheduleReadRes = schedules.stream().map(ScheduleReadRes::new).toList();
        return scheduleReadRes;
    }


    //데이터 삭제
    public void deleteById(Long id) {
        if (todoRepository.existsById(id)) {
            todoRepository.deleteById(id);
        } else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    //모든 데이터 삭제
    public void deleteAll() {
        todoRepository.deleteAll();
    }
}
