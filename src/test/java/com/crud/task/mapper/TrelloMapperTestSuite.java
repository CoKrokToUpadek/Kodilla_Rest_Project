package com.crud.task.mapper;

import com.crud.task.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TrelloMapperTestSuite {

    @Autowired
    TrelloMapper trelloMapper;

    @Test
    void MapToBoardsTest(){
        //given
        TrelloListDto list1=new TrelloListDto("1","testList1",true);
        TrelloListDto list2=new TrelloListDto("2","testList2",true);
        List<TrelloListDto> testList1= new ArrayList<>();
        testList1.add(list1);
        testList1.add(list2);
        List<TrelloBoardDto> trelloBoardDto1=new ArrayList<>();
        trelloBoardDto1.add(new TrelloBoardDto("1","testBoard1",testList1));
        //when
        List<TrelloBoard> testBoard= trelloMapper.mapToBoards(trelloBoardDto1);
        //then
        Assertions.assertEquals(1, testBoard.size());
        Assertions.assertSame("testBoard1", testBoard.get(0).getName());
    }

    @Test
    void MapToBoardsDtoTest(){
        //given
        TrelloList list1=new TrelloList("1","testList1",true);
        TrelloList list2=new TrelloList("2","testList2",true);
        List<TrelloList> testList1= new ArrayList<>();
        testList1.add(list1);
        testList1.add(list2);
        List<TrelloBoard> trelloBoards=new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1","testBoard1",testList1));
        //when
        List<TrelloBoardDto> testBoard= trelloMapper.mapToBoardsDto(trelloBoards);
        //then
        Assertions.assertEquals(1, testBoard.size());
        Assertions.assertSame("testBoard1", testBoard.get(0).getName());
    }

    @Test
    void MapToListTest(){
        //given
        TrelloListDto list1=new TrelloListDto("1","testList1",true);
        TrelloListDto list2=new TrelloListDto("2","testList2",true);
        List<TrelloListDto> testListDto= new ArrayList<>();
        testListDto.add(list1);
        testListDto.add(list2);
        //when
        List<TrelloList> trelloList=trelloMapper.mapToList(testListDto);
        //then
        Assertions.assertEquals(2, trelloList.size());
        Assertions.assertSame("testList1", trelloList.get(0).getName());
    }

    @Test
    void MapToListDtoTest(){
        //given
        TrelloList list1=new TrelloList("1","testList1",true);
        TrelloList list2=new TrelloList("2","testList2",true);
        List<TrelloList> testListDto= new ArrayList<>();
        testListDto.add(list1);
        testListDto.add(list2);
        //when
        List<TrelloListDto> trelloList=trelloMapper.mapToListDto(testListDto);
        //then
        Assertions.assertEquals(2, trelloList.size());
        Assertions.assertSame("testList1", trelloList.get(0).getName());
    }
    @Test
    void MapToCardTest(){
        //given
        TrelloCardDto trelloCardDto=new TrelloCardDto("testName1","testDescription1","TestPos1","testListId1");
        //when
        TrelloCard trelloCard=trelloMapper.mapToCard(trelloCardDto);
        //then
        Assertions.assertEquals("testName1",trelloCard.getName());

    }

    @Test
    void MapToCardDtoTest(){
        //given
        TrelloCard trelloCard=new TrelloCard("testName1","testDescription1","TestPos1","testListId1");
        //when
        TrelloCardDto trelloCardDto=trelloMapper.mapToCardDto(trelloCard);
        //then
        Assertions.assertEquals("testName1",trelloCardDto.getName());
    }

}
