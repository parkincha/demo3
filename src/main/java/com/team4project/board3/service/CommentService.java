package com.team4project.board3.service;

import com.team4project.board3.domain.Comment3;
import com.team4project.board3.dto.CommentDTO;

import java.util.List;

public interface CommentService {
    Comment3 createComment(Long boardId, CommentDTO commentDTO);
    List<Comment3> getComments(Long boardId);
    void deleteComment(Long id);
}
