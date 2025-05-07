package com.example.plusTodo.domain.comment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor

public class CommentWithReplyDto {

    private Long userId;
    private String content;
    private String writerId;
    private LocalDateTime updatedAt;


}
