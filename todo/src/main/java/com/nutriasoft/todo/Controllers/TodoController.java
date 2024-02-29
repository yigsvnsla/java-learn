package com.nutriasoft.todo.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutriasoft.todo.Entity.Todo;
import com.nutriasoft.todo.Services.TodoService;

import Dto.QueryParamsDto;
import Dto.ResponseDto;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoService TodoService;

    @GetMapping({ "", "/" })
    public ResponseEntity<ResponseDto<List<Todo>>> GetAllTodo(
            @ModelAttribute QueryParamsDto<Todo> queryParamsDto) {
        return TodoService.GetAllTodo(queryParamsDto);
    }

    @GetMapping("/{_id}")
    public ResponseEntity<ResponseDto<Todo>> GetTodo(
            @PathVariable Number _id) {
        return TodoService.GetTodo(_id);
    }

    @PostMapping({ "", "/" })
    public ResponseEntity<ResponseDto<List<Todo>>> SetTodo(@RequestBody List<Todo> _todo) {
        return TodoService.SetTodo(_todo);
    }

}
