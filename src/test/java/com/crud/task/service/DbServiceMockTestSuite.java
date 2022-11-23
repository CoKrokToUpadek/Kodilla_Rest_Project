package com.crud.task.service;

import com.crud.task.config.controller.TaskNotFoundException;
import com.crud.task.domain.Task;
import com.crud.task.repository.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;


import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DbServiceMockTestSuite {

    @InjectMocks
    DbService mockedDbService;
    @Mock
    TaskRepository repository;

    @Test
    void removeTaskTest()  {
        //given
        Task mockTask=new Task(1L,"testName","testDescription");
        when(repository.findById(1L)).thenReturn(Optional.of(mockTask));
        //when
        Assertions.assertDoesNotThrow(()->mockedDbService.removeTask(1L));
    }

    @Test
    void removeTaskTestWithException(){
        Task mockTask=new Task(1L,"testName","testDescription");
        when(repository.findById(1L)).thenReturn(Optional.empty());
        //when
        Assertions.assertThrows(TaskNotFoundException.class,()->mockedDbService.removeTask(1L));

    }

    @Test
    void addTaskTest(){
        //given
        Task mockTask=new Task(1L,"testName","testDescription");
        when(repository.save(mockTask)).thenReturn(mockTask);
        //when
        Task getTask=mockedDbService.saveTask(mockTask);
        //then
        Assertions.assertEquals(getTask,mockTask);
    }

}
