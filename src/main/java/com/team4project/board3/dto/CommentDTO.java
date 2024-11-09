package com.team4project.board3.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {
    private Long rno;
    private Long board; // Board3 게시글 ID
    private Long parentCommentId; // 대댓글의 부모 댓글 ID (없으면 null)
    private String commentText;
    private String commenter;
}