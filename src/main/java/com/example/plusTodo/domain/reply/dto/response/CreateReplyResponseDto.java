package com.example.plusTodo.domain.reply.dto.response;

import com.example.plusTodo.domain.reply.Reply;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CreateReplyResponseDto {

    private Long userId;
    private String content;
    private String writerId;
    private LocalDateTime createdAt;

    public CreateReplyResponseDto(Reply reply) {
        this.userId = reply.getUserId();
        this.content = reply.getContent();
        this.writerId = reply.getWriterId();
        this.createdAt = reply.getCreatedAt();
    }
}
