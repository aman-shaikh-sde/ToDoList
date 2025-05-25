package com.todoList.ToDoList.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "todolist")
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int listId;
    private String listContent;
    private String listStatus;

}
