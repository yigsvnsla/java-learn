package com.nutriasoft.todo.Dao.Todo;

import java.util.List;

import com.nutriasoft.todo.Entity.Todo;

/**
 * TodoDao
 */
public interface TodoDao {
    public List<Todo> GetAllTodo();

    public Todo GetTodo(Number _id);

    public List<Todo> SetTodo(List<Todo> _todos);

    public Todo PutTodo(Number _id, Todo _todo);

    public Todo DelTodo(Number _id);
}