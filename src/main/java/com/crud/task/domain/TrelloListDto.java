package com.crud.task.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//igonoruje pola odpowiedzi jsona które nie znajdują sie w klasie
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrelloListDto {

    //przypisuje pola odpowiedzi jsona do konkrentych pól w klasie. Można dzięki temu zmienić nazwe pola w klasie
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("closed")
    private boolean isClosed;
}