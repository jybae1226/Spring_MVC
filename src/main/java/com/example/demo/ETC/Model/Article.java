package com.example.demo.ETC.Model;

import java.time.LocalDateTime;

public class Article {
    private Long id;
    private Long board_id;
    private Long user_id;
    private String title;
    private String content;
    private LocalDateTime create_date;
    private LocalDateTime update_date;

    public Article(Long id, String title) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.create_date=LocalDateTime.now();
        this.update_date=LocalDateTime.now();
    }

    public Article(Long id, Long user_Id, Long board_Id, String title, String content, LocalDateTime createTime) {
        this.id = id;
        this.user_id = user_Id;
        this.board_id = board_Id;
        this.title = title;
        this.content = content;
        this.create_date=LocalDateTime.now();
    }

    public Article(Long board_id, Long user_id, String title, String content) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id=user_id;
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
