package com.example.max.todo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ToDoManager implements Serializable {
    // id of this ToDoManager
    private UUID id;

    // collection of ToDos
    private List<ToDoTask> todos;

    // instance
    private static final ToDoManager instance = new ToDoManager();

    private ToDoManager() {
        this.id = UUID.randomUUID();
        this.todos = new ArrayList<>();
    }

    public static ToDoManager getInstance() {
        return instance;
    }

    public void addToDo(ToDoTask t) {
        this.todos.add(t);
        Collections.sort(todos);
    }

    public ToDoTask getTask(int pos) {
        return todos.get(pos);
    }

    public int getNumberOfTasks() {
        return todos.size();
    }
}
