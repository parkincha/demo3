package com.team4project.board3.controller;

import com.team4project.board3.domain.Comment3;
import com.team4project.board3.dto.CommentDTO;
import com.team4project.board3.service.CommentService;
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
        Comment3 comment3 = commentService.createComment(boardId, commentDTO);
        return ResponseEntity.ok(comment3.getId());
    }

    // 특정 게시글의 댓글 및 대댓글 조회
    @GetMapping("/{boardId}")
    public ResponseEntity<List<Comment3>> getComments(@PathVariable Long boardId) {
        List<Comment3> comment3s = commentService.getComments(boardId);
        return ResponseEntity.ok(comment3s);
    }

    // 댓글 삭제 (대댓글도 함께 삭제 가능하도록 설정)
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> removeComment(@PathVariable("id") Long id){
        commentService.deleteComment(id);
        return ResponseEntity.ok(id);
    }
}
