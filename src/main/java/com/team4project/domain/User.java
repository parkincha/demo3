package com.team4project.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, name = "userNo")
    private Long uNo; // 계정 고유 아이디
    @Column(nullable = false, unique = true)
    private String userId; // add username field
    private String name;
    private String pwd;
    private String email;
    private String mobile;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;
    private String role;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Board> boards = new ArrayList<>();

    public void setUsername(String testUser) { //은호. 빌드 오류 방지용 메소드 작성. 보드 작업하시다가 필요없으면 삭제해도 됩니다.
    }
}