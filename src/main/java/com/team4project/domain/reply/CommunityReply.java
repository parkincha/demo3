package com.team4project.domain.reply;

import com.team4project.domain.Board;
import com.team4project.domain.CommunityBoard;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "Reply", indexes = {@Index(name = "idx_comment_", columnList = "communityBno")})
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "communityBoard")
public class CommunityReply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    @ManyToOne(fetch = FetchType.LAZY)
    private CommunityBoard communityBoard;

    private String replyText;

    private String replyer;

    public void changeText(String text) {
        this.replyText = text;


    }
}
