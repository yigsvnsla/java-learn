package com.nutriasoft.todo.dtos;


import lombok.Data;

@Data
public class ErrorResponseDto {
    private Integer code;
    private String status;
    private String message;
    private String cause;
}
