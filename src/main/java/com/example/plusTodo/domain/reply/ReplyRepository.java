package com.example.plusTodo.domain.reply;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    Reply findReplyById (Long id);

}
