package com.team4project.board4.domain;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "board")
@Entity
@Table(name = "community_reply")
public class Creply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cboard cboard;

    private String replyText;
    private String replyer;

    public void changeText(String text) {
        this.replyText = text;
    }
}
