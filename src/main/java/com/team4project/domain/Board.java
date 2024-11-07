package com.team4project.domain;

import com.team4project.domain.boardContent.BoardImage;
import com.team4project.domain.boardContent.PostType;
import com.team4project.domain.boardContent.color.PetColor;
import com.team4project.domain.boardContent.PetType;
import com.team4project.domain.boardContent.Status;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "report_board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reportId")
    private Long bno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user; //작성자

    private String title; // add title

    private String petDescription;
    private Date lostDate;
    private String lostLocation;
    private String petBreeds;
    private String petGender;
    private String petAge;
    private String petWeight;


    @Enumerated(EnumType.STRING)
    private Status status; //게시글 상태

    @Enumerated(EnumType.STRING)
    private PetType petType; //동물 종류

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "petColor")
    private PetColor petColor; //동물 색상

    @Enumerated(EnumType.STRING)
    private PostType postType; //게시글 타입

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="createdAt")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updatedAt")
    private LocalDateTime updatedAt;

    @ColumnDefault("0") //기본값 0
    private Long hitcount; //조회수

    public void updateHitcount() {
        this.hitcount =  this.hitcount+1; //조회수 증가
    }

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = {CascadeType.ALL},
            orphanRemoval = true)
    @BatchSize(size = 50)
    private Set<BoardImage> imageSet = new HashSet<>();

    public void addImage(String uuid, String fileName) {
        BoardImage image = BoardImage.builder()
                .uuid(uuid)
                .fileName(fileName)
                .build();
        imageSet.add(image);
    }

    public void ClearImages() {
        imageSet.forEach(boardImage -> boardImage.changeBoard(null));
        this.imageSet.clear();
    }

}
