package com.example.plusTodo.domain.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface TodoRepository extends JpaRepository<Todo, Long> {

    Todo findTodoById (Long todoId);

    @Query ("Select t from Todo t left join fetch t.comment c where t.id = :todoId order by c.createdAt asc")
    Todo findByIdWithComment (@Param ("todoId")Long todoId);

}
