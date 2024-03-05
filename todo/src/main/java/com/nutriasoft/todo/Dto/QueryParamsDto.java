package com.nutriasoft.todo.Dto;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.lang.NonNull;

// import org.springframework.data.domain.Sort;
// import org.springframework.data.domain.Sort.Direction;
// import org.springframework.lang.Nullable;

// import io.micrometer.common.lang.NonNull;
import lombok.Data;

@Data
public class QueryParamsDto<T> {
    private Integer take = 10;
    private Integer page = 0;

    @NonNull
    private Direction orderDirection = Direction.ASC;

    @NonNull
    private String[] order;

    // public void setOrderDirection(@Nullable Direction _direction) {
    // this.orderDirection = _direction;
    // }

    // @Nullable
    // public Direction getOrDirection() {
    // return this.orderDirection;
    // }

}
