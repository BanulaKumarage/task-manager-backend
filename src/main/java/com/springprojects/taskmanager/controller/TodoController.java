package com.springprojects.taskmanager.controller;

import com.springprojects.taskmanager.dto.TodoRequest;
import com.springprojects.taskmanager.model.Todo;
import com.springprojects.taskmanager.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @GetMapping("/{title}")
    public List<Todo> getTodoByTitle(@PathVariable String title){
        return todoService.getTodoByTitle(title);
    }

    @PostMapping
    public String createTodo(@RequestBody TodoRequest todoRequest){
        todoService.createTodo(todoRequest);
        return "Todo created successfully";
    }

    @PutMapping("/{title}")
    public String updateTodoByTitle(@PathVariable String title, @RequestBody TodoRequest todoRequest){
        todoService.updateTodoByTitle(title, todoRequest);
        return "Todo with title: " + title + " updated successfully";
    }

    @DeleteMapping("/{title}")
    public String deleteTodoById(@PathVariable String title){
        todoService.deleteTodoById(title);
        return "Todo with id: " + title + " deleted successfully";
    }
}
