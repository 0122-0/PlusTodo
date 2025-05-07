package com.example.plusTodo.domain.todo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateTodoRequestDto {

    private final Long userId;

    private final String title;

    private final String content;


}
