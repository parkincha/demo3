package com.team4project.domain.reply;

import com.team4project.domain.Board;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Comment", indexes = {@Index(name = "idx_comment_board", columnList = "board_bno")})
@Getter
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

    public void changeText(String text) {
        this.commentText = text;
    }
}
