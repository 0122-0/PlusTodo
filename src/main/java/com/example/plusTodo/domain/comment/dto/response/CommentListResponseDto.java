package com.example.plusTodo.domain.comment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentListResponseDto {

    private Long userId;
    private String content;
    private String writerId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int size;
}
