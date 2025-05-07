package com.example.plusTodo.domain.comment.dto.response;

import com.example.plusTodo.domain.comment.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateCommentResponseDto {

    private Long userId;
    private String content;
    private String writerId;
    private LocalDateTime updatedAt;

    public UpdateCommentResponseDto(Comment comment) {
        this.userId = comment.getUserId();
        this.content = comment.getContent();
        this.writerId = comment.getWriterId();
        this.updatedAt = comment.getUpdatedAt();
    }
}
