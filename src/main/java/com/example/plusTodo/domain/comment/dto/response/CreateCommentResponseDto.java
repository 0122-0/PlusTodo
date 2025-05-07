package com.example.plusTodo.domain.comment.dto.response;

import com.example.plusTodo.domain.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor

public class CreateCommentResponseDto {

    private Long userId;
    private String content;
    private String writerId;
    private LocalDateTime createdAt;

    public CreateCommentResponseDto(Comment comment) {
        this.userId = comment.getUserId();
        this.writerId = comment.getWriterId();
        this.content = comment.getContent();
        this.createdAt = comment.getCreatedAt();
    }
}
