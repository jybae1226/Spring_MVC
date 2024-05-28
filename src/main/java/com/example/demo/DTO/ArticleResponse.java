package com.example.demo.DTO;

import java.time.LocalDateTime;
import com.example.demo.ETC.Model.Member;
import com.example.demo.ETC.Model.Board;
import com.example.demo.ETC.Model.Article;

public record ArticleResponse(
    Long id,
    Long board_id,
    Long author_id,
    String title,
    String content,
    LocalDateTime created_date,
    LocalDateTime modified_date
) {
    public static ArticleResponse of(Article article, Board board, Member member) {

        return new ArticleResponse(article.getId(), article.getauthor_id(), article.getBoard_id(),article.getTitle(), article.getContent(), LocalDateTime.now(), LocalDateTime.now());
    }
}
