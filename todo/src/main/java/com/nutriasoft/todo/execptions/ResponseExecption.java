package com.nutriasoft.todo.execptions;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)

public class ResponseExecption extends RuntimeException {

    private HttpStatus status;

    public ResponseExecption(HttpStatus _httpStatus, String _message) {
        super(_message);
        this.status = _httpStatus;
    }

}
