package com.nutriasoft.todo.Interfaces;

import Dto.MetadataResponseDto;

public interface IResponse<T> {

    default MetadataResponseDto getMeta() {
        return null; // Puedes retornar el valor que desees
    }

    default T getData() {
        return null; // Puedes retornar el valor que desees
    }
}
