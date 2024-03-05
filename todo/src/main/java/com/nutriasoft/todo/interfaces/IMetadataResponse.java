package com.nutriasoft.todo.interfaces;

import org.springframework.http.HttpStatus;

public interface IMetadataResponse {
    HttpStatus status = HttpStatus.OK;
    IPageDto pagination = null;
    String message = "";
    
}
