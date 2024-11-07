package com.team4project.board3.dto;

import com.team4project.domain.User;
import com.team4project.domain.boardContent.BoardImage;

import java.util.Set;

public class Board3RequestDTO {
    private Long id; // id 필드 추가
    private String title;
    private String content;
    private User user;
    private Set<BoardImage> image;

    // 기본 생성자
    public Board3RequestDTO() {}

    // Getter와 Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

   /* public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }*/

    public User getUser() {
        return user;
    }

    public void setUser(String author) {
        this.user = user;
    }

    public void setImage(Set<BoardImage> image) {
        this.image = image;
    }

    public Set<BoardImage> getImage() {
        return image;
    }

}

