package com.example.plusTodo.controller;



import com.example.plusTodo.domain.todo.TodoService;
import com.example.plusTodo.domain.todo.dto.request.CreateTodoRequestDto;
import com.example.plusTodo.domain.todo.dto.request.TodoRequestDto;
import com.example.plusTodo.domain.todo.dto.request.UpdateTodoRequestDto;
import com.example.plusTodo.domain.todo.dto.response.CreateTodoResponseDto;
import com.example.plusTodo.domain.todo.dto.response.TodoListResponseDto;
import com.example.plusTodo.domain.todo.dto.response.TodoResponseDto;
import com.example.plusTodo.domain.todo.dto.response.UpdateTodoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor

public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<CreateTodoResponseDto> createTodo(@RequestBody CreateTodoRequestDto requestDto) {

        CreateTodoResponseDto responseDto = todoService.createTodo(requestDto);

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDto> findTodoById (@PathVariable Long id){

        TodoResponseDto findedById = todoService.findTodoById(id);

        return new ResponseEntity<>(findedById, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TodoListResponseDto>> findAll () {

        List<TodoListResponseDto> findAll = todoService.findAllTodo();

        return new ResponseEntity<>(findAll, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UpdateTodoResponseDto> updateTodo (@PathVariable Long id, @RequestBody UpdateTodoRequestDto requestDto) {

        UpdateTodoResponseDto update = todoService.updateTodo(id, requestDto);

        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TodoRequestDto> deleteTodo (@PathVariable Long id){

        todoService.deleteTodo(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
