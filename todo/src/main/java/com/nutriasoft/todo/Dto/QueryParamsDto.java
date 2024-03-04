package com.nutriasoft.todo.Dto;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import lombok.Data;

@Data
public class QueryParamsDto<T> {
    private Integer take = 10;
    private Integer page = 0;

    private Direction orderDirection = Sort.DEFAULT_DIRECTION;
    private String[] order = {};
}
