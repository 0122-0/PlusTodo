package com.example.plusTodo.domain.todo.dto.response;

import com.example.plusTodo.domain.comment.dto.response.CommentWithReplyDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor

public class TodoWithCommentDto {

    private Long userId;
    private String content;
    private String writerId;
    private LocalDateTime updatedAt;
    private List<CommentWithReplyDto> commentWithReplyDto;

}
