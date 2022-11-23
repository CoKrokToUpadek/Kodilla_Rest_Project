package com.crud.task.service;


import com.crud.task.config.controller.TaskNotFoundException;
import com.crud.task.domain.Task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;





@SpringBootTest
public class DbServiceTestSuite {

    @Autowired
    DbService dbService;



    @Test
    void getAllTasksTest(){
        //given
        //when
        List<Task> getTasks=dbService.getAllTasks();
        //then
        Assertions.assertEquals(24,getTasks.size());
    }

    @Test
    void getTaskTest() throws TaskNotFoundException {
        //given
        //when
        Task getTask=dbService.getTask(1L);
        //then
        Assertions.assertEquals("testDescription",getTask.getContent());
    }



}
