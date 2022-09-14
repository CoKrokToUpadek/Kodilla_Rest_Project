package com.crud.task.controller;


import com.crud.task.domain.CreatedTrelloCard;
import com.crud.task.domain.TrelloBoardDto;
import com.crud.task.domain.TrelloCardDto;
import com.crud.task.trello.client.TrelloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/trello")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TrelloController {

    private final TrelloClient trelloClient;

    @GetMapping("boards")
    public void getTrelloBoards(@RequestParam(required = false) boolean filter) {
        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        if(!filter){
            trelloBoards.forEach(trelloBoardDto -> {
                System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName());
            });
        }else {
            trelloBoards.forEach(trelloBoardDto -> {
                if (!trelloBoardDto.getName().isEmpty() && trelloBoardDto.getName().contains("Kodilla") && !trelloBoardDto.getId().isEmpty()){
                    System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName());
                }
            });
        }
    }

    @GetMapping("boards2")
    public void getTrelloBoardsV2() {
        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        trelloBoards.forEach(trelloBoardDto -> {
            System.out.println(trelloBoardDto.getId() + " - " + trelloBoardDto.getName());
            System.out.println("This board contains lists: ");
            trelloBoardDto.getLists().forEach(trelloList -> {
                System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed());
            });
        });
    }

    @PostMapping("cards")
    public CreatedTrelloCard createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloClient.createNewCard(trelloCardDto);
    }

}


