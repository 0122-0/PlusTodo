package com.example.plusTodo.domain.todo.dto.response;

import com.example.plusTodo.domain.todo.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CreateTodoResponseDto {

    private Long userId;
    private String title;
    private String content;
    private String writerId;
    private LocalDateTime createdAt;

    public CreateTodoResponseDto(Todo todo) {

        this.userId = todo.getUserId();
        this.title = todo.getTitle();
        this.content = todo.getContent();
        this.writerId = todo.getWriterId();
        this.createdAt = todo.getCreatedAt();

    }
}
