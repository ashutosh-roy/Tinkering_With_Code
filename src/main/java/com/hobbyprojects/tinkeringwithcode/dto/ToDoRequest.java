package com.hobbyprojects.tinkeringwithcode.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hobbyprojects.tinkeringwithcode.model.ToDo;
import lombok.Getter;

import java.util.List;

@Getter
public class ToDoRequest {
    @JsonProperty("toDoList")
    List<ToDo> toDos;
}
