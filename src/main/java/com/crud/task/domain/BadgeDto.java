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


    @Override
    public String toString() {
        return "BadgeDto{" +
                "votes=" + votes +
                ", attachments=" + attachments +
                '}';
    }

    @Data
  @JsonIgnoreProperties(ignoreUnknown = true)
  private class AttachmentByType{
      @JsonProperty("trello")
      Trello trello;


      @Override
      public String toString() {
          return "AttachmentByType{" +
                  "trello=" + trello +
                  '}';
      }

      @Data
      @JsonIgnoreProperties(ignoreUnknown = true)
      private class Trello{
          @JsonProperty("board")
          int board;
          @JsonProperty("card")
          int card;

          @Override
          public String toString() {
              return "Trello{" +
                      "board=" + board +
                      ", card=" + card +
                      '}';
          }
      }
  }
}
