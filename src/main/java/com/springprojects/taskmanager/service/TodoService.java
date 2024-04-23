package com.springprojects.taskmanager.service;

import com.springprojects.taskmanager.dto.TodoRequest;
import com.springprojects.taskmanager.model.Todo;
import com.springprojects.taskmanager.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoService {

    private final TodoRepository todoRepository;
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public List<Todo> getTodoByTitle(String title) {
        return todoRepository.findByTitle(title);
    }

    public void createTodo(TodoRequest todoRequest) {
        Todo todo = Todo.builder()
                .title(todoRequest.getTitle())
                .description(todoRequest.getDescription())
                .build();
        todoRepository.save(todo);
    }

    public void updateTodoByTitle(String title, TodoRequest todoRequest) {
        Todo todo = todoRepository.findByTitle(title).stream().findFirst().orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setTitle(todoRequest.getTitle());
        todo.setDescription(todoRequest.getDescription());
        todoRepository.save(todo);
    }

    public void deleteTodoById(String title) {
        Todo todo = todoRepository.findByTitle(title).stream().findFirst().orElseThrow(() -> new RuntimeException("Todo not found"));
        todoRepository.delete(todo);
    }
}
