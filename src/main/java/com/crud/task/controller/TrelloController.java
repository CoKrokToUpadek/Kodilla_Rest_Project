package com.crud.task.controller;


import com.crud.task.domain.CreatedTrelloCardDto;
import com.crud.task.domain.TrelloBoardDto;
import com.crud.task.domain.TrelloCardDto;
import com.crud.task.service.TrelloService;
import com.crud.task.trello.facade.TrelloFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/trello")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TrelloController {

    private final TrelloFacade trelloFacade;


    @GetMapping("boards2")
    public ResponseEntity<List<TrelloBoardDto>> getTrelloBoards() {
        return ResponseEntity.ok(trelloFacade.fetchTrelloBoards());
    }

    @PostMapping("cards")
    public ResponseEntity<CreatedTrelloCardDto> createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return ResponseEntity.ok(trelloFacade.createCard(trelloCardDto));
    }

//    @GetMapping("boards")
//    public void getTrelloBoards(@RequestParam(required = false) boolean filter) {
//        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
//
//        if(!filter){
//            trelloBoards.forEach(trelloBoardDto -> {
//                System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName());
//            });
//        }else {
//            trelloBoards.forEach(trelloBoardDto -> {
//                if (!trelloBoardDto.getName().isEmpty() && trelloBoardDto.getName().contains("Kodilla") && !trelloBoardDto.getId().isEmpty()){
//                    System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName());
//                }
//            });
//        }
//    }

//    @GetMapping("boardsWithResponse")
//    public ResponseEntity<List<TrelloBoardDto>> getTrelloBoardsWithResponse(){
//        return ResponseEntity.ok(trelloClient.getTrelloBoardsWithLogs());
//    }

//    @PostMapping("cardsWithResponse")
//    public ResponseEntity<CreatedTrelloCard> createTrelloCardWithResponse(@RequestBody TrelloCardDto trelloCardDto){
//        return ResponseEntity.ok(trelloClient.createNewCard(trelloCardDto));
//    }


//    @GetMapping("boards2")
//    public List<TrelloBoardDto> getTrelloBoardsV2() {
//        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
//
//        trelloBoards.forEach(trelloBoardDto -> {
//            System.out.println(trelloBoardDto.getId() + " - " + trelloBoardDto.getName());
//            System.out.println("This board contains lists: ");
//            trelloBoardDto.getLists().forEach(trelloList -> {
//                System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed());
//            });
//        });
//        return trelloBoards;
//    }
//
//    @PostMapping("cards")
//    public CreatedTrelloCard createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
//        CreatedTrelloCard test=trelloClient.createNewCard(trelloCardDto);
//        //for testing purpose
//        System.out.println(test);
//        return test;
//
//    }

}


