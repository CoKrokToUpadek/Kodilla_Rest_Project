package com.crud.task.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

//https://api.trello.com/1/members/kodillaautor/boards?fields=name,id&key=bd4be40cf179af504be098494a955c9c&token=b93e1ad8b955bb83a846071e2e07b22cd288798d15e6a88e6febcb0caa06014d%29)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class TrelloBoardDto {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("lists")
    private List<TrelloListDto> lists;

}