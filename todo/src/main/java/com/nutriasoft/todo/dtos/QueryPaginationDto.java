package com.nutriasoft.todo.dtos;

import lombok.Getter;
import lombok.Setter;

public class QueryPaginationDto {

    @Getter
    @Setter
    private String order;

    @Getter
    @Setter
    private int page = 1;

    @Getter
    @Setter
    private int take = 10;

    @Getter
    @Setter
    private int skip = (this.getPage() - 1) * this.getTake();
}
