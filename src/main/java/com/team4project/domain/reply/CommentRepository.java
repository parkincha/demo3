package com.team4project.domain.reply;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBoardId(Long boardId); // 게시글 ID로 댓글 조회
}