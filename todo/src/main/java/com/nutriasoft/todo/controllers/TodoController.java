package com.nutriasoft.todo.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutriasoft.todo.dtos.QueryParamsDto;
import com.nutriasoft.todo.dtos.ResponseDto;
import com.nutriasoft.todo.entitys.Todo;
import com.nutriasoft.todo.service.TodoService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PutMapping;

@Tag(name = "Todo")
@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("")
    @PreAuthorize("hasRole('user_client_role') or hasRole('admin_client_role')")
    public ResponseEntity<ResponseDto<List<Todo>>> getAllTodo(@ModelAttribute QueryParamsDto<Todo> queryParamsDto) {
        return todoService.GetAllTodo(queryParamsDto);
    }
    
    @PreAuthorize("hasRole('user_client_role') or hasRole('admin_client_role')")
    @GetMapping("/{_id}")
    public ResponseEntity<ResponseDto<Todo>> getTodo(@PathVariable UUID _id) {
        return todoService.GetTodoById(_id);
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<List<Todo>>> getAllTodo(@RequestBody List<Todo> _todos) {
        return todoService.SetAllTodo(_todos);
    }

    @PutMapping("/{_id}")
    public ResponseEntity<ResponseDto<Todo>> putTodo(@PathVariable UUID _id, @RequestBody Todo _todo) {
        return todoService.PutTodo(_id, _todo);
    }

    @DeleteMapping("/{_id}")
    public ResponseEntity<ResponseDto<Todo>> delTodo(@PathVariable UUID _id) {
        return todoService.DeleteTodo(_id);
    }
}