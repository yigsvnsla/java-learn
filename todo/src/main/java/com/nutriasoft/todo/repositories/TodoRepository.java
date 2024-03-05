package com.nutriasoft.todo.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nutriasoft.todo.entitys.Todo;

@Repository
@Transactional
public interface TodoRepository extends CrudRepository<Todo, UUID> {
    Page<Todo> findAll(Pageable pageable);
}
