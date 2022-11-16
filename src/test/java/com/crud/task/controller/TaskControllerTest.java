package com.crud.task.controller;

import com.crud.task.domain.Task;
import com.crud.task.domain.TaskDto;
import com.crud.task.mapper.TaskMapper;
import com.crud.task.service.DbService;
import com.google.gson.Gson;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(TaskController.class)
class TaskControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbService service;
    @MockBean
    TaskMapper taskMapper;

    @Test
    void getTasksEmptyTest() throws Exception {
        // Given
        when(service.getAllTasks()).thenReturn(List.of());
        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/tasks")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200)) // or isOk()
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    void getTasksWithDataTest() throws Exception {
        // Given
        Task task=new Task(1L,"testTitle","testContent");
        TaskDto taskDto =new TaskDto(1L,"testTitle","testContent");
        List<Task> taskList=List.of(task);
        List<TaskDto> taskListDto=List.of(taskDto);
        when(service.getAllTasks()).thenReturn(List.of(task));
        when(taskMapper.mapToTaskDtoList(taskList)).thenReturn(taskListDto);
        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/tasks")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200)) // or isOk()
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title", Matchers.is("testTitle")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].content", Matchers.is("testContent")));
    }


    @Test
    void getTaskTest() throws Exception {
        //given
        Task task=new Task(1L,"testTitle","testContent");
        TaskDto taskDto =new TaskDto(1L,"testTitle","testContent");
        when(service.getTask(1L)).thenReturn(task);
        when(taskMapper.mapToTaskDto(task)).thenReturn(taskDto);
        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/tasks/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200)) // or isOk()
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("testTitle")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Matchers.is("testContent")));
    }

    @Test
    void getTaskNotFoundTest() throws Exception {
        //given
        when(service.getTask(1L)).thenThrow(new TaskNotFoundException());
        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/tasks/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof TaskNotFoundException));



    }

    @Test
    void deleteTask() throws Exception {
        //Given & When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/v1/tasks/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }



    @Test
    void  updateTask() throws Exception {
        //given
        Task task=new Task(1L,"testTitle","testContent");
        TaskDto taskDto =new TaskDto(1L,"testTitle","testContent");
        when(taskMapper.mapToTask(taskDto)).thenReturn(task);
        when(service.saveTask(any(Task.class))).thenReturn(task);
        when(taskMapper.mapToTaskDto(task)).thenReturn(taskDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);
        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/v1/tasks/updateTask")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().is(200)) // or isOk()
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("testTitle")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Matchers.is("testContent")));



    }

    @Test
    void  createTask() throws Exception {
        //given
        Task task=new Task(1L,"testTitle","testContent");
        TaskDto taskDto =new TaskDto(1L,"testTitle","testContent");
        when(taskMapper.mapToTask(taskDto)).thenReturn(task);
        when(service.saveTask(any(Task.class))).thenReturn(task);
        when(taskMapper.mapToTaskDto(task)).thenReturn(taskDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);
        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/v1/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                        .andExpect(MockMvcResultMatchers.status().is(200))// or isOk()
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("testTitle")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Matchers.is("testContent")));
    }

}