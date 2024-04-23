package com.springprojects.taskmanager.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_todos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo {

    @Id
    private String title;
    private String description;
}
