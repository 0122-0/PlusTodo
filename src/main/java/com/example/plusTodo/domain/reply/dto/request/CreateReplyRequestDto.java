package com.example.plusTodo.domain.reply.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class CreateReplyRequestDto {

    private Long userId;
    private String content;
    private String writerId;

}
