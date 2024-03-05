package com.nutriasoft.todo.dto;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MetadataResponseDto {

    private HttpStatus status;

    private String message;

    private PageDto pagination = null;

    public MetadataResponseDto(String _message, HttpStatus _status,  PageDto _pagination) {
        this.setStatus(_status);
        this.setMessage(_message);
        this.setPagination(_pagination);
    }

    public MetadataResponseDto(HttpStatus _status, String _message) {
        this.setStatus(_status);
        this.setMessage(_message);
    }
}
