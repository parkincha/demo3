package com.team4project.board3.dto;

public class Board3DTO {
    private Long id;
    private String title;
    private String content;
    private String author;

    // 기본 생성자
    public Board3DTO() {}

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommenter() {
        return author;
    }

    public void setCommenter(String author) {
        this.author = author;
    }
}

