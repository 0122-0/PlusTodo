package com.example.plusTodo.domain.reply;

import com.example.plusTodo.domain.comment.Comment;
import com.example.plusTodo.domain.comment.CommentRepository;
import com.example.plusTodo.domain.reply.dto.request.CreateReplyRequestDto;
import com.example.plusTodo.domain.reply.dto.request.UpdateReplyRequestDto;
import com.example.plusTodo.domain.reply.dto.response.CreateReplyResponseDto;
import com.example.plusTodo.domain.reply.dto.response.UpdateReplyResponseDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ReplyService {

    private final ReplyRepository replyRepository;
    private final CommentRepository commentRepository;


    public CreateReplyResponseDto createReply (CreateReplyRequestDto requestDto, Long commentId){

        Comment findCommentById = commentRepository.findCommentById(commentId);

        Reply reply = new Reply(requestDto.getUserId(), requestDto.getContent(), requestDto.getWriterId(), findCommentById);

        Reply createReply = replyRepository.save(reply);

        return new CreateReplyResponseDto(createReply);
    }

    @Transactional
    public UpdateReplyResponseDto updateReply (Long commentId, Long replyId , UpdateReplyRequestDto replyRequestDto){
        Comment findCommnetById = commentRepository.findCommentById(commentId);

        Reply findReplyById = replyRepository.findReplyById(replyId);

        findReplyById.updatedReply(replyRequestDto.getContent());

        return new UpdateReplyResponseDto(findReplyById);
    }

    @Transactional
    public void deleteReply (Long replyId, Long commentId){

        Reply findReplyById = replyRepository.findReplyById(replyId);
        if(!findReplyById.getComment().getId().equals(commentId)){
            throw new IllegalArgumentException("아이디가 다릅니다.");
        }

        replyRepository.delete(findReplyById);
    }
}
