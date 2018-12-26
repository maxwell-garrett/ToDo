package com.example.max.todo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class TodoManager implements Serializable {
    // id of this TodoManager
    private UUID id;

    // collection of ToDos
    private List<ToDoTask> todos;

    public TodoManager() {
        this.id = UUID.randomUUID();
        this.todos = new ArrayList<>();
    }

    public void addToDo(ToDoTask t) {
        this.todos.add(t);
        Collections.sort(todos);
    }
}
