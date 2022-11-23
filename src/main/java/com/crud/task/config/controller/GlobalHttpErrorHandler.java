package com.crud.task.config.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {
    //used in commercial environment
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<Object>handleTaskNotFoundException(TaskNotFoundException exception){
        return new ResponseEntity<>("task with given id doesnt exist", HttpStatus.BAD_REQUEST);
    }
}
