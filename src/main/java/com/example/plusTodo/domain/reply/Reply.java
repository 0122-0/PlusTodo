package com.example.plusTodo.domain.reply;

import com.example.plusTodo.common.BaseEntity;
import com.example.plusTodo.domain.comment.Comment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@Table(name = "replys")
@NoArgsConstructor

public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column (nullable = false)
    private Long userId;

    @Column (nullable = false)
    private String content;

    @Column (nullable = false)
    private String writerId;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id", nullable = false)
    private Comment comment;

    public Reply (Long userId, String content, String writerId, Comment comment){
        this.userId = userId;
        this.content = content;
        this.writerId = writerId;
        this.comment = comment;
    }

    public void updatedReply (String content){
        this.content = content;
    }
}
