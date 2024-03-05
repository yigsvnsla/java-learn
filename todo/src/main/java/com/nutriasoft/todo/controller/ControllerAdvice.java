package com.nutriasoft.todo.controller;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nutriasoft.todo.dto.MetadataResponseDto;
import com.nutriasoft.todo.dto.ResponseDto;
import com.nutriasoft.todo.execptions.ResponseExecption;

@RestControllerAdvice
public class ControllerAdvice {

    // Crear un objeto de respuesta con el mensaje de error y el código de estado
    private ResponseDto<?> responseDto = new ResponseDto<>();
    private MetadataResponseDto metadataResponseDto = new MetadataResponseDto();

    /**
     * Maneja las excepciones de tipo ResponseExecption y genera una respuesta
     * adecuada.
     * 
     * @param ex La excepción lanzada.
     * @return Una respuesta ResponseEntity con el cuerpo de la respuesta y el
     *         código de estado adecuados.
     */
    @ExceptionHandler(value = ResponseExecption.class)
    public ResponseEntity<ResponseDto<?>> handlerResponseExecption(ResponseExecption ex) {

        HttpStatus status = (ex.getStatus() != null) ? ex.getStatus() : HttpStatus.INTERNAL_SERVER_ERROR;

        this.metadataResponseDto.setStatus(ex.getStatus());
        this.metadataResponseDto.setMessage(ex.getMessage()); // Establecer el mensaje de error en el cuerpo de la respuesta

        this.responseDto.setMeta(metadataResponseDto); // Establecer metadatos si es necesario
        this.responseDto.setData(null); // Establecer datos según sea necesario

        // Crear un objeto ResponseEntity con el cuerpo de la respuesta y el código de
        // estado
        return ResponseEntity.status(status).body(responseDto);
    }

    @ExceptionHandler(value = NoSuchElementException.class)
    // IllegalArgumentException - if id is null.
    public ResponseEntity<ResponseDto<?>> handlerNoSuchElementException(NoSuchElementException ex) {

        this.metadataResponseDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        this.metadataResponseDto.setMessage(ex.getMessage());

        this.responseDto.setMeta(metadataResponseDto);
        this.responseDto.setData(null);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto);
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<ResponseDto<?>> handlerIllegalArgumentException(IllegalArgumentException ex) {
        // IllegalArgumentException-in case the given entities or one of its entities is
        // null.

        this.metadataResponseDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        this.metadataResponseDto.setMessage(ex.getMessage());

        this.responseDto.setMeta(metadataResponseDto);
        this.responseDto.setData(null);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto);
    }

}
