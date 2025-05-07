package com.example.plusTodo.domain.todo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TodoListResponseDto {

    private Long userId;
    private String title;
    private String content;
    private String writerId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int commentSize;

}
