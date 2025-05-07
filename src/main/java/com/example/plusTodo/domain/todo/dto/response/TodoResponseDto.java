package com.example.plusTodo.domain.todo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class TodoResponseDto {

    private Long userId;
    private String title;
    private String content;
    private String writerId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<TodoWithCommentDto> todoWithCommentDto;


}
