package com.example.plusTodo.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CommentRepository extends JpaRepository<Comment, Long> {

    Comment findCommentById (Long id);


}
