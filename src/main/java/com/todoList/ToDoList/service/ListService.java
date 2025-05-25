package com.todoList.ToDoList.service;

import com.todoList.ToDoList.entity.ToDoList;
import com.todoList.ToDoList.repository.ListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ListService {

    @Autowired
    private ListRepo listRepo;

    public List<ToDoList> getList(ToDoList toDoList){

        return listRepo.findAll();
    }

    public ToDoList getListContentBYId(Integer id){
        return listRepo.findById(id).orElse(new ToDoList());
    }

    public ToDoList addTask(ToDoList toDoList){
        ToDoList task=new ToDoList();
        task.setListContent(toDoList.getListContent());
        task.setListStatus(toDoList.getListStatus());

        return listRepo.save(task);
    }

    public ToDoList deleteTask(Integer id) {
        ToDoList task = listRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
        listRepo.delete(task);
        return task;
    }


}
