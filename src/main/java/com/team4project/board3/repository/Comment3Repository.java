package com.team4project.board3.repository;

import com.team4project.board3.domain.Comment3;
import com.team4project.domain.reply.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Comment3Repository extends JpaRepository<Comment, Long> {
    List<Comment> findByBoardIdOrderByCreatedAtAsc(Long boardId);
}
