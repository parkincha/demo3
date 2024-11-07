package com.team4project.board3.service;

import com.team4project.board3.dto.CommentDTO;
import com.team4project.domain.Board;
import com.team4project.domain.reply.Comment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentService {
    @Transactional
    Comment createComment(Board board, CommentDTO commentDTO);

    Comment createComment(Long boardId, CommentDTO commentDTO);
    List<Comment> getComments(Long boardId);
    void deleteComment(Long id);
}
