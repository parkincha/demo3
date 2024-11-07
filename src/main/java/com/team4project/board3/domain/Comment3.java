package com.team4project.board3.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comment3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long boardId; // Board3 게시글 ID

    @Column(nullable = true)
    private Long parentCommentId; // 부모 댓글 ID, 없으면 null (일반 댓글), 값이 있으면 대댓글

    @Column(nullable = false, length = 500)
    private String content;

    @Column(nullable = false)
    private String author;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @CreationTimestamp
    private LocalDateTime updatedAt;

    // 생성자
    public Comment3(Long boardId, Long parentCommentId, String content, String author) {
        this.boardId = boardId;
        this.parentCommentId = parentCommentId;
        this.content = content;
        this.author = author;
    }
}
