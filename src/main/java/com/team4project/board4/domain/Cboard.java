package com.team4project.board4.domain;



import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.ColumnDefault;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "imageSet")
@Builder
public class Cboard extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cno;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false, length = 1000)
    private String content;
    @Column(nullable = false)
    private String userId;

    public void change(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @ColumnDefault("0")
    private int visitcount;

    public void updateVisitcount() {
        this.visitcount = this.visitcount++;
    }

    @OneToMany(mappedBy = "cboard", fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true)
    @Builder.Default
    @BatchSize(size = 20)
    private Set<CboardImage> imageSet = new HashSet<>();

    //image
    public void addImage(String uuid, String fileName) {
        CboardImage image = CboardImage.builder()
                .uuid(uuid)
                .fileName(fileName)
                .cboard(this)
                .ord(imageSet.size())
                .build();
        imageSet.add(image);
    }
    public void clearImages() {
        imageSet.forEach(boardImage -> boardImage.changeBoard(null));
        this.imageSet.clear();
    }



}
