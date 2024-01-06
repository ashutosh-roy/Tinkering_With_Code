package com.hobbyprojects.tinkeringwithcode.repository;

import com.hobbyprojects.tinkeringwithcode.model.ToDoList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoListRepository extends MongoRepository<ToDoList, Object> {
  //    public T
}
