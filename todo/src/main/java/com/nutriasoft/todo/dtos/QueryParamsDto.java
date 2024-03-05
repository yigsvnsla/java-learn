package com.nutriasoft.todo.dtos;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.lang.NonNull;

import lombok.Data;

@Data
public class QueryParamsDto<T> {
    private Integer take = 10;
    private Integer page = 0;

    @NonNull
    private Direction orderDirection = Direction.ASC;

    @NonNull
    private String[] order = { "id" };

}
