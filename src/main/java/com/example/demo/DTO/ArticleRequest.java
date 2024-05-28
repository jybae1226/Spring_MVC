package com.example.demo.DTO;

public record ArticleRequest(
    Long board_id,
    Long author_id,
    String title,
    String content
) {}
