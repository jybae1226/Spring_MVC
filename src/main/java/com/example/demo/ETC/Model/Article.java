package com.example.demo.ETC.Model;

import java.time.LocalDateTime;

public class Article {
    private Long id;
    private Long board_id;
    private Long author_id;
    private String title;
    private String content;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;

    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.created_date=LocalDateTime.now();
        this.modified_date=LocalDateTime.now();
    }

    public Article(Long id, Long board_id, Long author_id, String title, String content, Object createTime) {
        this.id = id;
        this.board_id = board_id;
        this.author_id = author_id;
        this.title = title;
        this.content = content;
        this.created_date=LocalDateTime.now();
    }

    public Article(Long board_id, Long author_id, String title, String content) {
        this.board_id = board_id;
        this.author_id = author_id;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getauthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id=author_id;
    }

    public long getBoard_id() {
        return board_id;
    }

    public void setBoard_id(Long board_id) {
        this.board_id = board_id;
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

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }

    public LocalDateTime getModified_date() {
        return modified_date;
    }

    public void setModified_date(LocalDateTime modified_date) {
        this.modified_date = modified_date;
    }
}
