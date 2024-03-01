package com.nutriasoft.todo.Repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nutriasoft.todo.Entity.Todo;

@Repository
@Transactional
public interface TodoRepository extends CrudRepository<Todo, UUID> {

}
