package com.crud.task.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//karty to konkretne pozycje na listach ktore znajduja sie na boardzie
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrelloCardDto {
    private String name;
    private String description;
    private String pos;
    private String listId;
}
