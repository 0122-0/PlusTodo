package com.example.plusTodo.domain.todo;

import com.example.plusTodo.domain.comment.dto.response.CommentWithReplyDto;
import com.example.plusTodo.domain.todo.dto.request.CreateTodoRequestDto;
import com.example.plusTodo.domain.todo.dto.request.UpdateTodoRequestDto;
import com.example.plusTodo.domain.todo.dto.response.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public CreateTodoResponseDto createTodo (CreateTodoRequestDto requestDto){

        Todo todo = new Todo(requestDto.getUserId(), requestDto.getTitle(), requestDto.getContent(), requestDto.getWriterId());

        Todo createTodo = todoRepository.save(todo);

        return new CreateTodoResponseDto(createTodo);
    }

    @Transactional
    public TodoResponseDto findTodoById (Long todoId) {

        Todo findByIdWithComment = todoRepository.findByIdWithComment(todoId);

        return new TodoResponseDto(
                findByIdWithComment.getUserId(),
                findByIdWithComment.getTitle(),
                findByIdWithComment.getContent(),
                findByIdWithComment.getWriterId(),
                findByIdWithComment.getCreatedAt(),
                findByIdWithComment.getUpdatedAt(),
                findByIdWithComment.getComment().stream().map(
                        comment -> new TodoWithCommentDto(
                                comment.getUserId(),
                                comment.getContent(),
                                comment.getWriterId(),
                                comment.getUpdatedAt(),
                                comment.getReply().stream().map(reply -> new CommentWithReplyDto(
                                        reply.getUserId(),
                                        reply.getContent(),
                                        reply.getWriterId(),
                                        reply.getUpdatedAt()))
                                        .toList()))
                        .toList()
                );
    }

    @Transactional
    public List<TodoListResponseDto> findAllTodo() {

        return todoRepository.findAll()
                .stream()
                .map(todo -> new TodoListResponseDto(
                        todo.getUserId(),
                        todo.getTitle(),
                        todo.getContent(),
                        todo.getWriterId(),
                        todo.getCreatedAt(),
                        todo.getUpdatedAt(),
                        todo.getComment().size()
                ))
                .toList();
    }

    @Transactional
    public UpdateTodoResponseDto updateTodo (Long id, UpdateTodoRequestDto requestDto) {


        Todo findTodoById = todoRepository.findTodoById(id);

        if(findTodoById.getUserId() != requestDto.getUserId()){
            throw new IllegalArgumentException("아이디가 다릅니다.");
       }

        findTodoById.updatedTodo(requestDto.getTitle(), requestDto.getContent());


        return new UpdateTodoResponseDto(findTodoById);
    }

    @Transactional
    public void deleteTodo (Long id) {

        Todo findTodo = todoRepository.findTodoById(id);

        todoRepository.delete(findTodo);
    }
}