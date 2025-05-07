package com.example.plusTodo.controller;

import com.example.plusTodo.domain.comment.Comment;
import com.example.plusTodo.domain.comment.CommentService;
import com.example.plusTodo.domain.comment.dto.request.CreateCommentRequestDto;
import com.example.plusTodo.domain.comment.dto.request.UpdateCommentRequestDto;
import com.example.plusTodo.domain.comment.dto.response.CreateCommentResponseDto;
import com.example.plusTodo.domain.comment.dto.response.UpdateCommentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos/{todoId}/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;


    @PostMapping
    public ResponseEntity<CreateCommentResponseDto> createComment(@RequestBody CreateCommentRequestDto requestDto, @PathVariable Long todoId){

        CreateCommentResponseDto responseDto = commentService.createComment(requestDto, todoId);

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{commentId}")
    public ResponseEntity<UpdateCommentResponseDto> updateComment (@PathVariable Long todoId, @PathVariable Long commentId, @RequestBody UpdateCommentRequestDto requestDto) {

        UpdateCommentResponseDto updateComment = commentService.updateComment(todoId,commentId,requestDto);

        return new ResponseEntity<>(updateComment, HttpStatus.OK);
    }


    @DeleteMapping("/{commentId}")
    public ResponseEntity<Comment> deleteComment (@PathVariable Long commentId, @PathVariable Long todoId){

        commentService.deleteComment(commentId, todoId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
