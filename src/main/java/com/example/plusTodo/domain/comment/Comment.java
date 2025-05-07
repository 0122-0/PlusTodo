package com.example.plusTodo.domain.comment;

import com.example.plusTodo.common.BaseEntity;
import com.example.plusTodo.domain.reply.Reply;
import com.example.plusTodo.domain.todo.Todo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table (name = "comments")
@NoArgsConstructor

public class Comment extends BaseEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column (nullable = false)
    private String content;

    @Column (nullable = false)
    private String writerId;

    @Column (nullable = false)
    private Long userId;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id", nullable = false)
    private Todo todo;

    @OneToMany (mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reply> reply = new ArrayList<>();

    public Comment(Long userId, String content, String writerId, Todo todo) {
        this.todo = todo;
        this.userId = userId;
        this.content = content;
        this.writerId = writerId;
    }

    public void updatedComment (String content) {
        this.content = content;

    }
}
