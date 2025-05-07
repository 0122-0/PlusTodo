package com.example.plusTodo.domain.comment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor

public class CreateCommentRequestDto {

    private Long userId;
    private String content;
    private String writerId;
    private LocalDateTime createdAt;

}
