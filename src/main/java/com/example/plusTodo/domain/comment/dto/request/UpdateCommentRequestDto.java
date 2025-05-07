package com.example.plusTodo.domain.comment.dto.request;

import lombok.Getter;

@Getter

public class UpdateCommentRequestDto {

    private Long userId;
    private String Content;

    public UpdateCommentRequestDto(Long userId, String content) {

        this.userId = userId;
        this.Content = content;

    }
}
