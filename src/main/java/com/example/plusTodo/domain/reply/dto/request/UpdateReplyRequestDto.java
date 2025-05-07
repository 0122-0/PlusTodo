package com.example.plusTodo.domain.reply.dto.request;

import lombok.Getter;

@Getter

public class UpdateReplyRequestDto {

    private Long userId;
    private String Content;

    public UpdateReplyRequestDto(Long userId, String content) {
        this.userId = userId;
        Content = content;
    }
}
