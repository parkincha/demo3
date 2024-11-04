package com.team4project.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "community_image")
public class CommunityImage implements Comparable<CommunityImage> {
    @Id
    private String uuid;
    private String fileName;
    private int ord;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "communityId") // 외래키 설정 (게시글 번호)
    private CommunityBoard communityBoard;

    @Override
    public int compareTo(CommunityImage other) {
        return this.ord - other.ord;
    } // 정렬을 위한 메소드

    public void changeBoard(CommunityBoard communityBoard) {
        this.communityBoard = communityBoard;
    } // 게시글과 이미지를 연결하기 위한 메소드

    public void setCommunityBoard(CommunityBoard communityBoard) {
        this.communityBoard = communityBoard;
    }
}