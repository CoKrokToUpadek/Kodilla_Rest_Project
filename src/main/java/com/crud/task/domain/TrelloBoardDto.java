package com.crud.task.domain;

import lombok.Data;

//https://api.trello.com/1/members/kodillaautor/boards?fields=name,id&key=bd4be40cf179af504be098494a955c9c&token=b93e1ad8b955bb83a846071e2e07b22cd288798d15e6a88e6febcb0caa06014d%29)
@Data
public class TrelloBoardDto {
    private String name;
    private String id;
}
