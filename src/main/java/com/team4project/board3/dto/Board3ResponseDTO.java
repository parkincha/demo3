package com.team4project.board3.dto;

import com.team4project.domain.User;

import java.time.LocalDateTime;

public class Board3ResponseDTO {
    private Long bno;
    private String title;
    private String content;
    private User user;
    private LocalDateTime createdAt;

    // 기본 생성자
    public Board3ResponseDTO() {}

    // Getter와 Setter
    public Long getBno() {
        return bno;
    }

    public void setBno(Long bno) {
        this.bno = bno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
