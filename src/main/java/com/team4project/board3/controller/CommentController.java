package com.team4project.board3.controller;

import com.team4project.board3.domain.Comment3;
import com.team4project.board3.dto.CommentDTO;
import com.team4project.board3.service.CommentService;
import com.team4project.domain.reply.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board3/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 댓글 및 대댓글 생성
    @PostMapping("/{boardId}")
    public ResponseEntity<Long> createComment(
            @PathVariable Long boardId,
            @RequestBody CommentDTO commentDTO
    ) {
        Comment comment = commentService.createComment(boardId, commentDTO);
        return ResponseEntity.ok(comment.getRno());
    }

    // 특정 게시글의 댓글 및 대댓글 조회
    @GetMapping("/{boardId}")
    public ResponseEntity<List<Comment>> getComments(@PathVariable Long boardId) {
        List<Comment> comment3s = commentService.getComments(boardId);
        return ResponseEntity.ok(comment3s);
    }

    // 댓글 삭제 (대댓글도 함께 삭제 가능하도록 설정)
    @DeleteMapping("/{rno}")
    public ResponseEntity<Long> removeComment(@PathVariable("rno") Long rno){
        commentService.deleteComment(rno);
        return ResponseEntity.ok(rno);
    }
}
