package com.nutriasoft.todo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutriasoft.todo.dto.QueryParamsDto;
import com.nutriasoft.todo.dto.ResponseDto;
import com.nutriasoft.todo.entity.Todo;
import com.nutriasoft.todo.service.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoService TodoService;

    @GetMapping({ "", "/" })
    public ResponseEntity<ResponseDto<List<Todo>>> GetAllTodo(
            @ModelAttribute QueryParamsDto<Todo> queryParamsDto) {
        System.out.println(queryParamsDto);
        return TodoService.GetAllTodo(queryParamsDto);
    }

    @GetMapping("/{_id}")
    public ResponseEntity<ResponseDto<Todo>> GetTodo(
            @PathVariable UUID _id) {
        return TodoService.GetTodoById(_id);
    }

    @PostMapping({ "", "/" })
    public ResponseEntity<ResponseDto<List<Todo>>> SetAllTodo(@RequestBody List<Todo> _todos) {
        return TodoService.SetAllTodo(_todos);
    }

}
