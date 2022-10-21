package com.crud.task.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@AllArgsConstructor
@Builder
public class Mail {
    private final String mailTo;
    private final String toCc;
    private final String subject;
    private final String message;
}