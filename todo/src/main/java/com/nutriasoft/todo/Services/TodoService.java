package com.nutriasoft.todo.Services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nutriasoft.todo.Dto.MetadataResponseDto;
import com.nutriasoft.todo.Dto.PageDto;
import com.nutriasoft.todo.Dto.QueryParamsDto;
import com.nutriasoft.todo.Dto.ResponseDto;
import com.nutriasoft.todo.Entity.Todo;
import com.nutriasoft.todo.Repository.TodoRepository;
import com.nutriasoft.todo.execptions.ResponseExecption;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public ResponseEntity<ResponseDto<List<Todo>>> GetAllTodo(QueryParamsDto<Todo> queryParamsDto) {
        try {
            List<Todo> listTodo = (List<Todo>) this.todoRepository.findAll();
            MetadataResponseDto metadataResponseDto = new MetadataResponseDto();
            metadataResponseDto.setMessage("find todo list success");
            metadataResponseDto.setStatus(HttpStatus.OK);
            metadataResponseDto.setPagination(new PageDto(listTodo.size()));
            ResponseDto<List<Todo>> responseDto = new ResponseDto<>(listTodo, metadataResponseDto);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } catch (Exception e) {
            MetadataResponseDto metadataResponseDto = new MetadataResponseDto();
            metadataResponseDto.setMessage("find todo list success");
            metadataResponseDto.setStatus(HttpStatus.NOT_FOUND);
            ResponseDto<List<Todo>> responseDto = new ResponseDto<>(null, metadataResponseDto);
            return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<ResponseDto<Todo>> GetTodoById(UUID _id) {
        if (_id == null) {
            throw new ResponseExecption(HttpStatus.BAD_REQUEST, "Arg '_id' is null");
        }

        Boolean todoExit = this.todoRepository.existsById(_id);

        if (!todoExit) {
            throw new ResponseExecption(HttpStatus.NOT_FOUND, "Todo not exist");
        }

        Todo todo = this.todoRepository.findById(_id).orElseThrow();
        MetadataResponseDto metadataResponseDto = new MetadataResponseDto();
        metadataResponseDto.setMessage("Find todo success");
        metadataResponseDto.setStatus(HttpStatus.OK);
        ResponseDto<Todo> responseDto = new ResponseDto<Todo>(todo, metadataResponseDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    public ResponseEntity<ResponseDto<List<Todo>>> SetAllTodo(List<Todo> _todos) {
        try {

            if (_todos == null) {
                throw new Error("Arg '_todos' is null");
            }

            if (_todos.isEmpty()) {
                throw new Error("Arg '_id' is empty");
            }

            List<Todo> listTodo = (List<Todo>) this.todoRepository.saveAll(_todos);
            MetadataResponseDto metadataResponseDto = new MetadataResponseDto();
            
            metadataResponseDto.setMessage("create todo success");
            metadataResponseDto.setStatus(HttpStatus.OK);
            
            ResponseDto<List<Todo>> responseDto = new ResponseDto<>(listTodo, metadataResponseDto);

            return new ResponseEntity<>(responseDto, HttpStatus.OK);

        } catch (Exception e) {
            // TODO: handle exception
            // TODO: add ErrorResponseDto
            return null;
        }
    }

    public ResponseEntity<ResponseDto<Todo>> PutTodo(UUID _id, Todo _todo) {
        try {

            if (_id == null) {
                throw new Error("Arg '_id' is null");
            }
            if (_todo != null) {
                throw new Error("Arg '_todo' is null");
            }

            if (!this.todoRepository.existsById(_id)) {
                throw new Error("it's Todo not exist");
            }

            Todo todo = this.todoRepository.findById(_id).orElseThrow();
            MetadataResponseDto metadataResponseDto = new MetadataResponseDto();
            metadataResponseDto.setMessage("update todo success");
            metadataResponseDto.setStatus(HttpStatus.OK);
            ResponseDto<Todo> responseDto = new ResponseDto<>(todo, metadataResponseDto);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            // TODO: add ErrorResponseDto
            return null;
        }

    }

    public ResponseEntity<ResponseDto<Todo>> DeleteTodo(UUID _id) {
        try {

            if (_id == null) {
                throw new Error("Arg '_id' is null");
            }
            if (!this.todoRepository.existsById(_id)) {
                throw new Error("it's Todo not exist");
            }

            this.todoRepository.deleteById(_id);
            MetadataResponseDto metadataResponseDto = new MetadataResponseDto();
            metadataResponseDto.setMessage("delete todo success");
            metadataResponseDto.setStatus(HttpStatus.OK);
            ResponseDto<Todo> responseDto = new ResponseDto<>(null, metadataResponseDto);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            // TODO: add ErrorResponseDto
            return null;
        }

    }

}
