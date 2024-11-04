package com.team4project.domain.reply;

import com.team4project.domain.CommunityBoard;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Reply", indexes = {@Index(name = "idx_comment_", columnList = "communityId")}) // 컬럼 이름 수정
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
    @JoinColumn(name = "communityId") // 외래 키 이름 설정
    private CommunityBoard communityBoard;

    private String replyText;

    private String replyer;

    public void changeText(String text) {
        this.replyText = text;
    }
}
