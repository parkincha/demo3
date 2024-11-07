package com.team4project.board3.service;

import com.team4project.board3.domain.Comment3;
import com.team4project.board3.dto.CommentDTO;
import com.team4project.board3.repository.Comment3Repository;
import com.team4project.domain.Board;
import com.team4project.domain.reply.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final Comment3Repository comment3Repository;

    @Transactional
    @Override
    public Comment createComment(Board board, CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setBoard(board);
        comment.setCommentText(commentDTO.getCommentText());
        comment.setCommenter(commentDTO.getCommenter());
        comment.setParentCommentId(commentDTO.getParentCommentId());
        return comment3Repository.save(comment);
    }

    @Override
    public Comment createComment(Long boardId, CommentDTO commentDTO) {
        return null;
    }

    @Override
    public List<Comment> getComments(Long boardId) {
        // 특정 게시글의 댓글 및 대댓글을 조회하여 반환
        return comment3Repository.findByBoardIdOrderByCreatedAtAsc(boardId);
    }

    @Override
    @Transactional
    public void deleteComment(Long id) {
        // 대댓글을 포함하여 댓글 삭제 처리
        comment3Repository.deleteById(id);
    }
}