package com.todoList.ToDoList.repository;

import com.todoList.ToDoList.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepo extends JpaRepository<ToDoList,Integer> {
}
