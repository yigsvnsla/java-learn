package com.nutriasoft.todo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nutriasoft.todo.Dao.Todo.TodoDao;
import com.nutriasoft.todo.Entity.Todo;

import Dto.MetadataResponseDto;
import Dto.QueryParamsDto;
import Dto.ResponseDto;
import Dto.PageDto;

@Service
public class TodoService {

    @Autowired
    TodoDao todoDao;

    public ResponseEntity<ResponseDto<List<Todo>>> GetAllTodo(QueryParamsDto<Todo> queryParamsDto) {
        List<Todo> listTodo = this.todoDao.GetAllTodo();
        // ! Create Pagination
        PageDto pageDto = new PageDto(listTodo.size());
        MetadataResponseDto metadataResponseDto = new MetadataResponseDto(HttpStatus.OK, "find todo list success",
                pageDto);
        ResponseDto<List<Todo>> responseDto = new ResponseDto<>(listTodo, metadataResponseDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    public ResponseEntity<ResponseDto<Todo>> GetTodo(Number _id) {
        Todo todo = this.todoDao.GetTodo(_id);
        MetadataResponseDto metadataResponseDto = new MetadataResponseDto(HttpStatus.OK, "find todo success");
        ResponseDto<Todo> responseDto = new ResponseDto<>(todo, metadataResponseDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    public ResponseEntity<ResponseDto<List<Todo>>> SetTodo(List<Todo> _todos) {
        List<Todo> listTodo = this.todoDao.SetTodo(_todos);
        // ! Create Pagination
        PageDto pageDto = new PageDto(listTodo.size());
        MetadataResponseDto metadataResponseDto = new MetadataResponseDto(HttpStatus.OK, "create todo success",
                pageDto);
        ResponseDto<List<Todo>> responseDto = new ResponseDto<>(listTodo, metadataResponseDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    public ResponseEntity<ResponseDto<Todo>> PutTodo(Number _id, Todo _todo) {
        Todo todo = this.todoDao.GetTodo(_id);
        MetadataResponseDto metadataResponseDto = new MetadataResponseDto(HttpStatus.OK, "update todo success");
        ResponseDto<Todo> responseDto = new ResponseDto<>(todo, metadataResponseDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    public ResponseEntity<ResponseDto<Todo>> DelTodo(Number _id) {
        Todo todo = this.todoDao.GetTodo(_id);
        MetadataResponseDto metadataResponseDto = new MetadataResponseDto(HttpStatus.OK, "delete todo success");
        ResponseDto<Todo> responseDto = new ResponseDto<>(todo, metadataResponseDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}
