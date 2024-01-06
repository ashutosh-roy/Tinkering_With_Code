package com.hobbyprojects.tinkeringwithcode.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.hobbyprojects.tinkeringwithcode.controller.ToDoListController;
import com.hobbyprojects.tinkeringwithcode.mock.LoggingExtension;
import com.hobbyprojects.tinkeringwithcode.service.ToDoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ToDoListControllerTest {

  @RegisterExtension static LoggingExtension staticExtension = new LoggingExtension();
  @InjectMocks ToDoListController toDoListController;

  @Mock ToDoService toDoService;

  @Test
  void shouldReturnItemsInToDoList() {
    toDoListController.getToDos();
    verify(toDoService, times(1)).getToDos();
  }

  @Test
  void givenToDoItem_whenSaveToDoList_thenInvokeToDoService() {
    toDoListController.addToDos(any());
    verify(toDoService, times(1)).addToDos(any());
  }
}
