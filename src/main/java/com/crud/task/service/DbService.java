package com.crud.task.service;

import com.crud.task.config.controller.TaskNotFoundException;
import com.crud.task.domain.Task;
import com.crud.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DbService {
    private final TaskRepository repository;
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

   /* public Task getTask(Long id){
        Optional<Task> taskOut=repository.findById(id);
        return taskOut.orElseGet(() -> new Task(404L, "not found", "not found"));
    }*/

    public Task getTask(final Long id) throws TaskNotFoundException {
        return repository.findById(id).orElseThrow(TaskNotFoundException::new);
    }

    public Long countTasks(){
        return repository.count();
    }


    public Task saveTask(final Task task){
      return  repository.save(task);
    }

    public void removeTask(final Long id) throws TaskNotFoundException{
        if (repository.findById(id).isEmpty()){
            throw new TaskNotFoundException();
        }
            repository.deleteById(id);
    }
}
