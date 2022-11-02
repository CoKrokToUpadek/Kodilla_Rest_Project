package com.crud.task.controller;

import com.crud.task.domain.TaskDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
public class ControllerTestSuite {

    @Autowired
    TaskController taskController;

    @Test
    void getTasksTest(){
        //given
        //when
        ResponseEntity<List<TaskDto>> taskList= taskController.getTasks();
        //then
        Assertions.assertEquals(24,taskList.getBody().size());

    }

    @Test
    void getTaskTest() throws TaskNotFoundException {
        //given
        //when
        ResponseEntity<TaskDto> task= taskController.getTask(1L);
        //then
        Assertions.assertEquals("testName",task.getBody().getTitle());

    }

}
