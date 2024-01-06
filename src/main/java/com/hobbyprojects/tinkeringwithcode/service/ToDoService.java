package com.hobbyprojects.tinkeringwithcode.service;

import com.hobbyprojects.tinkeringwithcode.dto.ToDoRequest;
import com.hobbyprojects.tinkeringwithcode.dto.ToDoResponse;
import com.hobbyprojects.tinkeringwithcode.model.ToDoList;
import com.hobbyprojects.tinkeringwithcode.repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
    @Autowired
    ToDoListRepository toDoListRepository;

    public ResponseEntity<ToDoResponse> addToDos(ToDoRequest toDos) {
        toDoListRepository.save(ToDoList.builder().toDos(toDos.getToDos()).build());
        return ResponseEntity.ok().body(ToDoResponse.builder().message("TODO successfully added.").code("TWC-1").build());
    }

    public void getToDos() {
        // TODO : content to be added later
    }
}
