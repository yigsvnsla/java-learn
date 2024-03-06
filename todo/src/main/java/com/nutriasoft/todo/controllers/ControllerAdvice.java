package com.nutriasoft.todo.controllers;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nutriasoft.todo.dtos.ErrorResponseDto;

import com.nutriasoft.todo.execptions.ResponseExecption;

import jakarta.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class ControllerAdvice {

    @ModelAttribute
    public void setResponseContentType(HttpServletResponse response) {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    }

    // Crear un objeto de respuesta con el mensaje de error y el código de estado

    @ResponseStatus()
    @ExceptionHandler(value = ResponseExecption.class)
    public ResponseEntity<ErrorResponseDto> handlerResponseExecption(ResponseExecption ex) {

        ErrorResponseDto errorResponseDto = new ErrorResponseDto();

        errorResponseDto.setCause(ex.getClass().getName());
        errorResponseDto.setMessage(ex.getMessage());
        errorResponseDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());
        errorResponseDto.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDto);
    }

    @ResponseStatus()
    @ExceptionHandler(value = NoSuchElementException.class)
    // IllegalArgumentException - if id is null.
    public ResponseEntity<ErrorResponseDto> handlerNoSuchElementException(NoSuchElementException ex) {

        ErrorResponseDto errorResponseDto = new ErrorResponseDto();

        errorResponseDto.setCause(ex.getClass().getName());
        errorResponseDto.setMessage(ex.getMessage());
        errorResponseDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());
        errorResponseDto.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDto);
    }

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<ErrorResponseDto> handlerIllegalArgumentException(IllegalArgumentException ex) {
        // IllegalArgumentException-in case the given entities or one of its entities is
        // null.

        ErrorResponseDto errorResponseDto = new ErrorResponseDto();

        errorResponseDto.setCause(ex.getClass().getName());
        errorResponseDto.setMessage(ex.getMessage());
        errorResponseDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());
        errorResponseDto.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponseDto);
    }

}
