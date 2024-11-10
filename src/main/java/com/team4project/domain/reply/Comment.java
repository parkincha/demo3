package com.team4project.domain.reply;

import com.team4project.domain.Board;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "Comment", indexes = {@Index(name = "idx_comment_board", columnList = "board_bno")})
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "board")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_bno") // 외래 키 열 이름을 명시적으로 지정
    private Board board;

    private String commentText;

    private String commenter;

    private Long parentCommentId; // 대댓글의 부모 댓글 ID (없으면 null)


    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @CreationTimestamp
    private LocalDateTime updatedAt;

    public void changeText(String text) {
        this.commentText = text;
    }

    public void setContent(String content) {
    }
}
