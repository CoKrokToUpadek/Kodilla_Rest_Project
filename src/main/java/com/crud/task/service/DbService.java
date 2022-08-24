package com.crud.task.service;

import com.crud.task.domain.Task;
import com.crud.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbService {
    private final TaskRepository repository;
    public List<Task> getAllTasks() {
        return repository.findAll();
    }
    public Task getTask(Long id){
        Optional<Task> taskOut=repository.findById(id);
        return taskOut.orElseGet(() -> new Task(404L, "not found", "not found"));
    }

}
