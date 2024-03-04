package com.nutriasoft.todo.Controllers;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nutriasoft.todo.Dto.MetadataResponseDto;
import com.nutriasoft.todo.Dto.ResponseDto;
import com.nutriasoft.todo.execptions.ResponseExecption;

@RestControllerAdvice
public class ControllerAdvice {

    /**
     * Maneja las excepciones de tipo ResponseExecption y genera una respuesta
     * adecuada.
     * 
     * @param ex La excepción lanzada.
     * @return Una respuesta ResponseEntity con el cuerpo de la respuesta y el
     *         código de estado adecuados.
     */
    @SuppressWarnings("null")
    @ExceptionHandler(value = ResponseExecption.class)
    public ResponseEntity<ResponseDto<?>> handlerResponseExecption(ResponseExecption ex) {

        HttpStatus status = (ex.getStatus() != null) ? ex.getStatus() : HttpStatus.INTERNAL_SERVER_ERROR;

        // Crear un objeto de respuesta con el mensaje de error y el código de estado
        ResponseDto<?> responseDto = new ResponseDto<>();
        MetadataResponseDto metadataResponseDto = new MetadataResponseDto();

        metadataResponseDto.setStatus(ex.getStatus());
        metadataResponseDto.setMessage(ex.getMessage()); // Establecer el mensaje de error en el cuerpo de la respuesta
        
        responseDto.setMeta(metadataResponseDto); // Establecer metadatos si es necesario
        responseDto.setData(null); // Establecer datos según sea necesario

        // Crear un objeto ResponseEntity con el cuerpo de la respuesta y el código de
        // estado
        return ResponseEntity.status(status).body(responseDto);
    }

    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<ResponseDto<?>> handlerNoSuchElementException(NoSuchElementException ex) {
        ResponseDto<?> responseDto = new ResponseDto<>();
        MetadataResponseDto metadataResponseDto = new MetadataResponseDto();

        metadataResponseDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        metadataResponseDto.setMessage(ex.getMessage());

        responseDto.setMeta(metadataResponseDto);
        responseDto.setData(null);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto);
    }
}
