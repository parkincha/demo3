package com.team4project.controller;

import com.team4project.board3.dto.CommentDTO;
import com.team4project.board3.service.CommentService;
import com.team4project.domain.reply.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody CommentDTO commentDTO) {
        Comment updatedComment = commentService.updateComment(id, commentDTO);
        return ResponseEntity.ok(updatedComment);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        commentService.deleteComment(id, userDetails.getUsername());
        return ResponseEntity.ok("댓글이 삭제되었습니다.");
    }
}