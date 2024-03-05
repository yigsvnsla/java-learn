package com.nutriasoft.todo.interface;

public interface IPageDto {

    int page = 1;

    int take = 10;

    int count = 0;

    int pageCount = 0;

    boolean hasPreviousPage = false;

    boolean hasNextPage = false;
}
