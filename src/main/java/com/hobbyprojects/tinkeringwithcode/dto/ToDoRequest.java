package com.hobbyprojects.tinkeringwithcode.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hobbyprojects.tinkeringwithcode.model.ToDo;
import java.util.List;
import lombok.Getter;

@Getter
public class ToDoRequest {
  @JsonProperty("toDoList")
  List<ToDo> toDos;
}
