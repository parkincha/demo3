package com.team4project.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "community_board")
public class CommunityBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "communityId")
    private Long bno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user; // 작성자

    private String title; // add title

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdAt")
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedAt")
    private Date updatedAt;

    @ColumnDefault("0") // 기본값 0
    private Long hitcount; // 조회수

    public void updateHitcount() {
        this.hitcount = this.hitcount + 1; // 조회수 증가
    }

    @OneToMany(mappedBy = "communityBoard", fetch = FetchType.LAZY, cascade = {CascadeType.ALL},
            orphanRemoval = true)
    @BatchSize(size = 50)
    private Set<CommunityImage> imageSet = new HashSet<>();

    public void addImage(String uuid, String fileName) {
        CommunityImage image = CommunityImage.builder()
                .uuid(uuid)
                .fileName(fileName)
                .communityBoard(this)
                .build();
        imageSet.add(image);
    }

    public void clearImages() {
        imageSet.forEach(image -> image.setCommunityBoard(null));
        imageSet.clear();
    }
}