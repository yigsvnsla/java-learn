package com.nutriasoft.todo.Entity;

// import com.nutriasoft.todo.Interfaces.ITodo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "todo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_complete")
    protected boolean isComplete;


    // public Todo(String _name, boolean _isComplete) {
    // this.setName(_name);
    // this.setIsComplete(_isComplete);
    // }
}
