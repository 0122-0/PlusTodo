package com.example.plusTodo.domain.todo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TodoRequestDto {

    private Long userId;
    private String title;
    private String content;
    private String writerId;

}
