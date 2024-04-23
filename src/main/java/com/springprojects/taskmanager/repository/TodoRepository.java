package com.springprojects.taskmanager.repository;

import com.springprojects.taskmanager.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, String> {

    List<Todo> findByTitle(String title);
}
