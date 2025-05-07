package com.example.plusTodo.domain.comment;


import com.example.plusTodo.domain.comment.dto.request.CreateCommentRequestDto;
import com.example.plusTodo.domain.comment.dto.request.UpdateCommentRequestDto;
import com.example.plusTodo.domain.comment.dto.response.CreateCommentResponseDto;
import com.example.plusTodo.domain.comment.dto.response.UpdateCommentResponseDto;
import com.example.plusTodo.domain.todo.Todo;
import com.example.plusTodo.domain.todo.TodoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class CommentService {

    private final CommentRepository commentRepository;
    private final TodoRepository todoRepository;


    public CreateCommentResponseDto createComment (CreateCommentRequestDto requestDto, Long todoId){

        Todo findTodoById = todoRepository.findTodoById(todoId);

        Comment comment = new Comment(requestDto.getUserId(), requestDto.getContent(), requestDto.getWriterId(), findTodoById);

        Comment createComment = commentRepository.save(comment);

        return new CreateCommentResponseDto(createComment);
    }

    @Transactional
    public UpdateCommentResponseDto updateComment (Long todoId, Long commentId, UpdateCommentRequestDto requestDto) {

        Todo findTodoById = todoRepository.findTodoById(todoId);

        Comment findCommentById = commentRepository.findCommentById(commentId);

        findCommentById.updatedComment(requestDto.getContent());

        return new UpdateCommentResponseDto(findCommentById);
    }

    @Transactional
    public void deleteComment (Long commentId, Long todoId) {

        Comment findCommentById = commentRepository.findCommentById(commentId);
        if (!findCommentById.getTodo().getId().equals(todoId)){
            throw new IllegalArgumentException("아이디가 다릅니다");
        }

        commentRepository.delete(findCommentById);
    }
}
