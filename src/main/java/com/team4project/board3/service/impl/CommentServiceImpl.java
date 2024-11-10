package com.team4project.board3.service.impl;



import com.team4project.board3.dto.CommentDTO;
import com.team4project.board3.service.CommentService;
import com.team4project.domain.Board;
import com.team4project.domain.reply.Comment;

import com.team4project.repository.BoardRepository; // BoardRepository import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private com.team4project.repository.CommentRepository commentRepository;

    @Autowired
    private BoardRepository boardRepository; // BoardRepository 추가

    @Override
    public Comment createComment(Board board, CommentDTO commentDTO) {
        return null;
    }

    @Override
    @Transactional
    public Comment createComment(Long boardId, CommentDTO commentDTO) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        Comment comment = new Comment();
        comment.setContent(commentDTO.getContent());
        comment.setBoard(board); // 게시글 설정

        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getComments(Long boardId) {
        return commentRepository.findByBoardId(boardId); // 게시글 ID로 댓글 조회
    }

    @Override
    @Transactional
    public void deleteComment(Long rno) {
        Comment comment = commentRepository.findById(rno)
                .orElseThrow(() -> new RuntimeException("댓글을 찾을 수 없습니다."));
        commentRepository.delete(comment);
    }

    @Override
    public void deleteComment(Long id, String userId) {

    }

    @Override
    @Transactional
    public Comment updateComment(Long id, CommentDTO commentDTO) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("댓글을 찾을 수 없습니다."));
        comment.setContent(commentDTO.getContent());
        return commentRepository.save(comment);
    }
}
