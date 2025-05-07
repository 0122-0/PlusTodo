package com.example.plusTodo.domain.reply.dto.response;

import com.example.plusTodo.domain.reply.Reply;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateReplyResponseDto {

    private Long userId;
    private String content;
    private String writerId;
    private LocalDateTime updatedAt;

    public UpdateReplyResponseDto(Reply reply) {

        this.userId = reply.getUserId();
        this.content = reply.getContent();
        this.writerId = reply.getWriterId();
        this.updatedAt = reply.getUpdatedAt();

    }
}
