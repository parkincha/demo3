package com.team4project.domain;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.stream.events.Comment;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, name = "userId") //username은 null이면 안되고, 중복되면 안된다.
    private Long id; // 계정 아이디
    private String name;
    private String pwd;
    private String email;
    private String mobile;
    private LocalDateTime createdDate;
    private String role;

    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)  // 사용자와 게시글은 1:N 관계
    private List<Board> boards = new ArrayList<>();


}

