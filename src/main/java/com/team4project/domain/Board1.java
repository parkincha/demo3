package com.team4project.domain;

import jakarta.persistence.*;
import lombok.*;

/**
 * Board1 엔티티 클래스 - 반려동물 찾기 게시판 전용 엔티티
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String postType;     // 게시판 유형 (예: 반려동물 찾기 게시판 전용)

    private String petType;      // 반려동물 종류
    private String petName;      // 반려동물 이름
    private String lostLocation; // 잃어버린 장소

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}