package com.example.plusTodo.controller;

import com.example.plusTodo.domain.comment.dto.request.UpdateCommentRequestDto;
import com.example.plusTodo.domain.reply.Reply;
import com.example.plusTodo.domain.reply.ReplyService;
import com.example.plusTodo.domain.reply.dto.request.CreateReplyRequestDto;
import com.example.plusTodo.domain.reply.dto.request.UpdateReplyRequestDto;
import com.example.plusTodo.domain.reply.dto.response.CreateReplyResponseDto;
import com.example.plusTodo.domain.reply.dto.response.UpdateReplyResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments/{commentId}/replys")
@RequiredArgsConstructor

public class ReplyController {

    private final ReplyService replyService;

    @PostMapping
    public ResponseEntity<CreateReplyResponseDto> createReply (@RequestBody CreateReplyRequestDto requestDto, @PathVariable Long commentId){

        CreateReplyResponseDto responseDto = replyService.createReply(requestDto, commentId);

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{replyId}")
    public ResponseEntity<UpdateReplyResponseDto> updateReply ( @PathVariable Long commentId , @PathVariable Long replyId, @RequestBody UpdateReplyRequestDto requestDto){

        UpdateReplyResponseDto responseDto = replyService.updateReply(commentId,replyId,requestDto);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{replyId}")
    public ResponseEntity<Reply> deleteReply (@PathVariable Long replyId, @PathVariable Long commentId){

        replyService.deleteReply(replyId, commentId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

