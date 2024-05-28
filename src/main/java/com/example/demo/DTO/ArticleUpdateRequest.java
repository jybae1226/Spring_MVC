package com.example.demo.DTO;

public record ArticleUpdateRequest(
        Long board_id,
        String title,
        String content ) {
}
