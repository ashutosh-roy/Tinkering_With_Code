package com.hobbyprojects.tinkeringwithcode.controller;

import com.hobbyprojects.tinkeringwithcode.dto.ToDoRequest;
import com.hobbyprojects.tinkeringwithcode.dto.ToDoResponse;
import com.hobbyprojects.tinkeringwithcode.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class ToDoListController {

    @Autowired
    ToDoService toDoService;

    @GetMapping
    public void getToDos() {
        toDoService.getToDos();
    }

    @PostMapping
    public ResponseEntity<ToDoResponse> addToDos(@RequestBody ToDoRequest toDoRequest) {
        return toDoService.addToDos(toDoRequest);
    }
}
