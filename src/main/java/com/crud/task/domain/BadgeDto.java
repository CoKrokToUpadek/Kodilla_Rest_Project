package com.crud.task.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BadgeDto {
  @JsonProperty("votes")
  private int votes;
    @JsonProperty("attachmentsByType")
  private AttachmentByType attachments;

  @Data
  private class AttachmentByType{
      @JsonProperty("trello")
      Trello trello;

      @Data
      private class Trello{
          @JsonProperty("board")
          int board;
          @JsonProperty("card")
          int card;
      }
  }
}
