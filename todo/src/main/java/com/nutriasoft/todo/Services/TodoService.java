package com.nutriasoft.todo.Services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

        PageDto pageDto = new PageDto();
        ResponseDto<List<Todo>> responseDto = new ResponseDto<>();
        MetadataResponseDto metadataResponseDto = new MetadataResponseDto();
        System.out.println(queryParamsDto.toString());

        Sort sort;

        if (queryParamsDto.getOrder().length > 0) {
            sort = Sort.by(Sort.DEFAULT_DIRECTION);
        } else {
            sort = Sort.by(
                    queryParamsDto.getOrderDirection(),
                    queryParamsDto.getOrder());
        }

        PageRequest pageable = PageRequest.of(
                queryParamsDto.getPage(),
                queryParamsDto.getTake(), sort);

        Page<Todo> pageTodo = this.todoRepository.findAll(pageable);

        pageDto.setTake(pageTodo.getSize());
        pageDto.setPage(pageTodo.getNumber());
        pageDto.setCount(pageTodo.getTotalElements());
        pageDto.setPageCount(pageTodo.getTotalPages());
        pageDto.setHasPreviousPage(pageTodo.getNumber());
        pageDto.setHasNextPage(pageTodo.getNumber(), pageTodo.getTotalPages());

        metadataResponseDto.setPagination(pageDto);
        metadataResponseDto.setStatus(HttpStatus.OK);
        metadataResponseDto.setMessage("find todo list success");

        responseDto.setMeta(metadataResponseDto);
        responseDto.setData(pageTodo.getContent());

        return new ResponseEntity<>(responseDto, HttpStatus.OK);

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

        if (_todos == null) {
            throw new ResponseExecption(HttpStatus.BAD_REQUEST, "Arg '_todos' is null");
        }

        if (_todos.isEmpty()) {
            throw new ResponseExecption(HttpStatus.BAD_REQUEST, "Arg '_id' is empty");
        }

        List<Todo> listTodo = (List<Todo>) this.todoRepository.saveAll(_todos);
        MetadataResponseDto metadataResponseDto = new MetadataResponseDto();

        metadataResponseDto.setMessage("create todo success");
        metadataResponseDto.setStatus(HttpStatus.OK);

        ResponseDto<List<Todo>> responseDto = new ResponseDto<>(listTodo, metadataResponseDto);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);

    }

    public ResponseEntity<ResponseDto<Todo>> PutTodo(UUID _id, Todo _todo) {

        if (_id == null) {
            throw new ResponseExecption(HttpStatus.BAD_REQUEST, "Arg '_id' is null");
        }
        if (_todo != null) {
            throw new ResponseExecption(HttpStatus.BAD_REQUEST, "Arg '_todo' is null");
        }

        if (!this.todoRepository.existsById(_id)) {
            throw new ResponseExecption(HttpStatus.NOT_FOUND, "it's Todo not exist");
        }

        Todo todo = this.todoRepository.findById(_id).orElseThrow();
        MetadataResponseDto metadataResponseDto = new MetadataResponseDto();
        metadataResponseDto.setMessage("update todo success");
        metadataResponseDto.setStatus(HttpStatus.OK);
        ResponseDto<Todo> responseDto = new ResponseDto<>(todo, metadataResponseDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);

    }

    public ResponseEntity<ResponseDto<Todo>> DeleteTodo(UUID _id) {

        if (_id == null) {
            throw new ResponseExecption(HttpStatus.BAD_REQUEST, "Arg '_id' is null");
        }
        if (!this.todoRepository.existsById(_id)) {
            throw new ResponseExecption(HttpStatus.NOT_FOUND, "it's Todo not exist");
        }

        this.todoRepository.deleteById(_id);
        MetadataResponseDto metadataResponseDto = new MetadataResponseDto();
        metadataResponseDto.setMessage("delete todo success");
        metadataResponseDto.setStatus(HttpStatus.OK);
        ResponseDto<Todo> responseDto = new ResponseDto<>(null, metadataResponseDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);

    }

}
