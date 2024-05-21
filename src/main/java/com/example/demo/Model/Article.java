package com.example.demo.Model;

import java.time.LocalDateTime;

public class Article {
    private Long id;
    private Long board_id;
    private Long user_id;
    private String title;
    private String content;
    private LocalDateTime create_date;
    private LocalDateTime update_date;

    public Article(Long id, Long user_id, Long board_id, String title, String content) {
        this.id = id;
        this.user_id=user_id;
        this.board_id=board_id;
        this.title = title;
        this.content = content;
        this.create_date=LocalDateTime.now();
        this.update_date=LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id=user_id;
    }

    public Long getBoard_id() {
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

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }

    public LocalDateTime getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(LocalDateTime update_date) {
        this.update_date = update_date;
    }
}
