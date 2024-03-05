package com.nutriasoft.todo.interfaces;

import com.nutriasoft.todo.dtos.MetadataResponseDto;

public interface IResponse<T> {

    default MetadataResponseDto getMeta() {
        return null; // Puedes retornar el valor que desees
    }

    default T getData() {
        return null; // Puedes retornar el valor que desees
    }
}
