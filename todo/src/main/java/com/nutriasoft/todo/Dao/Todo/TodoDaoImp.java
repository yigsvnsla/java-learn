package com.nutriasoft.todo.Dao.Todo;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nutriasoft.todo.Entity.Todo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class TodoDaoImp implements TodoDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Todo> GetAllTodo() {
        String query = "FROM Todo";
        TypedQuery<Todo> typedQuery = this.entityManager.createQuery(query, Todo.class);
        List<Todo> result = typedQuery.getResultList();
        return result;
    }

    public Todo GetTodo(Number _id) {
        throw new UnsupportedOperationException("Unimplemented method 'GetTodo'");
    }

    public List<Todo> SetTodo(List<Todo> _todos) {
        
        // String query = "";
        // TypedQuery<Todo> typedQuery = this.entityManager.createQuery(query,
        // Todo.class);
        String query = "FROM Todo";
        TypedQuery<Todo> typedQuery = this.entityManager.createQuery(query, Todo.class);
        List<Todo> result = typedQuery.getResultList();
        return result;

    }

    public Todo PutTodo(Number _id, Todo _todo) {
        throw new UnsupportedOperationException("Unimplemented method 'PutTodo'");
    }

    public Todo DelTodo(Number _id) {
        throw new UnsupportedOperationException("Unimplemented method 'DelTodo'");
    }

}
