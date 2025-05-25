package com.todoList.ToDoList.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.todoList.ToDoList.ToDoListApplication;
import com.todoList.ToDoList.entity.ToDoList;
import com.todoList.ToDoList.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api")
@RestController
public class ListController {

    @Autowired
    private ListService listService;

        @GetMapping("/list")
        public ResponseEntity<List<ToDoList>> getList(@RequestBody ToDoList toDoList){
        return new ResponseEntity<>(listService.getList(toDoList),HttpStatus.OK);
        }

        @GetMapping("/list/{id}")
        public ResponseEntity<ToDoList> getListContentById(@PathVariable Integer id){
            return new ResponseEntity<>(listService.getListContentBYId(id),HttpStatus.OK);
        }

        @PostMapping("/list")
        public  ResponseEntity<?> addTask(@RequestBody ToDoList todoList){


            try {
                ToDoList saved = listService.addTask(todoList);
                return new ResponseEntity<>(saved, HttpStatus.OK);
            }catch (Exception e){
                return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
            }
        }

    @DeleteMapping("/list/{id}")
    public ResponseEntity<ToDoList> deleteTask(@PathVariable Integer id) {
        ToDoList deleted = listService.deleteTask(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

}
