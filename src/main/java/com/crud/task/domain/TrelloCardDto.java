package com.crud.task.domain;

import lombok.Data;

//karty to konkretne pozycje na listach ktore znajduja sie na boardzie
@Data
public class TrelloCardDto {
    private String name;
    private String description;
    private String pos;
    private String listId;
}
