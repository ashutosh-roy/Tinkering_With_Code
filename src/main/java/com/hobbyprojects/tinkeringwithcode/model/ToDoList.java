package com.hobbyprojects.tinkeringwithcode.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Builder
@Getter
public class ToDoList {
    @Id
    String id;
    List<ToDo> toDos;
    Date createdAt;
    Date updatedAt;
}
