package com.crud.task.trello.controller;

import com.crud.task.config.controller.TrelloController;
import com.crud.task.domain.CreatedTrelloCardDto;
import com.crud.task.domain.TrelloBoardDto;
import com.crud.task.domain.TrelloCardDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
public class TrelloControllerTestSuite {

    @Autowired
    TrelloController trelloController;
    @Test
    void getTrelloBoardsTest(){
        //given
        //when
        ResponseEntity<List<TrelloBoardDto>> output =trelloController.getTrelloBoards();
        //then
        Assertions.assertEquals(1,output.getBody().size());
    }

    @Test
    void createTrelloCardTest(){
        //given
       TrelloCardDto dto= new TrelloCardDto("testName","testDescription","top","62fd5e114137ab094ad50581");
        //when
        ResponseEntity<CreatedTrelloCardDto> output =
                trelloController.createTrelloCard(dto);
        //then
        Assertions.assertEquals(output.getBody().getName(), dto.getName());
    }



}
