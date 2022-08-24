package com.crud.task.controller;

import com.crud.task.domain.Task;
import com.crud.task.domain.TaskDto;
import com.crud.task.mapper.TaskMapper;
import com.crud.task.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final DbService service;
    private final TaskMapper taskMapper;


    @GetMapping(value = "{taskId}")
    public TaskDto getTask(@PathVariable Long taskId){
        Task task=service.getTask(taskId);
        return taskMapper.mapToTaskDto(task);
    }

    @DeleteMapping
    public void deleteTask(Long taskId){

    }

    @GetMapping
    public List<TaskDto> getTasks() {
        List<Task> tasks = service.getAllTasks();
        return taskMapper.mapToTaskDtoList(tasks);
    }

    @PutMapping
    public TaskDto updateTask(TaskDto taskDto){
        return new TaskDto(1L,"Edited test title","test content");
    }

    @PostMapping
    public void createTask(TaskDto taskDto){

    }
}
