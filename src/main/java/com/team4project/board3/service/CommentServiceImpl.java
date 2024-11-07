package com.team4project.board3.service;

import com.team4project.board3.domain.Comment3;
import com.team4project.board3.dto.CommentDTO;
import com.team4project.board3.repository.Comment3Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final Comment3Repository comment3Repository;

    @Override
    @Transactional
    public Comment3 createComment(Long boardId, CommentDTO commentDTO) {
        Comment3 comment3 = new Comment3();
        comment3.setBoardId(boardId);
        comment3.setContent(commentDTO.getContent());
        comment3.setAuthor(commentDTO.getAuthor());
        comment3.setParentCommentId(commentDTO.getParentCommentId());
        return comment3Repository.save(comment3);
    }

    @Override
    public List<Comment3> getComments(Long boardId) {
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