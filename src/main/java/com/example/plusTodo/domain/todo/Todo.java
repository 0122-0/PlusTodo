package com.example.plusTodo.domain.todo;

import com.example.plusTodo.common.BaseEntity;
import com.example.plusTodo.domain.comment.Comment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "todos")
@NoArgsConstructor
@AllArgsConstructor
public class Todo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private Long userId;

    @Column (nullable = false)
    private String title;

    @Column (nullable = false)
    private String content;

    @Column (nullable = false)
    private String writerId;

    @OneToMany (mappedBy = "todo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comment = new ArrayList<>();

    public Todo (Long userId, String title, String content, String writerId){
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.writerId = writerId;
    }

    public void updatedTodo (String title, String content) {
        this.title = title;
        this.content = content;
    }


}
