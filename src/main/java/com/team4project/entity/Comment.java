package com.team4project.entity;

import com.team4project.domain.Board;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno; // 댓글 고유 ID

    private String content; // 댓글 내용

    @ManyToOne // 게시글과의 관계 설정
    @JoinColumn(name = "board_id")
    private Board board; // 댓글이 속한 게시글

    // 추가적으로 필요한 필드 설정
}